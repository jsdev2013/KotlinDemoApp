package com.jisu.kotlindemoapp.class02

import androidx.appcompat.app.AppCompatActivity
import com.jisu.kotlindemoapp.R
import android.os.Bundle
import com.jisu.kotlindemoapp.class02.adapters.MyPagerAdapter
import kotlinx.android.synthetic.main.activity_class02_fragment_view_pager.*

class Class02FragmentViewPagerActivity : AppCompatActivity() {

    lateinit var myPagerAdapter: MyPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class02_fragment_view_pager)

        myPagerAdapter = MyPagerAdapter(supportFragmentManager)
        myViewPager.adapter = myPagerAdapter
    }
}
