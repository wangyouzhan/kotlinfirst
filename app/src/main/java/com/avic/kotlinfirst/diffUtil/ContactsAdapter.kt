package com.avic.kotlinfirst.diffUtil

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.avic.kotlinfirst.R
import kotlinx.android.synthetic.main.item_contact.view.*
import java.util.logging.Logger

class ContactsAdapter(private val context: Context,
                        private val personList: MutableList<Person>
                      ): RecyclerView.Adapter<ContactsAdapter.MyViewHolder>(){

    companion object{
        val log = Logger.getLogger(ContactsAdapter::class.java.name)
    }

    override fun getItemCount(): Int {
        return personList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItems(personList[position])
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int, payloads: MutableList<Any>) {
        if (payloads.isEmpty()){
            super.onBindViewHolder(holder, position, payloads)
        }else{
            val bundle = payloads[0] as Bundle
            for(key in bundle.keySet()){
                if (key == "name"){
                    holder.itemView.name_text_view.text = personList[position].name
                }
                if (key == "status"){
                    log.info("Changes are ready to show")
                    holder.itemView.status_text_view.text = personList[position].status
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_contact, parent, false)
        return MyViewHolder(view)
    }



    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bindItems(person: Person){
            itemView.name_text_view.text = person.name
            itemView.status_text_view.text = person.status
        }
    }


    fun updateData(newList: List<Person>){
        val diffResult = DiffUtil.calculateDiff(ContactDiffUtilCallBack(newList, personList))
        diffResult.dispatchUpdatesTo(this)
        this.personList.clear()
        this.personList.addAll(newList)
    }


}