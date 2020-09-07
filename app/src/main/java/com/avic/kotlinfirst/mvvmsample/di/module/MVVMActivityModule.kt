package com.avic.kotlinfirst.mvvmsample.di.module

import com.avic.kotlinfirst.mvvmsample.ui.MVVMMainViewModel
import com.avic.kotlinfirst.mvvmsample.utils.MVVMDataManager
import com.avic.kotlinfirst.mvvmsample.utils.SchedulerProvider
import dagger.Module
import dagger.Provides


@Module
class MVVMActivityModule(val schedulerProvider: SchedulerProvider) {


    @Provides
    fun provideMainViewModel(dataManager: MVVMDataManager) : MVVMMainViewModel{
        return MVVMMainViewModel(dataManager, schedulerProvider)
    }



}




















