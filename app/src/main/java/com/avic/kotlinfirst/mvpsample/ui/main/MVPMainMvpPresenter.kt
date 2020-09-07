package com.avic.kotlinfirst.mvpsample.ui.main

interface MVPMainMvpPresenter<V: MVPMainView> : MVPPresenter<V> {

    fun searchQuestionQuery(query: String, key: String)



}