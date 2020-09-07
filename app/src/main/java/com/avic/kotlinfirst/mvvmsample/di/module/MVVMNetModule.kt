package com.avic.kotlinfirst.mvvmsample.di.module

import com.avic.kotlinfirst.mvvmsample.utils.MVVMApiInterface
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
class MVVMNetModule {

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
    fun provideMVVMApiInterface(retrofit: Retrofit): MVVMApiInterface {
        return retrofit.create(MVVMApiInterface::class.java)
    }



}