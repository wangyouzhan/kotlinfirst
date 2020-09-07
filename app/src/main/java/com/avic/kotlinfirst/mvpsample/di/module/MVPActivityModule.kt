package com.avic.kotlinfirst.mvpsample.di.module

import android.app.Activity
import android.content.Context
import com.avic.kotlinfirst.mvpsample.di.MVPPerActivity
import com.avic.kotlinfirst.mvpsample.ui.main.MVPMainMvpPresenter
import com.avic.kotlinfirst.mvpsample.ui.main.MVPMainPresenter
import com.avic.kotlinfirst.mvpsample.ui.main.MVPMainView
import com.avic.kotlinfirst.usingdagger2.ActivityContext
import dagger.Module
import dagger.Provides


@Module
class MVPActivityModule(val activity: Activity) {




    @Provides
    fun providesActivity(): Activity{
        return activity
    }

    @Provides
    @ActivityContext
    fun providesContext(): Context{
        return activity
    }

    @MVPPerActivity
    @Provides
    fun providesMVPMainMvpPresenter(mvpMainMvpPresenter: MVPMainPresenter<MVPMainView>): MVPMainMvpPresenter<MVPMainView>{
        return mvpMainMvpPresenter
    }



}