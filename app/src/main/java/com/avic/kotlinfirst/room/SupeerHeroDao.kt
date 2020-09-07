package com.avic.kotlinfirst.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface SuperHeroDao {

    @Query("Select * from superhero")
    fun getAllHeroes(): List<SuperHero>

    @Insert
    fun insert(superHero: SuperHero)

    @Delete
    fun delete(superHero: SuperHero)

}