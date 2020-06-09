package com.jisu.kotlindemoapp.class01

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.jisu.kotlindemoapp.R
import kotlinx.android.synthetic.main.activity_class01_register_activty.*

class Class01RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class01_register_activty)

        confirmBtn.setOnClickListener {

            val idEdit = idEdit.text.toString()
            val pwdEdit = pwdEdit.text.toString()

//          DB 저장 로직 필요
//            idEdit
//            pwdEdit

            val goBackIntent = Intent()

            setResult(Activity.RESULT_OK,goBackIntent)
            Toast.makeText(this,"로그인 해주세요",Toast.LENGTH_SHORT).show()

            finish()
        }
    }
}
