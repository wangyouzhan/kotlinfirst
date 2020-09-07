package com.avic.kotlinfirst.objectanimator

import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.avic.kotlinfirst.R
import kotlinx.android.synthetic.main.activity_object_animator.*

class ObjectAnimatorActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_object_animator)

        animate_button.setOnClickListener {
            val animator = ObjectAnimator.ofFloat(textView, "textSize", 12f)
            animator.duration = 800
            animator.start()
        }

    }




}