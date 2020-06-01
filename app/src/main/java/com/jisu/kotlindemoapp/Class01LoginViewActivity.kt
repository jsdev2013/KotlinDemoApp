package com.jisu.kotlindemoapp

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_class01_login_view.*

class Class01LoginViewActivity : AppCompatActivity() {

    val REQ_FOR_MESSAGE = 1000
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class01_login_view)

        // 로그인 아이디
        val idContent = intent.getStringExtra("idEdit")
        val usrInfoContent = intent.getStringExtra("usrInfo")
        idTxt.text = idContent
        usrInfoTxt.text = usrInfoContent

        chgNickNameBtn.setOnClickListener {
            val class01ChangeNicknameActivity = Intent(this,Class01ChangeNicknameActivity::class.java)
            startActivityForResult(class01ChangeNicknameActivity, REQ_FOR_MESSAGE)
        }

        telBtn.setOnClickListener {
            val telEdt = telEdt.text.toString()
            val myUri = Uri.parse("tel:${telEdt}")
            val myIntent = Intent(Intent.ACTION_DIAL, myUri)
            startActivity(myIntent)
        }

        smsBtn.setOnClickListener {
            val telEdt = telEdt.text.toString()
            val smsEdit = smsEdt.text.toString()

            val myUri = Uri.parse("smsto:${telEdt}")
            val myIntent = Intent(Intent.ACTION_SENDTO, myUri)
            myIntent.putExtra("sms_body",smsEdit)
            startActivity(myIntent)
        }

        webSiteBtn.setOnClickListener {
            val myUri = Uri.parse("http://www.naver.com")
            val myIntent = Intent(Intent.ACTION_VIEW, myUri)
            startActivity(myIntent)
        }

        playStoreBtn.setOnClickListener {
            val myUri = Uri.parse("market://details?id=com.kakao.talk")
            val myIntent = Intent(Intent.ACTION_VIEW, myUri)
            startActivity(myIntent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(requestCode == REQ_FOR_MESSAGE){
            if(resultCode == Activity.RESULT_OK) {
                val resultNickName = data?.getStringExtra("chgNickName")

                nickNameTxt.text = resultNickName
                Toast.makeText(this,"닉네임 변경 완료", Toast.LENGTH_SHORT).show()
            }

        }
    }
}
