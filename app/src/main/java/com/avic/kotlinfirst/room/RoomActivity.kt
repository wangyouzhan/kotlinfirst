package com.avic.kotlinfirst.room

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.avic.kotlinfirst.R
import kotlinx.android.synthetic.main.activity_room.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.util.logging.Logger

class RoomActivity : AppCompatActivity() {


    companion object{
        lateinit var dataBase: MyDataBase
        val log = Logger.getLogger(RoomActivity::class.java.name)
    }

    lateinit var superheroList: List<SuperHero>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_room)

        dataBase = Room.databaseBuilder(this, MyDataBase::class.java, "room-db").build()

        val superhero1 = SuperHero("SpiderMan", "Marvel", "WEB")
        val superhero2 = SuperHero("SuperMan", "DC", "KRYPTONITE")
        val superhero3 = SuperHero("BatMan", "DC", "MONEY")

        GlobalScope.launch {

            dataBase.superheroDao().insert(superhero1)
            dataBase.superheroDao().insert(superhero2)
            dataBase.superheroDao().insert(superhero3)
            superheroList = dataBase.superheroDao().getAllHeroes()
            runOnUiThread {
                log.info("DATA" +superheroList)
                superhero_list_recycler_view.layoutManager = LinearLayoutManager(applicationContext, RecyclerView.VERTICAL, false)
                superhero_list_recycler_view.adapter = MyAdapter(applicationContext, superheroList)
            }
        }
    }

}




















