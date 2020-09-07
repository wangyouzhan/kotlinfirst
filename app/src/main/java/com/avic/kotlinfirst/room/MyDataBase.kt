package com.avic.kotlinfirst.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(SuperHero::class), version = 1, exportSchema = false)
abstract class MyDataBase: RoomDatabase() {
    abstract fun superheroDao():SuperHeroDao
}