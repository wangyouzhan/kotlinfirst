package com.avic.kotlinfirst.mvpsample.ui.main

interface MVPPresenter<V> {

    fun attachView(view: V)

    fun detachView()
}