package com.jisu.kotlindemoapp.class02.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jisu.kotlindemoapp.R
import com.jisu.kotlindemoapp.datas.Room
import kotlinx.android.synthetic.main.activity_class02_room_list_item.view.*

class RoomRecyclerAdapter(val context: Context, val rooms: ArrayList<Room>) :RecyclerView.Adapter<RoomRecyclerAdapter.ViewHolder>(){

//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomRecyclerAdapter.ViewHolder {
//        val view = LayoutInflater.from(context).inflate(R.layout.activity_class02_room_list_item, parent, false)
//        return ViewHolder(view)
//    }
//
//    override fun getItemCount(): Int {
//        return rooms.size
//    }
//
//    override fun onBindViewHolder(holder: RoomRecyclerAdapter.ViewHolder, position: Int) {
//        holder?.bind(rooms[position], context)
//    }
//
//    inner class ViewHolder(itemView: View?) :RecyclerView.ViewHolder(itemView!!) {
//        val price = itemView?.findViewById<TextView>(R.id.priceTxt)
//        val addressAndFloor = itemView?.findViewById<TextView>(R.id.addressAndFloorTxt)
//        val description = itemView?.findViewById<TextView>(R.id.descriptionTxt)
//
//        fun bind (room: Room, context: Context) {
//            price?.text = room.getFormattedPrice()
//            addressAndFloor?.text = "${room.address}, ${room.getFormattedFloor()}"
//            description?.text = room.descrition
//        }
//    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(parent)

    override fun getItemCount(): Int = rooms.size

    override fun onBindViewHolder(holer: ViewHolder, position: Int) {

        rooms[position].let { room ->
            with(holer) {
                price.text = room.getFormattedPrice()
                addressAndFloor.text = "${room.address}, ${room.getFormattedFloor()}"
                description.text = room.descrition
            }
        }

        // 변수이름?.let {
        //      null이 아닐때
        // }.let {
        //      null 일때
        // }
//        rooms[position]?.let { room ->
//            with(holer) {
//                price.text = room.getFormattedPrice()
//                addressAndFloor.text = "${room.address}, ${room.getFormattedFloor()}"
//                description.text = room.descrition
//            }
//        }.let {
//            with(holer) {
//                price.text = "냉무"
//                addressAndFloor.text = "냉무"
//                description.text = "냉무"
//            }
//        }

    }

    inner class ViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(this.context).inflate(R.layout.activity_class02_room_list_item, parent, false))
    {
        val price = itemView.priceTxt
        val addressAndFloor = itemView.addressAndFloorTxt
        val description = itemView.descriptionTxt
    }
}