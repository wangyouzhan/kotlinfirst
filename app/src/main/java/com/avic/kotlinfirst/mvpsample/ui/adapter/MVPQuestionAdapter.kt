package com.avic.kotlinfirst.mvpsample.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.avic.kotlinfirst.R
import com.avic.kotlinfirst.mvpsample.data.ResultData
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_question.view.*
import java.util.logging.Logger

class MVPQuestionAdapter(private val questList: List<ResultData>, val context: Context): RecyclerView.Adapter<MVPQuestionAdapter.MyViewHolder>(){


    companion object{
        val log = Logger.getLogger(MVPQuestionAdapter::class.java.name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_question, parent, false)
        return MyViewHolder(view,context)
    }

    override fun getItemCount(): Int {
        return questList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val title = questList[position].title
        val desc = questList[position].title
        holder.bindItems(title, desc)
    }


    class MyViewHolder(itemView: View, val context: Context): RecyclerView.ViewHolder(itemView){
        fun bindItems(url: String, title: String){
            itemView.movie_title_textview.text = title

            Glide.with(context).load(url).placeholder(R.mipmap.ic_launcher).into(itemView.imageview_movie_element)


        }
    }


}