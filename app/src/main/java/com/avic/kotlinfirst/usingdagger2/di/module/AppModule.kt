package com.avic.kotlinfirst.usingdagger2.di.module

import android.app.Application
import android.content.Context
import com.avic.kotlinfirst.usingdagger2.ApplicationContext
import dagger.Module
import dagger.Provides

@Module
class AppModule(val app: Application) {

    @Provides
    fun provideApplication(): Application{
        return app
    }

    @Provides
    @ApplicationContext
    fun provideContext(): Context{
        return app
    }




}