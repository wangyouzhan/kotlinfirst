package com.avic.kotlinfirst.usingdagger2.di.component

import android.content.Context
import com.avic.kotlinfirst.usingdagger2.ApplicationContext
import com.avic.kotlinfirst.usingdagger2.di.module.AppModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface ApplicationComponent {

    @ApplicationContext
    fun context(): Context
}