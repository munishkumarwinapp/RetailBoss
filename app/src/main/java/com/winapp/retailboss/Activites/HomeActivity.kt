package com.winapp.retailboss.Activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.winapp.retailboss.Fragments.*
import com.winapp.retailboss.R
import nl.joery.animatedbottombar.AnimatedBottomBar

class HomeActivity : AppCompatActivity() {

    lateinit var bottom_bar:AnimatedBottomBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        supportActionBar?.hide()
        bottom_bar = findViewById(R.id.animatedBottomBar)
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.home_frame_layout, DashBoardFragment()).commit()
        tabSelectListner()
    }

    private fun tabSelectListner(){
        bottom_bar.setOnTabSelectListener(object : AnimatedBottomBar.OnTabSelectListener {
            override fun onTabSelected(lastIndex: Int, lastTab: AnimatedBottomBar.Tab?, newIndex: Int, newTab: AnimatedBottomBar.Tab) {
                when (newIndex) {

                    0 -> {
                        val fragmentManager = supportFragmentManager
                        val fragmentTransaction = fragmentManager.beginTransaction()
                        fragmentTransaction.replace(R.id.home_frame_layout, DashBoardFragment()).commit()
                    }

                    1 -> {
                        val fragmentManager = supportFragmentManager
                        val fragmentTransaction = fragmentManager.beginTransaction()
                        fragmentTransaction.replace(R.id.home_frame_layout, SalesFragment()).commit()
                    }

                    2 -> {
                        val fragmentManager = supportFragmentManager
                        val fragmentTransaction = fragmentManager.beginTransaction()
                        fragmentTransaction.replace(R.id.home_frame_layout, SettlementFragment()).commit()
                    }

                    3 -> {
                        val fragmentManager = supportFragmentManager
                        val fragmentTransaction = fragmentManager.beginTransaction()
                        fragmentTransaction.replace(R.id.home_frame_layout, AnalyticsFragment())
                                .commit()
                    }

                    4 -> {

                        val fragmentManager = supportFragmentManager
                        val fragmentTransaction = fragmentManager.beginTransaction()
                        fragmentTransaction.replace(R.id.home_frame_layout, Settingfragment())
                                .commit()
                    }

                    else -> {
                        val fragmentManager = supportFragmentManager
                        val fragmentTransaction = fragmentManager.beginTransaction()
                        fragmentTransaction.replace(R.id.home_frame_layout, DashBoardFragment()).commit()
                    }
                }
            }
            override fun onTabReselected(index: Int, tab: AnimatedBottomBar.Tab) {}
        })
    }

}