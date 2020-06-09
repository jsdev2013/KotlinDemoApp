package com.jisu.kotlindemoapp.class02.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.jisu.kotlindemoapp.R
import com.jisu.kotlindemoapp.datas.Student
import java.text.SimpleDateFormat
import java.util.*

class StudentAdapter(context: Context, resId: Int, list: List<Student>): ArrayAdapter<Student>(context, resId, list) {

    val mContext = context
    val mList = list
    val inf = LayoutInflater.from(mContext)

    override fun getView(position: Int, convertView: View?, parent: ViewGroup) :View {
        var tempRow = convertView

        if(tempRow == null){
            tempRow = inf.inflate(R.layout.activity_class02_student_list_item, null)
        }

        val row = tempRow!!

        val data = mList.get(position)

        val nameAndAgeTxt = row.findViewById<TextView>(R.id.nameAneAgeTxt)
        val genderTxt = row.findViewById<TextView>(R.id.genderTxt)

        // 한국현재 나이 구하기
        val curTime = System.currentTimeMillis()
        val dateFormat = SimpleDateFormat("yyyy", Locale.KOREAN)
        val curYear = dateFormat.format(curTime).toInt()
//        val age = (curYear.toInt() - birthTxt + 1).toString()
//        val name = data.name
//        nameAndAgeTxt.text = "$name ($age)"

        nameAndAgeTxt?.text = "${data.name} (${data.getKoreanAge(curYear)})"
        
        if(data.isMale){
            genderTxt.text = "남성"
        } else {
            genderTxt.text = "여성"
        }

        return row
    }
}