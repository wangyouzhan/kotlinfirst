package com.avic.kotlinfirst.mvvmsample.utils

import com.avic.kotlinfirst.mvvmsample.model.MVVMQuestionResult
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface MVVMApiInterface {

    @GET("questions/index")
    fun questions(@Query("pageNo") pageNo: Int): Observable<MVVMQuestionResult>

}