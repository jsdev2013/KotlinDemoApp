package com.jisu.kotlindemoapp.class03.fragmentsMain

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jisu.kotlindemoapp.BaseFragment
import com.jisu.kotlindemoapp.R
import com.jisu.kotlindemoapp.class01.Class01ChangeNicknameActivity
import kotlinx.android.synthetic.main.activity_class03_main_first_fragment.*

class MainFirstFragment : BaseFragment() {

// 프래그먼트에 뷰페이저 넣을 때
// supportFragmentManager 말고 다른 파라미터 넣어야 함

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.activity_class03_main_first_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setupEvents()
        setValues()
    }

    override fun setupEvents() {

//        Fragment 에서 다른 페이지로 이동할 때 예시(사용은 안함)
        chgNickNameBtn.setOnClickListener {
            val myIntent = Intent(mContext, Class01ChangeNicknameActivity::class.java)
            startActivity(myIntent)
        }

        telBtn.setOnClickListener {
            val telEdit = telEdt.text.toString()
            val myUri = Uri.parse("tel:${telEdit}")
            val myIntent = Intent(Intent.ACTION_DIAL, myUri)
            startActivity(myIntent)
        }
    }

    override fun setValues() {
    }
}
