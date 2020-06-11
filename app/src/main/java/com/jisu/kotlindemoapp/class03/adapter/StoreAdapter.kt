package com.jisu.kotlindemoapp.class03.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.jisu.kotlindemoapp.R
import com.jisu.kotlindemoapp.class03.datas.Store

class StoreAdapter(val mContext: Context, val resId: Int, val mList: List<Store>) :
    ArrayAdapter<Store>(mContext, resId, mList) {

    val inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tempRow = convertView
        
        tempRow?.let {
            //null이 아닐 땐 그냥 지나간다
        }.let {
            //null인 경우 새로 그린다
            tempRow = inf.inflate(R.layout.activity_class03_lb_store_list_item, null)
        }

        val row = tempRow!!
        val data = mList.get(position)

        val logImg = row.findViewById<ImageView>(R.id.logoImg)
        val storeNm = row.findViewById<TextView>(R.id.storeNm)
        val storeTel = row.findViewById<TextView>(R.id.storeTel)
        val menuImg = row.findViewById<TextView>(R.id.menuImg)
        val itemImg = row.findViewById<TextView>(R.id.itemImg)

        Glide.with(mContext).load(data.logoImg).into(logImg)
        storeNm.text = data.storeNm
        storeTel.text = data.storeTel
        menuImg.text = data.menuImg
        itemImg.text = data.itemImg

        return row
    }
}