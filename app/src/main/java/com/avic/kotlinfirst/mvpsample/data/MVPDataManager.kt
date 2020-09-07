package com.avic.kotlinfirst.mvpsample.data

import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MVPDataManager @Inject constructor(private var apiInterface: MVPApiInterface) {

    fun questions(pageNo: Int): Observable<QuestionResult>{
        return apiInterface.questions(pageNo)
    }
}