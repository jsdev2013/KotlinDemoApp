package com.jisu.kotlindemoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val REQ_FOR_MESSAGE = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cBtn01.setOnClickListener {
            var class01Activity = Intent(this,Class01Activity::class.java)
            startActivityForResult(class01Activity, REQ_FOR_MESSAGE)
        }
    }
}
