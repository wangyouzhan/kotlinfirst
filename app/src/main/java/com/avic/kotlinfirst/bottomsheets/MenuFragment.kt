package com.avic.kotlinfirst.bottomsheets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.avic.kotlinfirst.R
import kotlinx.android.synthetic.main.fragment_menu.view.*

class MenuFragment : Fragment() {

    lateinit var pos: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val bundle = arguments
        val string = bundle?.getString("key")

        when(string){
            "0" -> {
                pos = "0"
            }
            "1" -> {
                pos = "1"
            }
            "2" -> {
                pos = "2"
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val v = inflater.inflate(R.layout.fragment_menu, container, false)
        when(pos){
            "0" -> {
                val imageList = listOf<Int>(R.drawable.ic_local_gas_station_grey_700_24dp,
                R.drawable.ic_local_grocery_store_grey_700_24dp,
                R.drawable.ic_local_atm_grey_700_24dp,
                R.drawable.ic_local_pharmacy_grey_700_24dp)
                val menuAdapter = MenuAdapter(activity!!.applicationContext, imageList)
                val grid = GridLayoutManager(activity, 2)
                v.recycler_view.layoutManager = grid
                v.recycler_view.adapter = menuAdapter
            }
            "1" -> {

            }
            "2" -> {

            }
        }
        return v
    }



}


























