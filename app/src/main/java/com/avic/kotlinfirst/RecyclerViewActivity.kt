package com.avic.kotlinfirst

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {


    val androidName = listOf<String>("Cupcake", "Donut", "Eclair", "Froyo",
        "Gingerbread", "Honeycomb", "Ice Cream Sandwich", "JellyBean", "Kitkat",
        "Lollipop", "Marshmallow", "Nougat", "Oreo")





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        recycler_view_name.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        recycler_view_name.adapter = RecyclerAdapter(androidName, this)

    }



}