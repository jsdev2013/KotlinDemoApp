package com.jisu.kotlindemoapp.class03.fragmentsStore

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jisu.kotlindemoapp.BaseFragment
import com.jisu.kotlindemoapp.R
import com.jisu.kotlindemoapp.class03.Class03LbStoreBookListViewDetailActivity
import com.jisu.kotlindemoapp.class03.adapter.StoreAdapter
import com.jisu.kotlindemoapp.class03.datas.Store
import kotlinx.android.synthetic.main.activity_class03_lb_store_chicken_fragment.*

class ChickenFragment : BaseFragment() {

    val stores = ArrayList<Store>()
    lateinit var storeAdapter : StoreAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_class03_lb_store_chicken_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        chickenStoreListView.setOnItemClickListener { parent, view, position, id ->
            val clickedStore = stores[position]

            val myIntent = Intent(mContext, Class03LbStoreBookListViewDetailActivity::class.java)
            myIntent.putExtra("storeData", clickedStore)
            startActivity(myIntent)
        }
    }

    override fun setValues() {

        val pizzahutLogUrl = "https://img1.daumcdn.net/thumb/R800x0/?scode=mtistory2&fname=https%3A%2F%2Fk.kakaocdn.net%2Fdn%2FnkQca%2FbtqwVT4rrZo%2FymhFqW9uRbzrmZTxUU1QC1%2Fimg.jpg"
        val papazonsLogUrl = "http://mblogthumb2.phinf.naver.net/20160530_65/ppanppane_1464617766007O9b5u_PNG/%C6%C4%C6%C4%C1%B8%BD%BA_%C7%C7%C0%DA_%B7%CE%B0%ED_%284%29.png?type=w800"
        val misterLogUrl = "https://post-phinf.pstatic.net/MjAxODEyMDVfMzYg/MDAxNTQzOTYxOTA4NjM3.8gsStnhxz7eEc9zpt5nmSRZmI-Pzpl4NJvHYU-Dlgmcg.7Vpgk0lopJ5GoTav3CUDqmXi2-_67S5AXD0AGbbR6J4g.JPEG/IMG_1641.jpg?type=w1200"
        val dominoLogUrl = "https://pbs.twimg.com/profile_images/1098371010548555776/trCrCTDN_400x400.png"

        val pizzahutMenuUrl = "https://image.edaily.co.kr/images/Photo/files/NP/S/2014/08/PS14081900448.jpg"
        val papazonsMenuUrl = "https://image.edaily.co.kr/images/Photo/files/NP/S/2014/08/PS14081900448.jpg"
        val misterMenuUrl = "https://image.edaily.co.kr/images/Photo/files/NP/S/2014/08/PS14081900448.jpg"
        val dominoMenuUrl = "https://image.edaily.co.kr/images/Photo/files/NP/S/2014/08/PS14081900448.jpg"

        val pizzahutItemUrl = "https://cools.co/wp-content/uploads/2020/04/93842752_3219959041361892_6726603892949254144_o-758x758.jpg"
        val papazonsItemUrl = "https://cools.co/wp-content/uploads/2020/04/93842752_3219959041361892_6726603892949254144_o-758x758.jpg"
        val misterItemUrl = "https://cools.co/wp-content/uploads/2020/04/93842752_3219959041361892_6726603892949254144_o-758x758.jpg"
        val dominoItemUrl = "https://cools.co/wp-content/uploads/2020/04/93842752_3219959041361892_6726603892949254144_o-758x758.jpg"

        val pizzahutTel = "1588-5588"
        val papazonsTel = "1577-8080"
        val misterTel = "1577-0077"
        val dominoTel = "1577-3082"

        stores.add(Store(pizzahutLogUrl, pizzahutMenuUrl, pizzahutItemUrl,"교촌치킨",pizzahutTel))
        stores.add(Store(papazonsLogUrl, papazonsMenuUrl, papazonsItemUrl,"BBQ",papazonsTel))
        stores.add(Store(misterLogUrl, misterMenuUrl, misterItemUrl,"부어치킨",misterTel))
        stores.add(Store(dominoLogUrl, dominoMenuUrl, dominoItemUrl,"맛닭꼬",dominoTel))

        storeAdapter = StoreAdapter(
            mContext,
            R.layout.activity_class03_lb_store_list_item, stores
        )
        chickenStoreListView.adapter = storeAdapter
    }
}
