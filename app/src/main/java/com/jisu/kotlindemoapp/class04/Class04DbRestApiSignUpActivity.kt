package com.jisu.kotlindemoapp.class04

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jisu.kotlindemoapp.BaseActivity
import com.jisu.kotlindemoapp.R
import com.jisu.kotlindemoapp.class04.utils.ServerUtil
import kotlinx.android.synthetic.main.activity_class04_db_rest_api_sign_up.*
import org.json.JSONObject

class Class04DbRestApiSignUpActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_class04_db_rest_api_sign_up)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {
        emailCheckBtn.setOnClickListener {
            // 이메일 받아오기
            val email = emailEdt.text.toString()

            // 서버에 중복확인 요청
            ServerUtil.getRequesDuplicatedCheck(mContext, "EMAIL", email, object : ServerUtil.JsonResponseHandler{
                override fun onResponse(json: JSONObject) {
                    // 서버의 응답을 처리하는 코드들
                    // 제일 큰 껍데이 json 변수에서 추출
                    val code = json.getInt("code")

                    runOnUiThread {
                        if (code == 200) {
                            emailCheckResultTxt.text = "사용해도 좋습니다."
                        } else {
                            emailCheckResultTxt.text = "중복된 이메일이라 사용 불가합니다."
                        }
                    }
                }
            })
        }
    }

    override fun setValues() {

    }
}
