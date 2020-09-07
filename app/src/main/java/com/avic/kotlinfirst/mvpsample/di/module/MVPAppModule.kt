package com.avic.kotlinfirst.mvpsample.di.module

import android.app.Application
import android.content.Context
import com.avic.kotlinfirst.mvpsample.di.MVPAplicationContext
import dagger.Module
import dagger.Provides


@Module
class MVPAppModule (val app: Application){


    @Provides
    fun providesApp(): Application{
        return  app
    }

    @Provides
    @MVPAplicationContext
    fun providesContext(): Context{
        return app
    }

}