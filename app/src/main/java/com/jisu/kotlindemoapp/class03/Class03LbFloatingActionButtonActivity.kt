package com.jisu.kotlindemoapp.class03

import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Toast
import com.jisu.kotlindemoapp.BaseActivity
import com.jisu.kotlindemoapp.R
import kotlinx.android.synthetic.main.activity_class03_lb_floating_action_button.*

class Class03LbFloatingActionButtonActivity : BaseActivity() {

    lateinit var fab_open: Animation
    lateinit var fab_close: Animation
    var isFabOpen: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class03_lb_floating_action_button)
        setValues()
        setupEvents()
    }

    override fun setValues() {
        fab_open = AnimationUtils.loadAnimation(applicationContext, R.anim.fab_open)
        fab_close = AnimationUtils.loadAnimation(applicationContext, R.anim.fab_close)
    }

    override fun setupEvents() {
        fab.setOnClickListener {
            anim()
            Toast.makeText(mContext, "Floating Action Button", Toast.LENGTH_SHORT).show()
        }
        fab1.setOnClickListener {
            anim()
            Toast.makeText(mContext, "Fab1 Button", Toast.LENGTH_SHORT).show()
        }
        fab2.setOnClickListener {
            anim()
            Toast.makeText(mContext, "Fab2 Button", Toast.LENGTH_SHORT).show()
        }
    }

    fun anim(){
        if (isFabOpen) {
            fab.setImageResource(R.drawable.ic_add_black_24dp)
            fab1.startAnimation(fab_close)
            fab2.startAnimation(fab_close)
            fab1.setClickable(false)
            fab2.setClickable(false)
            isFabOpen = false
        } else {
            fab.setImageResource(R.drawable.ic_clear_black_24dp)
            fab1.startAnimation(fab_open)
            fab2.startAnimation(fab_open)
            fab1.setClickable(true)
            fab2.setClickable(true)
            isFabOpen = true
        }
    }
}
