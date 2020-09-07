package com.avic.kotlinfirst.mvpsample.ui.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.avic.kotlinfirst.BuildConfig
import com.avic.kotlinfirst.InitApp
import com.avic.kotlinfirst.R
import com.avic.kotlinfirst.mvpsample.data.ResultData
import com.avic.kotlinfirst.mvpsample.di.component.DaggerMVPActivityComponent
import com.avic.kotlinfirst.mvpsample.di.module.MVPActivityModule
import com.avic.kotlinfirst.mvpsample.ui.adapter.MVPQuestionAdapter
import com.google.android.material.snackbar.Snackbar
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_m_v_p_main.*
import java.util.logging.Logger
import javax.inject.Inject

class MVPMainActivity : AppCompatActivity(), MVPMainView {

    @Inject
    lateinit var mainPresenter: MVPMainMvpPresenter<MVPMainView>
    private var resultJSON: String? = null
    private val RESULT = "resultJson"
    private val gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_m_v_p_main)

        val activityComponent = DaggerMVPActivityComponent.builder()
            .mVPAppComponent(InitApp.get(this).mvpComponent())
            .mVPActivityModule(MVPActivityModule(this))
            .build();

        activityComponent.inject(this)
        mainPresenter.attachView(this)
        setListeners()

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState?.putString(RESULT, resultJSON)
    }


    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)

        val result = savedInstanceState?.getString(RESULT)
        val movieList = gson.fromJson<List<ResultData>>(result, object : TypeToken<List<ResultData>>(){}.type)
        if (movieList != null){
            setupRecyclerView(movieList)
            resultJSON = gson.toJson(movieList)
        }


    }


    private fun setupRecyclerView(movieResult: List<ResultData>){
        val linearLayoutManager = LinearLayoutManager(applicationContext)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        val movieAdapter = MVPQuestionAdapter(movieResult, applicationContext)
        with(movie_recycler_view){
            layoutManager = linearLayoutManager
            adapter = movieAdapter
        }

    }


    private fun setListeners(){
        search_button.setOnClickListener {
            mainPresenter.searchQuestionQuery(query_edit_text.text.toString(), BuildConfig.MOVIE_KEY)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        mainPresenter.detachView()
    }

    override fun showLoading() {
        progress_bar.visibility = View.VISIBLE
    }

    override fun showData(movieResult: List<ResultData>) {
        resultJSON = gson.toJson(movieResult)
        val linearLayoutManager = LinearLayoutManager(applicationContext)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        val questionAdapter = MVPQuestionAdapter(movieResult, applicationContext)
        with(movie_recycler_view){
            layoutManager = linearLayoutManager
            adapter = questionAdapter
        }
    }

    override fun showError(error: String) {
        val log =  Logger.getLogger("mvpMainActivity");
        log.info("---------------------" + error)
        Snackbar.make(layout_main, error, Snackbar.LENGTH_LONG).show()

    }

    override fun hideLoading() {
        progress_bar.visibility = View.GONE
    }


}