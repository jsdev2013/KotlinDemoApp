package com.jisu.kotlindemoapp.class03.fragmentsMain

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jisu.kotlindemoapp.BaseFragment
import com.jisu.kotlindemoapp.R
import com.jisu.kotlindemoapp.class03.adapter.StudentAdapter
import com.jisu.kotlindemoapp.class03.datas.Student
import kotlinx.android.synthetic.main.activity_class03_main_second_fragment.*

class MainSecondFragment : BaseFragment() {

    val students = ArrayList<Student>()
    lateinit var studentAdapter : StudentAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_class03_main_second_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {
        students.add(Student("김*준",1994))
        students.add(Student("김*진",1992))
        students.add(Student("정*석",1994))

        studentAdapter = StudentAdapter(
            mContext,
            R.layout.activity_class03_student_list_item, students
        )
        studentListView.adapter = studentAdapter
    }
}
