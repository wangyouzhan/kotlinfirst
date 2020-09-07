package com.avic.kotlinfirst.mvpsample.di.module

import com.avic.kotlinfirst.mvpsample.data.MVPApiInterface
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class MVPNetModule {

    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit{

        return Retrofit.Builder()
            .baseUrl("http://nm.rongrong.huazhi365.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideMVPApiInterface(retrofit: Retrofit): MVPApiInterface{
        return retrofit.create(MVPApiInterface::class.java)
    }



}