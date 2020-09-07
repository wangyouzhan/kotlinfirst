package com.avic.kotlinfirst.diffUtil

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.avic.kotlinfirst.R
import kotlinx.android.synthetic.main.activity_contact.*
import java.util.logging.Logger

class ContactActivity : AppCompatActivity() {



    private lateinit var contactAdapter: ContactsAdapter

    companion object{
        val log = Logger.getLogger(ContactActivity::class.java.name)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        val linearLayoutManager = LinearLayoutManager(applicationContext)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        recycler_view_main.layoutManager = linearLayoutManager
        val dataSource = DataSource()
        contactAdapter = ContactsAdapter(applicationContext, dataSource.getData())
        recycler_view_main.adapter = contactAdapter
        val dividerItemDecoration = DividerItemDecoration(recycler_view_main.context, linearLayoutManager.orientation)
        swipeRefreshLayout.setOnRefreshListener {
            contactAdapter.updateData(dataSource.getUpdatedData())
            log.info(dataSource.getUpdatedData()[0].status)
            swipeRefreshLayout.isRefreshing = false
        }




    }





}
















