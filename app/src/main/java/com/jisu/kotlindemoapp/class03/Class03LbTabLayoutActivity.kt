package com.jisu.kotlindemoapp.class03

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jisu.kotlindemoapp.BaseActivity
import com.jisu.kotlindemoapp.R
import com.jisu.kotlindemoapp.class03.adapter.MyPagerAdapter
import kotlinx.android.synthetic.main.activity_class03_lb_tab_layout.*

class Class03LbTabLayoutActivity : BaseActivity() {

    lateinit var myPagerAdater: MyPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class03_lb_tab_layout)
        setupEvents()
        setValues()
    }
    override fun setupEvents() {
        myPagerAdater = MyPagerAdapter(supportFragmentManager, "Main")
        myViewPager.adapter = myPagerAdater

//        탭레이아웃과 뷰페이저를 연결
        myTabLayout.setupWithViewPager(myViewPager)
    }

    override fun setValues() {

    }
}
