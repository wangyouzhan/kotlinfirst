package com.avic.kotlinfirst.bottomsheets

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.avic.kotlinfirst.R
import kotlinx.android.synthetic.main.list_recycler_view.view.*

class MenuAdapter(private val context: Context, private val listImages: List<Int>) : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>(){



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.list_recycler_view, parent, false)
        return MenuViewHolder(view)
    }



    override fun getItemCount(): Int {
        return 4
    }

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bindItems(listImages[position])
    }




    class MenuViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(image: Int) {
            itemView.image_card_view.setImageResource(image)
        }
    }
}