package com.avic.kotlinfirst.mvvmsample.di.module

import android.app.Application
import android.content.Context
import com.avic.kotlinfirst.mvvmsample.di.MVVMAplicationContext
import com.avic.kotlinfirst.mvvmsample.utils.MVVMApiInterface
import com.avic.kotlinfirst.mvvmsample.utils.MVVMDataManager
import com.avic.kotlinfirst.mvvmsample.utils.SchedulerProvider
import dagger.Module
import dagger.Provides


@Module
class MVVMAppModule (val app: Application){


    @Provides
    fun providesApp(): Application{
        return  app
    }

    @Provides
    @MVVMAplicationContext
    fun providesContext(): Context{
        return app
    }

    @Provides
    fun prvoidesSchedulers(): SchedulerProvider{
        return SchedulerProvider()
    }

    @Provides
    fun providesDataManager(apiInterface: MVVMApiInterface): MVVMDataManager{
        return MVVMDataManager(apiInterface)
    }


}