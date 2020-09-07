package com.avic.kotlinfirst.databinding

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.avic.kotlinfirst.R

class BindingActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val binding: ActivityBindingBinding = DataBindingUtil.setContentView(this, R.layout.activity_binding)

        binding.user = User("Amanjeet Singh", 21, "amanjeetsingh150@gmail.com")

    }
}