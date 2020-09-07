package com.avic.kotlinfirst.mvpsample.ui.main

import com.avic.kotlinfirst.mvpsample.data.ResultData

interface MVPMainView {

    fun showLoading()

    fun showData(movieResult: List<ResultData>)

    fun showError(error: String)

    fun hideLoading()


}