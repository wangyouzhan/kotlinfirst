package com.avic.kotlinfirst.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "superhero")
data class SuperHero(
    @ColumnInfo(name = "superhero_name")
    var SuperheroName: String,
    @ColumnInfo(name = "superhero_series")
    var SuperHeroSeries: String,
    @ColumnInfo(name = "power")
    var Power: String){

    @ColumnInfo(name = "superhero_id")
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}

