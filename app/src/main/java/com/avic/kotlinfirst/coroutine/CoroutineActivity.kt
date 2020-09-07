package com.avic.kotlinfirst.coroutine

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.avic.kotlinfirst.R
import kotlinx.android.synthetic.main.activity_coroutine2.*
import kotlinx.coroutines.*

class CoroutineActivity : AppCompatActivity() {


    private val parentJob = Job()
    private val coroutinesScope = CoroutineScope(Dispatchers.IO + parentJob)

    companion object{
        private var TAG = CoroutineActivity::class.java.simpleName
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutine2)

        button_search.setOnClickListener {
            progress_bar.visibility = View.VISIBLE
            coroutinesScope.launch(Dispatchers.Main){
                sendMail()
            }
        }

    }

    private suspend fun sendMail(){
        val mailId = coroutinesScope.async(Dispatchers.IO){
            getMailFromDB()
        }
        val mailMsg = coroutinesScope.async(Dispatchers.IO){
            getMessageFromDB()
        }
        mail_id_text_view.text = String.format(getString(R.string.email_id_string), mailId.await())
        msg_text_view.text = String.format(getString(R.string.email_msg), mailMsg.await())

        val msg = coroutinesScope.async(Dispatchers.IO){
            sendMsgFromApi(mailId.await(), mailMsg.await())
        }

        progress_bar.visibility = View.GONE
    }

    private suspend fun sendMsgFromApi(mailId: String, msg: String): String{
        delay(2000)
        return "$msg to $mailId"
    }

    private suspend fun getMailFromDB(): String{
        delay(3000)
        Log.d(TAG, "Got Mail Id from DB")
        return "amanjeetsingh150@gmail.com"
    }

    private suspend fun getMessageFromDB(): String{
        delay(3000)
        //query from DB will be here
        Log.d(TAG, "Got Msg from DB")
        return "This is an example for coroutines"
    }



}

















