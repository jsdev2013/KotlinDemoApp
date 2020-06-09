package com.jisu.kotlindemoapp.class01

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jisu.kotlindemoapp.R
import kotlinx.android.synthetic.main.activity_class01_change_nickname.*

class Class01ChangeNicknameActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class01_change_nickname)

        val nick = intent.getStringExtra("nickNameAsis")
        chgNickEdt.setText(nick)

        chgNickBtn.setOnClickListener {

            val nickEdit = chgNickEdt.text.toString()
            val goBackIntent = Intent()

            goBackIntent.putExtra("chgNickName", nickEdit)
            setResult(Activity.RESULT_OK, goBackIntent)

            finish()
        }
    }
}
