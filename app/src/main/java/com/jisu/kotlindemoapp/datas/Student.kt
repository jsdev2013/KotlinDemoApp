package com.jisu.kotlindemoapp.datas

class Student (val name:String, val birthYear:Int, var isMale:Boolean) {

    fun getKoreanAge(year: Int) : Int {

        // 2020-1988+1 = 33: 한국나이
        return year - this.birthYear + 1
    }
}