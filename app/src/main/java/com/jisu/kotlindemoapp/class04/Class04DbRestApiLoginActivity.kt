package com.jisu.kotlindemoapp.class04

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.jisu.kotlindemoapp.BaseActivity
import com.jisu.kotlindemoapp.R
import com.jisu.kotlindemoapp.class04.utils.ContextUtil
import com.jisu.kotlindemoapp.class04.utils.ServerUtil
import kotlinx.android.synthetic.main.activity_class04_db_rest_api_login.*
import org.json.JSONObject

class Class04DbRestApiLoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class04_db_rest_api_login)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        loginBtn.setOnClickListener {
            val email = emailEdt.text.toString()
            val pw = passwordEdt.text.toString()

            ServerUtil.postRequestLogin(mContext, email, pw, object : ServerUtil.JsonResponseHandler{
                override fun onResponse(json: JSONObject) {
                    // 서버의 응답을 처리하는 코드들
                    // 제일 큰 껍데기 json 변수에서 추출
                    val codeNumber = json.getInt("code")

                    if (codeNumber == 200) {
                        // 로그인 성공

                        //성공 시 내려주는 토큰값 추출(token 변수에 저장)
                        val data = json.getJSONObject("data")
                        val token = data.getString("token")

                        //폰에 저장해두는 게 편리함
                        ContextUtil.setUserToken(mContext, token)

                        val myIntent = Intent(mContext, Class04DbRestApiMainActivity::class.java)
                        startActivity(myIntent)

                        finish()
                    } else {
                        // 로그인 실패
                        // UI 반영: 서버가 알려주는 실패 사유를 출력
                        // 인터넷 => 백그라운드 쓰레드 => UI 접근 => 강제종료
                        // UI쓰레드가 => 토스트를 띄우도록
                        val message = json.getString("message")

                        runOnUiThread {
                            Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            })
        }

        signUpBtn.setOnClickListener {
            val myIntent = Intent(mContext, Class04DbRestApiSignUpActivity::class.java)
            startActivity(myIntent)
        }
    }

    override fun setValues() {

    }
}
