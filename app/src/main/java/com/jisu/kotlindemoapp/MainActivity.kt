package com.jisu.kotlindemoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jisu.kotlindemoapp.class01.Class01Activity
import com.jisu.kotlindemoapp.class02.Class02Activity
import com.jisu.kotlindemoapp.class03.Class03Activity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val REQ_FOR_MESSAGE = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cBtn01.setOnClickListener {
            var class01Activity = Intent(this,
                Class01Activity::class.java)
            startActivityForResult(class01Activity, REQ_FOR_MESSAGE)
        }
        cBtn02.setOnClickListener {
            var class02Activity = Intent(this,
                Class02Activity::class.java)
            startActivity(class02Activity)
        }
        cBtn03.setOnClickListener {
            var class03Activity = Intent(this,
                Class03Activity::class.java)
            startActivity(class03Activity)
        }
    }
}
