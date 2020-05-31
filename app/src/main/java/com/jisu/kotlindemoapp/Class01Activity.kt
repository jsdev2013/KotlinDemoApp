package com.jisu.kotlindemoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_class01.*

class Class01Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class01)

        loginBtn.setOnClickListener {
            val idEdit = idEdit.text.toString()
            val pwdEdit = pwdEdit.text.toString()
            val autoChkYn = autoChkYn.text.toString()

            val class01LoginViewActivity = Intent(this,Class01LoginViewActivity::class.java)
            class01LoginViewActivity.putExtra("idEdit", idEdit)
            startActivity(class01LoginViewActivity)
        }

        registerBtn.setOnClickListener {
            val class01RegisterActivity = Intent(this, Class01RegisterActivity::class.java)
            startActivity(class01RegisterActivity)
        }
    }
}
