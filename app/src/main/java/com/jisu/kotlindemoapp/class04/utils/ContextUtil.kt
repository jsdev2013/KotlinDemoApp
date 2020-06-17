package com.jisu.kotlindemoapp.class04.utils

import android.content.Context

class ContextUtil {
    companion object {

        // 메모장(preference) 파일 이름에 대응되는 개념: 변수로 저장
        val prefName = "APIPracticePref"

        // 저장할 항목들의 이름을 변수로 저장
        val USER_TOKEN = "USER_TOKEN"

        // 항목에 데이터 저장
        fun setUserToken(context: Context, token:String) {
            val pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
            pref.edit().putString(USER_TOKEN, token).apply()
        }

        // 항목에 데이터 불러오기
        fun getUserToken(context: Context) : String {
            val pref = context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
            return pref.getString(USER_TOKEN, "")!!
        }
    }
}