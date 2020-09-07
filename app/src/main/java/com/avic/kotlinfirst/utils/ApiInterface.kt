package com.avic.kotlinfirst.utils

import com.avic.kotlinfirst.model.AutoCompleteResult
import com.avic.kotlinfirst.model.DetailsResult
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("autocomplete/json")
    fun getResults(@Query("input") input: String,
                   @Query("types") types: String,
                   @Query("key") key: String) : Observable<AutoCompleteResult>


    fun getDetails(@Query("placeid") palceId: String,
                   @Query("key") key: String) : Observable<DetailsResult>


    companion object{

        fun create(): ApiInterface{
            val retroFit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(Constants.BASE_URL)
                .build()
            return retroFit.create(ApiInterface::class.java)
        }

    }



}






















