package com.avic.kotlinfirst.mvvmsample.ui

import com.avic.kotlinfirst.mvvmsample.model.MVVMResultData
import com.avic.kotlinfirst.mvvmsample.utils.MVVMDataManager
import com.avic.kotlinfirst.mvvmsample.utils.SchedulerProvider
import io.reactivex.Observable
import javax.inject.Inject

class MVVMMainViewModel @Inject constructor(private var dataManager: MVVMDataManager,
                                            private var schedulerProvider: SchedulerProvider) {

    var loading: Boolean? = null

    fun setIsLoading(loading: Boolean){
        this.loading = loading
    }

    fun questionList(query: String): Observable<List<MVVMResultData>>?{
        setIsLoading(true)
        return dataManager.questions(1)
            .subscribeOn(schedulerProvider.io())
            .observeOn(schedulerProvider.ui())
            .map{result -> result.data}
    }


    fun isValidQuery(query: String): Boolean{
        if (query.isEmpty()){
            return false
        }
        return true
    }

}