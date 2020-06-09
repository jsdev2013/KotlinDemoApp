package com.jisu.kotlindemoapp.class02

import android.content.Intent
import android.os.Bundle
import com.jisu.kotlindemoapp.*
import kotlinx.android.synthetic.main.activity_class02.*

class Class02Activity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class02)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        listViewBtn.setOnClickListener {
            val myIntent = Intent(this, Class02ListViewActivity::class.java)
            startActivity(myIntent)
        }

        recyclerViewBtn.setOnClickListener {
            val myIntent = Intent(this, Class02RecyclerViewActivity::class.java )
            startActivity(myIntent)
        }

        listViewZickbangBtn.setOnClickListener {
            val myIntent = Intent(this, Class02ListViewZickbangActivity::class.java)
            startActivity(myIntent)
        }

        recyclerViewZickbangBtn.setOnClickListener {
            val myIntent = Intent(this, Class02RecyclerViewZickbangActivity::class.java)
            startActivity(myIntent)
        }

        androidLifeCycleBtn.setOnClickListener {
            val myIntent = Intent(this, Class02AndroidLifeCycleActivity::class.java)
            startActivity(myIntent)
        }

        fragmentLayoutBtn.setOnClickListener {
            val myIntent = Intent(this, Class02FragmentLayoutActivity::class.java)
            startActivity(myIntent)
        }

        fragmentViewPagerBtn.setOnClickListener {
            val myIntent = Intent(this, Class02FragmentViewPagerActivity::class.java)
            startActivity(myIntent)
        }
    }

    override fun setValues() {

    }
}
