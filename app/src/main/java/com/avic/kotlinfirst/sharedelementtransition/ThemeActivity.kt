package com.avic.kotlinfirst.sharedelementtransition

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityOptionsCompat
import com.avic.kotlinfirst.R
import kotlinx.android.synthetic.main.activity_theme.*

class ThemeActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_theme)

        card_view.setOnClickListener {
            val intent = Intent(this, TransitionActivity::class.java)
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this, card_view as View, getString(R.string.transition_string))
                startActivity(intent, options.toBundle())
            }else{
                startActivity(intent)
            }
        }




    }
}