package com.avic.kotlinfirst.mvvmsample.utils

import com.avic.kotlinfirst.mvvmsample.model.MVVMQuestionResult
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MVVMDataManager @Inject constructor(private var apiInterface: MVVMApiInterface) {

    fun questions(pageNo: Int): Observable<MVVMQuestionResult>{
        return apiInterface.questions(pageNo)
    }
}