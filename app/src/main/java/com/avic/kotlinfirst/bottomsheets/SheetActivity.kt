package com.avic.kotlinfirst.bottomsheets

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.avic.kotlinfirst.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_sheet.*
import kotlinx.android.synthetic.main.bottom_sheet.*
import java.util.logging.Logger

class SheetActivity : AppCompatActivity() {


    var sheetBehavior: BottomSheetBehavior<*>?= null

    companion object{
        val log = Logger.getLogger(SheetActivity::class.java.name)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sheet)

        setSupportActionBar(toolbar)
        toolbar.setTitleTextColor(Color.WHITE)
        sheetBehavior = BottomSheetBehavior.from(bottom_sheet_layout)
        sheetBehavior?.setBottomSheetCallback(object :BottomSheetBehavior.BottomSheetCallback(){

            override fun onSlide(bottomSheet: View, slideOffset: Float) {
                log.info("On Slide")
            }

            override fun onStateChanged(bottomSheet: View, newState: Int) {
                log.info("On State changes")
            }
        })

        tab_layout.addTab(tab_layout.newTab().setIcon(R.drawable.ic_location_on_grey_600_24dp))
        tab_layout.addTab(tab_layout.newTab().setIcon(R.drawable.ic_directions_car_grey_700_24dp))
        tab_layout.addTab(tab_layout.newTab().setIcon(R.drawable.ic_directions_bus_grey_700_24dp))

        val adapter = ViewPagerAdapter(supportFragmentManager)
        view_pager.adapter = adapter
        view_pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))

    }




}





























