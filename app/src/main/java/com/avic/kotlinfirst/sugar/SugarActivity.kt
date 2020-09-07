package com.avic.kotlinfirst.sugar

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.avic.kotlinfirst.R
import com.orm.SugarRecord
import kotlinx.android.synthetic.main.activity_sugar.*

class SugarActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sugar)

        val pokemon1 = Pokemon("Pikachu", "ash", "Electric")
        pokemon1.save()
        val pokemon2 = Pokemon("Onyx", "这是珍", "式三叶草")
        pokemon2.save()
        val pokemon3 = Pokemon("StarFish", "Misty", "Water")
        pokemon3.save()
        val pokemonList = SugarRecord.listAll(Pokemon::class.java)

        for(pokemon in pokemonList){
            pokemon_desc_textview.append(pokemon.name + " of " + pokemon.trainerName + " which is " + pokemon.pokemonType + " type.\n")
        }
        if (pokemon3.delete()){
            Toast.makeText(this, "deleted pokemon 3", Toast.LENGTH_SHORT).show()
        }


    }





}