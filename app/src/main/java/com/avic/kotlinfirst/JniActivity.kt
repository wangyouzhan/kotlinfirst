package com.avic.kotlinfirst

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class JniActivity:AppCompatActivity(){

    //Our Jni method
    external fun getKey(key:Int):Int

    companion object {
        init {
            System.loadLibrary("sample-jni")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jni)

        Toast.makeText(this,getKey(55).toString(),Toast.LENGTH_SHORT).show()
    }

}