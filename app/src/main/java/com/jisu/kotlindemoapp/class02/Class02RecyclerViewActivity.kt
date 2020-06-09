package com.jisu.kotlindemoapp.class02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.jisu.kotlindemoapp.R
import com.jisu.kotlindemoapp.class02.adapters.RecyclerAdapter
import com.jisu.kotlindemoapp.datas.Student
import kotlinx.android.synthetic.main.activity_class02_recycler_view.*

class Class02RecyclerViewActivity : AppCompatActivity() {

    var students = arrayListOf<Student>(
        Student("김남*",1994,true),
        Student("김석*",1992,true),
        Student("정호*",1994,true),
        Student("민윤*",1993,true),
        Student("박지*",1995,true),
        Student("김태*",1995,true),
        Student("전정*",1997,true)
    )

    lateinit var recyclerAdapter: RecyclerAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class02_recycler_view)

        recyclerAdapter =
            RecyclerAdapter(
                this,
                students
            )
        mRecylerView.adapter = recyclerAdapter

        val lm = LinearLayoutManager(this)
        mRecylerView.layoutManager = lm
        mRecylerView.setHasFixedSize(true)
    }
}
