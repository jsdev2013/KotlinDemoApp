package com.jisu.kotlindemoapp.class02.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jisu.kotlindemoapp.BaseFragment
import com.jisu.kotlindemoapp.R
import com.jisu.kotlindemoapp.class02.Class02AndroidLifeCycleActivity
import kotlinx.android.synthetic.main.activity_class02_fragment_first.*

class FirstFragment: BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_class02_fragment_first, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        messageTxt.text = "안녕하세요"

        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        goToOtherBtn.setOnClickListener {
            val myIntent = Intent(mContext, Class02AndroidLifeCycleActivity::class.java)
            startActivity(myIntent)
        }
    }
    override fun setValues() {

    }
}