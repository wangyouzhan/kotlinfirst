package com.avic.kotlinfirst.mvpsample.di.component

import android.content.Context
import com.avic.kotlinfirst.mvpsample.data.MVPDataManager
import com.avic.kotlinfirst.mvpsample.di.MVPAplicationContext
import com.avic.kotlinfirst.mvpsample.di.module.MVPAppModule
import com.avic.kotlinfirst.mvpsample.di.module.MVPNetModule
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(MVPAppModule::class, MVPNetModule::class))
interface MVPAppComponent {


    @MVPAplicationContext
    fun context(): Context


    fun mVPDataManager(): MVPDataManager




}