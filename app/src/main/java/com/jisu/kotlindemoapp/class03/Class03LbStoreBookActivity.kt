package com.jisu.kotlindemoapp.class03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jisu.kotlindemoapp.BaseActivity
import com.jisu.kotlindemoapp.R
import com.jisu.kotlindemoapp.class03.adapter.MyPagerAdapter
import kotlinx.android.synthetic.main.activity_class03_lb_store_book.*

class Class03LbStoreBookActivity : BaseActivity() {

    lateinit var myPagerAdater: MyPagerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class03_lb_store_book)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        myPagerAdater = MyPagerAdapter(supportFragmentManager, "StoreMain")
        myViewPager.adapter = myPagerAdater

        myTabLayout.setupWithViewPager(myViewPager)
    }

    override fun setValues() {

    }
}
