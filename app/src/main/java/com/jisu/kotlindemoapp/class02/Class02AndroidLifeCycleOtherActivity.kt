package com.jisu.kotlindemoapp.class02

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.jisu.kotlindemoapp.R
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_class02_android_life_cycle_other.*

class Class02AndroidLifeCycleOtherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class02_android_life_cycle_other)

        Log.d("다른 화면", "onCreate")

        goToMainBtn.setOnClickListener {
            val myIntent = Intent(this, Class02AndroidLifeCycleActivity::class.java)
            startActivity(myIntent)
        }
    }
}
