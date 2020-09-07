package com.avic.kotlinfirst.usingdagger2.main

class MainPresenter() {

    lateinit var mainView:MainView

    fun setView(mainView: MainView){
        this.mainView = mainView
    }

    fun showData(){
        mainView.showLoading()
        mainView.showMessage("Hey Dagger2 Worked")
        mainView.hideLoading()
    }

}