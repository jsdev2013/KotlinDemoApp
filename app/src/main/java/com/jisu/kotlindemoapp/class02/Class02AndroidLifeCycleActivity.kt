package com.jisu.kotlindemoapp.class02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.jisu.kotlindemoapp.R
import kotlinx.android.synthetic.main.activity_class02_android_life_cycle.*
import android.os.Bundle
import android.util.Log

class Class02AndroidLifeCycleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class02_android_life_cycle)

        Log.d("메인 화면", "onCreate")
        
        goToOtherBtn.setOnClickListener {
            val myIntent = Intent(this, Class02AndroidLifeCycleOtherActivity::class.java)
            startActivity(myIntent)
        }
    }

    override fun onResume() {
        super.onResume()

        Log.d("메인 화면", "onResume")
    }

    override fun onPause() {
        super.onPause()

        Log.d("메인 화면", "onPause")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.d("메인 화면", "onDestroy")
    }
}
