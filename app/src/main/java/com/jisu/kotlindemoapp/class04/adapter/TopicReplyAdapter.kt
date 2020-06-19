package com.jisu.kotlindemoapp.class04.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.jisu.kotlindemoapp.R
import com.jisu.kotlindemoapp.class04.datas.TopicReply
import java.text.SimpleDateFormat

class TopicReplyAdapter(
    val mContext:Context,
    val resId:Int,
    val mList:List<TopicReply>) : ArrayAdapter<TopicReply>(mContext, resId, mList) {

    val inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var tempRow = convertView
        tempRow?.let {

        }.let {
            tempRow = inf.inflate(R.layout.activity_class04_db_rest_api_topic_reply_list_item, null)
        }

//        row가 절대 null 아님을 보장하면서 대입
        val row = tempRow!!

        val replyNickNameTxt = row.findViewById<TextView>(R.id.replyNickNameTxt)
        val replyContentTxt = row.findViewById<TextView>(R.id.replyContentTxt)
        val replyTimeTxt = row.findViewById<TextView>(R.id.replyTimeTxt)

        val data = mList[position]

        replyNickNameTxt.text = data.writer.nickname
        replyContentTxt.text = data.content

        val sdf = SimpleDateFormat("M월 d일 a h시 m분")

        replyTimeTxt.text = sdf.format(data.createdAt.time)

//        완성된 row를 리스트뷰의 재료로 리턴
        return row

    }

}