package com.avic.kotlinfirst.mvpsample.di.component

import com.avic.kotlinfirst.mvpsample.di.MVPPerActivity
import com.avic.kotlinfirst.mvpsample.di.module.MVPActivityModule
import com.avic.kotlinfirst.mvpsample.ui.main.MVPMainActivity
import dagger.Component

@MVPPerActivity
@Component(modules = arrayOf(MVPActivityModule::class), dependencies = arrayOf(MVPAppComponent::class))
interface MVPActivityComponent {

    fun inject(mainActivity: MVPMainActivity)

}