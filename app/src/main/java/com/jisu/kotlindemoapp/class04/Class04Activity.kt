package com.jisu.kotlindemoapp.class04

import android.content.Intent
import android.os.Bundle
import com.jisu.kotlindemoapp.BaseActivity
import com.jisu.kotlindemoapp.R
import kotlinx.android.synthetic.main.activity_class04.*

class Class04Activity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class04)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        dbRoomBtn.setOnClickListener {
            val myIntent = Intent(mContext, Class04DbRoomRecyclerViewActivity::class.java)
            startActivity(myIntent)
        }

        dbRestfulApiBtn.setOnClickListener {
            val myIntent = Intent(mContext, Class04DbRestApiLoginActivity::class.java)
            startActivity(myIntent)
        }
    }

    override fun setValues() {

    }
}
