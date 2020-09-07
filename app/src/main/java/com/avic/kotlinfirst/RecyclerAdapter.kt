package com.avic.kotlinfirst

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_row_item.view.*

class RecyclerAdapter(private val myAndroidOsList: List<String>, private val context: Context) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.MyViewHolder {

        val v = LayoutInflater.from(context).inflate(R.layout.list_row_item,parent, false)

        return MyViewHolder(v)

    }

    override fun getItemCount(): Int {
        return myAndroidOsList.size
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.MyViewHolder, position: Int) {
        holder.bindItems(myAndroidOsList[position])
    }


    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bindItems(myAndroidOsListName: String){
            itemView.android_name_text_view.text = myAndroidOsListName

        }

    }


}