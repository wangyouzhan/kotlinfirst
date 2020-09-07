package com.avic.kotlinfirst.mvvmsample.di.component

import android.content.Context
import com.avic.kotlinfirst.mvvmsample.di.MVVMAplicationContext
import com.avic.kotlinfirst.mvvmsample.di.module.MVVMAppModule
import com.avic.kotlinfirst.mvvmsample.di.module.MVVMNetModule
import com.avic.kotlinfirst.mvvmsample.utils.MVVMDataManager
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = arrayOf(MVVMAppModule::class, MVVMNetModule::class))
interface MVVMAppComponent {


    @MVVMAplicationContext
    fun context(): Context


    fun mVPDataManager(): MVVMDataManager




}