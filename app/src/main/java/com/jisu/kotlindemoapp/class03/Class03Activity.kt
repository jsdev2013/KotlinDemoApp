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
    }

    override fun setValues() {
    }
}
