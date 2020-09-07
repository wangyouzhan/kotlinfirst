package com.avic.kotlinfirst.usingdagger2.di.module

import android.app.Activity
import android.content.Context
import com.avic.kotlinfirst.usingdagger2.ActivityContext
import com.avic.kotlinfirst.usingdagger2.PerActivity
import com.avic.kotlinfirst.usingdagger2.main.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class ActivityModule(val activity: Activity) {

    @Provides
    fun providesActivity(): Activity{
        return activity
    }


    @Provides
    @ActivityContext
    fun providesContext(): Context{
        return activity
    }

    @PerActivity
    @Provides
    fun provideMainPresenter(): MainPresenter {
        return MainPresenter()
    }



}