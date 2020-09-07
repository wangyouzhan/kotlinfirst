package com.avic.kotlinfirst.coroutineAdapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.avic.kotlinfirst.R
import kotlinx.android.synthetic.main.list_row_coroutine.view.*

class MovieAdapter(private val movieNameList: MutableList<String>,
        private val castList: MutableList<String>) : RecyclerView.Adapter<MovieAdapter.MyViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_row_coroutine, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movieNameList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindItems(movieNameList[position], castList[position])
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bindItems(movieName: String, crewResultList: String){
            itemView.movie_title_text.text = movieName
            itemView.crew_result_text_view.text = crewResultList
        }
    }

}