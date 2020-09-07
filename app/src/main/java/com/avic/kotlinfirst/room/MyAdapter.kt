package com.avic.kotlinfirst.room

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.avic.kotlinfirst.R
import kotlinx.android.synthetic.main.item_room_layout.view.*

class MyAdapter(val context: Context, val superHeroList: List<SuperHero>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.item_room_layout, parent, false)
        return MyViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder?.bindItems(superHeroList[position])
    }

    override fun getItemCount(): Int {
        return superHeroList.size
    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bindItems(superHero: SuperHero){
            itemView.superHeroName.text = "Name:${superHero.SuperheroName}"
            itemView.superHeroPower.text = "Power: ${superHero.Power}"
            itemView.superHeroSeries.text = "Series: ${superHero.SuperHeroSeries}"
        }
    }




}






