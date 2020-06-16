package com.jisu.kotlindemoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jisu.kotlindemoapp.class01.Class01Activity
import com.jisu.kotlindemoapp.class02.Class02Activity
import com.jisu.kotlindemoapp.class03.Class03Activity
import com.jisu.kotlindemoapp.class04.Class04Activity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val REQ_FOR_MESSAGE = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        cBtn01.setOnClickListener {
            var myIntent = Intent(this,
                Class01Activity::class.java)
            startActivityForResult(myIntent, REQ_FOR_MESSAGE)
        }
        cBtn02.setOnClickListener {
            var myIntent = Intent(this,
                Class02Activity::class.java)
            startActivity(myIntent)
        }
        cBtn03.setOnClickListener {
            var myIntent = Intent(this,
                Class03Activity::class.java)
            startActivity(myIntent)
        }
        cBtn04.setOnClickListener {
            var myIntent = Intent(this,
                Class04Activity::class.java)
            startActivity(myIntent)
        }
    }
}
