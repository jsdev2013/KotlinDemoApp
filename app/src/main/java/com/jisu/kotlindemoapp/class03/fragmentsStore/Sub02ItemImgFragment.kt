package com.jisu.kotlindemoapp.class03.fragmentsStore

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.jisu.kotlindemoapp.BaseFragment
import com.jisu.kotlindemoapp.R
import com.jisu.kotlindemoapp.class03.datas.Store
import kotlinx.android.synthetic.main.activity_class03_lb_store_sub01_menu_fragment.*
import kotlinx.android.synthetic.main.activity_class03_lb_store_sub02_item_fragment.*

class Sub02ItemImgFragment : BaseFragment() {

    lateinit var mStore: Store

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_class03_lb_store_sub02_item_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {
        //mStore = intent.getSerializableExtra("storeData") as Store
        //Glide.with(mContext).load(mStore.menuImg).into(itemImg)

        val tmpItemImg = "https://www.pizzamaru.co.kr/resources/images/menu/gold/gol1_L_01.png"
        Glide.with(mContext).load(tmpItemImg).into(itemImg)
    }
}
