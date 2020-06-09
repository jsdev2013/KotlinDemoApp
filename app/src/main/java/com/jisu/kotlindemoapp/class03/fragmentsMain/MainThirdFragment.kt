package com.jisu.kotlindemoapp.class03.fragmentsMain

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jisu.kotlindemoapp.BaseFragment
import com.jisu.kotlindemoapp.R
import com.jisu.kotlindemoapp.class03.adapter.MyPagerAdapter
import kotlinx.android.synthetic.main.activity_class03_main_third_fragment.*

class MainThirdFragment : BaseFragment() {

    lateinit var myPagerAdater: MyPagerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_class03_main_third_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        // 프래그먼트에 뷰페이저 넣을 때
        // supportFragmentManager 말고 다른 파라미터 넣어야 함
        myPagerAdater = MyPagerAdapter(activity!!.supportFragmentManager, "Sub")
        mySubViewPager.adapter = myPagerAdater
    }

    override fun setValues() {
    }
}
