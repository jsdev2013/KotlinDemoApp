package com.jisu.kotlindemoapp.class02

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.widget.Toast
import com.jisu.kotlindemoapp.BaseActivity
import com.jisu.kotlindemoapp.R
import com.jisu.kotlindemoapp.class02.adapters.StudentAdapter
import com.jisu.kotlindemoapp.datas.Student
import kotlinx.android.synthetic.main.activity_class02_list_view.*
import kotlinx.android.synthetic.main.activity_class02_student_list_item.view.*

class Class02ListViewActivity : BaseActivity() {

    val students = ArrayList<Student>()
    lateinit var studentAdapter: StudentAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class02_list_view)
        setupEvents()
        setValues()
    }

    override fun setValues() {
        students.add(Student("김*준",1994,true))
        students.add(Student("김*진",1992,true))
        students.add(Student("정*석",1994,true))
        students.add(Student("민*기",1993,true))
        students.add(Student("박*민",1995,true))
        students.add(Student("김*형",1995,true))
        students.add(Student("전*국",1997,true))

        studentAdapter = StudentAdapter(
            mContext,
            R.layout.activity_class02_student_list_item, students
        )
        studentListView.adapter = studentAdapter
    }

    override fun setupEvents() {

        studentListView.setOnItemClickListener { parent, view, position, id ->
            val clickedStudent = students.get(position)
            Toast.makeText(mContext, clickedStudent.name, Toast.LENGTH_SHORT).show()
        }

        studentListView.setOnItemLongClickListener { parent, view, position, id ->

            val alert = AlertDialog.Builder(mContext)
            alert.setTitle("삭제 확인")
            alert.setMessage("정말 이 학생을 삭제하시겠습니까?")
            alert.setPositiveButton("확인", DialogInterface.OnClickListener { dialog, which ->
                students.removeAt(position)
                studentAdapter.notifyDataSetChanged()
            })

            alert.setNegativeButton("취소", DialogInterface.OnClickListener { dialog, which -> null })
            alert.show()
            return@setOnItemLongClickListener true
        }

    }
}
