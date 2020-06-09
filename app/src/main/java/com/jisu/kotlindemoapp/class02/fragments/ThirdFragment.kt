package com.jisu.kotlindemoapp.class02.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jisu.kotlindemoapp.R
import com.jisu.kotlindemoapp.class02.adapters.MyPagerAdapter
import kotlinx.android.synthetic.main.activity_class02_fragment_third.*
import kotlinx.android.synthetic.main.activity_class02_fragment_view_pager.*

class ThirdFragment :Fragment() {

//    lateinit var myPagerAdapter: MyPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_class02_fragment_third, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

//        myPagerAdapter = MyPagerAdapter(supportFragmentManager)
//        myViewPager.adapter = myPagerAdapter

        messageTxt.text = "안녕히계세요"
    }
}