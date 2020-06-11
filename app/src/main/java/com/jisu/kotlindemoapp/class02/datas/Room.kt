package com.jisu.kotlindemoapp.class02.datas

import java.io.Serializable
import java.text.NumberFormat
import kotlin.math.abs

//price // 2억5,000 => 25000, 8천 => 8000 : Int
//address // 마포구 망원동 , 단순 String
//floor // Int : 1 이상 => 1층, 3층 , 0층 : 반지하, -1이하 : 지하 1층, 지하 3층
//description // 단순 String
class Room (val price: Int, val address: String, val floor: Int, val descrition: String) :
    Serializable {

    fun getFormattedPrice():String {
        if (this.price < 10000) {
            return NumberFormat.getInstance().format(this.price)
        } else {
            val uk = this.price / 10000
            val reminder = this.price % 10000
            return "${uk}억 ${NumberFormat.getInstance().format(reminder)}"
        }
    }

    fun getFormattedFloor():String{
        if (this.floor < 0){
            return "지하 ${abs(this.floor)}층"
        }else if(this.floor == 0){
            return "반지하"
        }else {
            return "${this.floor}층"
        }
    }
}