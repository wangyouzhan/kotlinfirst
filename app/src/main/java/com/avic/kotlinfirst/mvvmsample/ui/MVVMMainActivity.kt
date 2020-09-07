package com.avic.kotlinfirst.mvvmsample.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.avic.kotlinfirst.InitApp
import com.avic.kotlinfirst.R
import com.avic.kotlinfirst.mvvmsample.adapter.MVVMQuestionAdapter
import com.avic.kotlinfirst.mvvmsample.di.component.DaggerMVVMActivityComponent
import com.avic.kotlinfirst.mvvmsample.di.module.MVVMActivityModule
import com.avic.kotlinfirst.mvvmsample.model.MVVMResultData
import com.avic.kotlinfirst.mvvmsample.utils.SchedulerProvider
import com.google.android.material.snackbar.Snackbar
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_mvvm_main.*
import java.util.logging.Logger
import javax.inject.Inject

class MVVMMainActivity : AppCompatActivity() {


    @Inject
    lateinit var mainViewModel: MVVMMainViewModel

    private lateinit var compositeDisposable: CompositeDisposable
    private var disposable: Disposable? = null

    companion object{
        val log = Logger.getLogger(MVVMMainActivity::class.java.name)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvm_main)

        compositeDisposable = CompositeDisposable()
        val activityComponent = DaggerMVVMActivityComponent.builder()
            .mVVMAppComponent(InitApp.get(this).mvvmCommponent())
            .mVVMActivityModule(MVVMActivityModule(SchedulerProvider()))
            .build()
        activityComponent.inject(this)

        search_button.setOnClickListener {
            hideKeyboard()
            val query = query_edit_text.text.toString()
            if (mainViewModel.isValidQuery(query)){
                if (mainViewModel.loading == true){
                    progress_bar.visibility = View.VISIBLE
                }
                disposable = mainViewModel.questionList(query)?.subscribe ({ result ->
                    log.info(result[0].title)
                    showList(result)
                    mainViewModel.setIsLoading(false)
                },{e->e.printStackTrace()})
            }else{
                Snackbar.make(layout_main,
                    "Not a valid Query", Snackbar.LENGTH_SHORT).show()
            }
        }




    }

    override fun onResume() {
        super.onResume()
        if (disposable != null){
            bind()
        }
    }

    private fun bind(){
        compositeDisposable.add(disposable!!)
    }

    private fun unbind(){
        compositeDisposable.clear()
    }


    override fun onPause() {
        super.onPause()
        if (compositeDisposable.size() > 0){
            unbind()
        }
    }

    private fun hideKeyboard(){
        val view = this.currentFocus
        if (view != null){
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }


    private fun showList(result: List<MVVMResultData>){
        val linearLayoutManager = LinearLayoutManager(applicationContext)
        linearLayoutManager.orientation = RecyclerView.VERTICAL
        val movieAdapter = MVVMQuestionAdapter(result, applicationContext)
        with(movie_recycler_view){
            layoutManager = linearLayoutManager
            adapter = movieAdapter
        }
    }



}



























