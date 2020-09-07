package com.avic.kotlinfirst.mvpsample.data

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface MVPApiInterface {

    @GET("questions/index")
    fun questions(@Query("pageNo") pageNo: Int): Observable<QuestionResult>

}