package com.jisu.kotlindemoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_class01.*

class Class01Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class01)

        loginBtn.setOnClickListener {
            val idEdit = idEdit.text.toString()
            val pwdEdit = pwdEdit.text.toString()
            val autoChkYn = autoChkYn.isChecked
            val radioChk = radio_group.checkedRadioButtonId

            val class01LoginViewActivity = Intent(this,Class01LoginViewActivity::class.java)
            class01LoginViewActivity.putExtra("idEdit", idEdit)

            if(radioChk != -1){
                val usrInfo:RadioButton = findViewById(radioChk)
                class01LoginViewActivity.putExtra("usrInfo", usrInfo.text)
                startActivity(class01LoginViewActivity)
            } else {
                Toast.makeText(this,"회원 유형을 선택해주세요", Toast.LENGTH_SHORT).show()
            }
        }

        registerBtn.setOnClickListener {
            val class01RegisterActivity = Intent(this, Class01RegisterActivity::class.java)
            startActivity(class01RegisterActivity)
        }
    }
}
