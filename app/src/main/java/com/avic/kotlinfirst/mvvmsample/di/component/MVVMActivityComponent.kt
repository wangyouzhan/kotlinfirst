package com.avic.kotlinfirst.mvvmsample.di.component

import com.avic.kotlinfirst.mvpsample.di.MVPPerActivity
import com.avic.kotlinfirst.mvvmsample.di.module.MVVMActivityModule
import com.avic.kotlinfirst.mvvmsample.ui.MVVMMainActivity
import dagger.Component

@MVPPerActivity
@Component(modules = arrayOf(MVVMActivityModule::class), dependencies = arrayOf(MVVMAppComponent::class))
interface MVVMActivityComponent {

    fun inject(mainActivity: MVVMMainActivity)

}