package com.jisu.kotlindemoapp.class03.fragmentsStore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bumptech.glide.Glide
import com.jisu.kotlindemoapp.BaseFragment
import com.jisu.kotlindemoapp.R
import kotlinx.android.synthetic.main.activity_class03_lb_store_sub01_menu_fragment.*

class Sub01MenuImgFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_class03_lb_store_sub01_menu_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupEvents()
        setValues()
    }

    override fun setupEvents() {
    }

    override fun setValues() {
       val menuImgUrlTxt = activity!!.findViewById<TextView>(R.id.menuImgUrlTxt).text
       Glide.with(mContext).load(menuImgUrlTxt).into(menuImg)
    }
}
