package com.avic.kotlinfirst.realm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.avic.kotlinfirst.R
import com.google.android.material.snackbar.Snackbar
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_realm.*

class RealmActivity : AppCompatActivity() {


    lateinit var realm: Realm
    lateinit var list: Sequence<Pokemon>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_realm)


        realm = Realm.getDefaultInstance()

        insert_button.setOnClickListener { view->
            realm.beginTransaction()
            val pokemon = realm.createObject(Pokemon::class.java)
            pokemon.name = pokemon_name_edittext.text.toString()
            pokemon.type = pokemon_type_edittext.text.toString()
            realm.commitTransaction()
            Snackbar.make(view, "Inserted", Snackbar.LENGTH_LONG).show()
        }

        delete_all_button.setOnClickListener { view ->
            realm.beginTransaction()
            realm.delete(Pokemon::class.java)
            realm.commitTransaction()
            Snackbar.make(view, getString(R.string.deleted_all), Snackbar.LENGTH_LONG).show()
        }

        view_button.setOnClickListener {
            list = realm.where(Pokemon::class.java)
                .findAllAsync()
                .asSequence()
            pokemon_text_view.text = "";
            if (list.count() > 0){
                for(pokemon in list){
                    pokemon_text_view.append(pokemon.name + " is " + pokemon.type + " type \n");
                }
            }else{
                pokemon_text_view.text = getString(R.string.no_value_string)
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }




}