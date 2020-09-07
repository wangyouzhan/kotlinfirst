package com.avic.kotlinfirst.usingdagger2.main

interface MainView {

    fun showLoading()

    fun showMessage(message: String)

    fun hideLoading()

}