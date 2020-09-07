package com.avic.kotlinfirst

import android.graphics.drawable.Animatable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_animate.*

class AnimateActivity : AppCompatActivity() {


    private lateinit var animatable: Animatable


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animate)
        animatable = animatedImageView.drawable as Animatable
    }

    override fun onStart() {
        super.onStart()
        startButton.setOnClickListener {
            animatable.start()
        }
    }


}