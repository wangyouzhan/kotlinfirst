package com.avic.kotlinfirst.mvpsample.ui.main

import com.avic.kotlinfirst.mvpsample.data.MVPDataManager
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.logging.Logger
import javax.inject.Inject

class MVPMainPresenter<V: MVPMainView> @Inject constructor(private var dataManager:MVPDataManager): MVPMainMvpPresenter<V> {

    var view: MVPMainView? = null

    companion object{
        val log = Logger.getLogger(MVPMainMvpPresenter::class.java.name)
    }

    override fun searchQuestionQuery(query: String, key: String) {
        view?.showLoading()

        if (query.isEmpty()){
            view?.showError("Blank field not allowed.")
            view?.hideLoading()
        }else{
            dataManager.questions(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({result ->
                    val questionList = result.data
                    log.info(" " + questionList[0].title)
                    view?.showData(questionList)
                    view?.hideLoading()
                },{e ->
                    view?.hideLoading()
                    view?.showError(e.message.toString())
                })
        }
    }

    override fun attachView(view: V) {
        this.view = view
    }

    override fun detachView() {
        view = null
    }

}