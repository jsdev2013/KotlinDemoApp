package com.jisu.kotlindemoapp.class04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jisu.kotlindemoapp.BaseActivity
import com.jisu.kotlindemoapp.R
import com.jisu.kotlindemoapp.class04.datas.Topic
import com.jisu.kotlindemoapp.class04.utils.ServerUtil
import org.json.JSONObject

class Class04DbRestApiMainActivity : BaseActivity() {

    val topicList = ArrayList<Topic>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class04_db_rest_api_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
    }

    override fun setValues() {

//        ServerUtil.getRequestUserInfo(mContext, object :ServerUtil.JsonResponseHandler{
//            override fun onResponse(json: JSONObject) {
//
//                val data = json.getJSONObject("data")
//                val user = data.getJSONObject("user")
//
//                var loginUser = User.getUserFromJson(user)
//
//                runOnUiThread {
//                    userNickNameTxt.text = loginUser.nickname
//                    userEmailTxt.text = loginUser.email
//                }
//            }
//        })

        ServerUtil.getRequestMainInfo(mContext, object :ServerUtil.JsonResponseHandler{
            override fun onResponse(json: JSONObject) {

                val data = json.getJSONObject("data")
                val topics = json.getJSONArray("topics")

                for (i in 0..topics.length()-1) {
                    val topicJson = topics.getJSONObject(i)

                    // 주제 하나에 대응되는 JSON을 넣어서 Topic 객체로 알아내자
                    val topic = Topic.getTopicFromJson(topicJson)

                    // 주제 목록을 리스트뷰의 재료로 추가
                    topicList.add(topic)
                }
            }
        })
    }
}
