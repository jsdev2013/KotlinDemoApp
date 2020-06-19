package com.jisu.kotlindemoapp.class04.datas

import org.json.JSONObject
import java.text.SimpleDateFormat
import java.util.*

class TopicReply {

    var id = 0
    var content = ""
    var topicId = 0
    var sideId = 0
    var userId = 0

    lateinit var writer: User

    // 속성일시를 시간 형태로 저장 변수 => 기본값: 현재일시
    val createdAt = Calendar.getInstance()

    companion object {
        fun getTopicReplyFromJson(json: JSONObject) :TopicReply {
            var tr = TopicReply()

            tr.id = json.getInt("id")
            tr.content = json.getString("content")
            tr.topicId = json.getInt("topic_id")
            tr.sideId = json.getInt("side_id")
            tr.userId = json.getInt("user_id")

            val userObject = json.getJSONObject("user")
            tr.writer = User.getUserFromJson(userObject)

            // 의견 작성 시간 파싱 => 우선 String으로 가져와야 함
            val createdAtStr = json.getString("created_at")
            // String => tr.createdAt (Calendar)의 시간으로 반영
            val sdf = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
            // 파싱중인 의견의 작성시간을 String으로 분석한 서버에서 알려준 작성시간으로 대입
            tr.createdAt.time = sdf.parse(createdAtStr)!!

            val myPhoneTimeZone = tr.createdAt.timeZone //  어느 지역 시간대인지 따서 저장(서울)
            val timeOffset = myPhoneTimeZone.rawOffset / 1000 / 60 / 60
            tr.createdAt.add(Calendar.HOUR, timeOffset)

            return tr
        }
    }
}