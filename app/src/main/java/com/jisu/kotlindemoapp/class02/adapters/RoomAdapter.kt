package com.jisu.kotlindemoapp.class02.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.jisu.kotlindemoapp.R
import com.jisu.kotlindemoapp.datas.Room

class RoomAdapter(context: Context, resId: Int, list: List<Room>) : ArrayAdapter<Room>(context, resId, list) {

    val mContext = context
    val mList = list
    val inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView

        if(tempRow == null){
            tempRow = inf.inflate(R.layout.activity_class02_room_list_item, null)
        }

        val row = tempRow!!

        val data = mList.get(position)

        val price = row.findViewById<TextView>(R.id.priceTxt)
        val addressAndFloor = row.findViewById<TextView>(R.id.addressAndFloorTxt)
        val description = row.findViewById<TextView>(R.id.descriptionTxt)

        price?.text = data.getFormattedPrice()
        addressAndFloor?.text = "${data.address}, ${data.getFormattedFloor()}"
        description?.text = data.descrition

        return row
    }
}