package com.avic.kotlinfirst.usingdagger2.di.component

import com.avic.kotlinfirst.usingdagger2.PerActivity
import com.avic.kotlinfirst.usingdagger2.di.module.ActivityModule
import com.avic.kotlinfirst.usingdagger2.main.MainActivity
import dagger.Component

@PerActivity
@Component(modules = arrayOf(ActivityModule::class), dependencies = arrayOf(ApplicationComponent::class))
interface ActivityComponent {

    fun inject(mainActivity: MainActivity)
}