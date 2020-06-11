package com.jisu.kotlindemoapp.class02.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.jisu.kotlindemoapp.R
import com.jisu.kotlindemoapp.class02.datas.Student
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class RecyclerAdapter(val context: Context, val items: ArrayList<Student>) : RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.activity_class02_student_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.bind(items[position], context)

//        items[position].let { item ->
//            with(holder) {
//                nameAndAgeTxt?.text = item.name
//                if(item.isMale){
//                    genderTxt?.text = "남성"
//                } else {
//                    genderTxt?.text = "여성"
//                }
//            }
//        }
    }
    inner class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView!!) {

        val nameAndAgeTxt = itemView?.findViewById<TextView>(R.id.nameAneAgeTxt)
        val genderTxt = itemView?.findViewById<TextView>(R.id.genderTxt)

        fun bind (student: Student, context: Context) {
            val birthTxt = student.birthYear

            // 한국현재 나이 구하기
            val curTime = System.currentTimeMillis()
            val dateFormat = SimpleDateFormat("yyyy", Locale.KOREAN)
            val curYear = dateFormat.format(curTime).toInt()

//            val age = (curYear.toInt() - birthTxt + 1).toString()
//            val name = student.name
//            nameAndAgeTxt?.text = "$name ($age)"

            nameAndAgeTxt?.text = "${student.name} (${student.getKoreanAge(curYear)})"

            if(student.isMale){
                genderTxt?.text = "남성"
            } else {
                genderTxt?.text = "여성"
            }
        }
    }


}