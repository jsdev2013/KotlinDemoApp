package com.jisu.kotlindemoapp.class02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jisu.kotlindemoapp.BaseActivity
import com.jisu.kotlindemoapp.R
import com.jisu.kotlindemoapp.class02.datas.Room
import kotlinx.android.synthetic.main.activity_class02_list_view_room_detail.*

class Class02ListViewRoomDetailActivity : BaseActivity() {

    lateinit var mRoom:Room

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class02_list_view_room_detail)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {

        mRoom = intent.getSerializableExtra("roomData") as Room
        priceTxt.text = mRoom.getFormattedPrice()
        descTxt.text = mRoom.descrition
        addressTxt.text = mRoom.address
        floorTxt.text = mRoom.getFormattedFloor()
    }
}
