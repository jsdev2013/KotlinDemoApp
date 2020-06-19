package com.jisu.kotlindemoapp.class03

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jisu.kotlindemoapp.BaseActivity
import com.jisu.kotlindemoapp.R
import kotlinx.android.synthetic.main.activity_class03.*

class Class03Activity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class03)
        setupEvents()
        setValues()
    }
    override fun setupEvents() {
        lbTabLayoutBtn.setOnClickListener {
            val myIntent = Intent(this, Class03LbTabLayoutActivity::class.java)
            startActivity(myIntent)
        }

        lbCircleImageBtn.setOnClickListener {
            val myIntent = Intent(this, Class03LbCircleImageViewActivity::class.java)
            startActivity(myIntent)
        }

        lbGlideTedPmBtn.setOnClickListener {
            val myIntent = Intent(this, Class03LbGlideTedPermissionActivity::class.java)
            startActivity(myIntent)
        }

        storeBookBtn.setOnClickListener {
            val myIntent = Intent(this, Class03LbStoreBookActivity::class.java)
            startActivity(myIntent)

        }

        baseballGameBtn.setOnClickListener {
            val myIntent = Intent(this, Class03BaseballGameActivity::class.java)
            startActivity(myIntent)
        }

        lbFabBtn.setOnClickListener {
            val myIntent = Intent(this, Class03LbFloatingActionButtonActivity::class.java)
            startActivity(myIntent)
        }

        lbTblVtBtn.setOnClickListener {
            val myIntent = Intent(this, Class03LbTabLayoutVtActivity::class.java)
            startActivity(myIntent)
        }

    }

    override fun setValues() {
    }
}
