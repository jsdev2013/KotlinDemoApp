package com.jisu.kotlindemoapp.class03

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jisu.kotlindemoapp.BaseActivity
import com.jisu.kotlindemoapp.R
import kotlinx.android.synthetic.main.activity_class03.*
import kotlinx.android.synthetic.main.activity_class03_lb_circle_image_view.*

class Class03LbCircleImageViewActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class03_lb_circle_image_view)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        profileImg.setOnClickListener {
            val myIntent = Intent(mContext, Class03LbPhotoViewActivity::class.java)
            startActivity(myIntent)
        }
    }

    override fun setValues() {
    }

}
