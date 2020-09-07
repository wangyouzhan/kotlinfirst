package com.avic.kotlinfirst.usingdagger2.main

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.avic.kotlinfirst.InitApp
import com.avic.kotlinfirst.R
import com.avic.kotlinfirst.usingdagger2.di.component.DaggerActivityComponent
import com.avic.kotlinfirst.usingdagger2.di.module.ActivityModule
import kotlinx.android.synthetic.main.activity_dagger.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainView {

    @Inject
    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger)


        val activityComponent = DaggerActivityComponent.builder()
            .applicationComponent(InitApp.get(this).component())
            .activityModule(ActivityModule(this))
            .build()
        activityComponent.inject(this)
        mainPresenter.setView(this)
        mainPresenter.showData()

    }

    override fun showLoading() {

    }

    override fun showMessage(message: String) {
        toast(message)
        main_text_view.text = "Hey $message"
    }

    override fun hideLoading() {

    }

    fun Context.toast(message: CharSequence, duration: Int = Toast.LENGTH_LONG) {
        Toast.makeText(this, message, duration).show()
    }


}