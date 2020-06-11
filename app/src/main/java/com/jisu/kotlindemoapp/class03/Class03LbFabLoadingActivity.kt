package com.jisu.kotlindemoapp.class03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jisu.kotlindemoapp.BaseActivity
import com.jisu.kotlindemoapp.R
import io.saeid.fabloading.LoadingView
import kotlinx.android.synthetic.main.activity_class03_lb_fab_loading.*

class Class03LbFabLoadingActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class03_lb_fab_loading)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

//        loadingView.addAnimation("@color/blue", "@drawable/pic_bts", LoadingView.FROM_LEFT)
//
//        loadingView.addListener(LoadingView.LoadingListener() {
//            })

    }

    override fun setValues() {

    }

}
