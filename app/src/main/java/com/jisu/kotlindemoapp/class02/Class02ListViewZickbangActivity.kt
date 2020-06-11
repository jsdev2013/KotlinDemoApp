package com.jisu.kotlindemoapp.class02

import android.content.Intent
import android.os.Bundle
import com.jisu.kotlindemoapp.BaseActivity
import com.jisu.kotlindemoapp.R
import com.jisu.kotlindemoapp.class02.adapters.RoomAdapter
import com.jisu.kotlindemoapp.class02.datas.Room
import kotlinx.android.synthetic.main.activity_class02_list_view_zickbang.*

class Class02ListViewZickbangActivity : BaseActivity() {

    val roomArrayList = ArrayList<Room>()
    lateinit var roomAdapter: RoomAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class02_list_view_zickbang)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        listViewZickbang.setOnItemClickListener { parent, view, position, id ->
            val clickedRoom = roomArrayList[position]

            val myIntent = Intent(mContext, Class02ListViewRoomDetailActivity::class.java)
            myIntent.putExtra("roomData", clickedRoom) // Room 클래스에 Serializable 처리
            startActivity(myIntent)
        }
    }

    override fun setValues() {
        addRooms()

        roomAdapter = RoomAdapter(
            mContext,
            R.layout.activity_class02_room_list_item, roomArrayList
        )
        listViewZickbang.adapter = roomAdapter
    }

    fun addRooms(){
        roomArrayList.add(Room(7500,"마포구 서교동", 3, "망원/홍대역 풀옵션 넓은 원룸형"))
        roomArrayList.add(Room(28500,"마포구 서교동", 5, "신혼부부의 보금자리 서교동 신축"))
        roomArrayList.add(Room(1500,"마포구 망원동", 0, "망원/홍대역 풀옵션 넓은 원룸형"))
        roomArrayList.add(Room(54000,"마포구 망원동", -1, "신혼부부의 보금자리 서교동 신축"))
        roomArrayList.add(Room(2500,"마포구 망원동", 1, "망원/홍대역 풀옵션 넓은 원룸형"))
        roomArrayList.add(Room(11100,"마포구 홍대역", -1, "신혼부부의 보금자리 서교동 신축"))
        roomArrayList.add(Room(6500,"마포구 홍대역", 2, "망원/홍대역 풀옵션 넓은 원룸형"))
        roomArrayList.add(Room(1500,"마포구 홍대역", 0, "신혼부부의 보금자리 서교동 신축"))
        roomArrayList.add(Room(8000,"마포구 성산동", 0, "망원/홍대역 풀옵션 넓은 원룸형"))
        roomArrayList.add(Room(12550,"마포구 성산동", 3, "신혼부부의 보금자리 서교동 신축"))
        roomArrayList.add(Room(7500,"마포구 성산동", 5, "망원/홍대역 풀옵션 넓은 원룸형"))
        roomArrayList.add(Room(20000,"마포구 서교동", 3, "신혼부부의 보금자리 서교동 신축"))
    }
}
