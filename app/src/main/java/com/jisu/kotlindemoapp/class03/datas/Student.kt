package com.jisu.kotlindemoapp.class03.datas

class Student (val name:String, val birthYear:Int) {
    fun getKoreanAge(year: Int) : Int {

        // 2020-1988+1 = 33: 한국나이
        return year - this.birthYear + 1
    }
}