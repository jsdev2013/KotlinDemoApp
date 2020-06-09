package com.jisu.kotlindemoapp.class03.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.jisu.kotlindemoapp.class03.fragments.FirstFragment
import com.jisu.kotlindemoapp.class03.fragments.SecondFragment

class MyPagerAdapter (fm: FragmentManager) :FragmentPagerAdapter(fm) {

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "프로필 화면"
            else -> "수강생 목록"
        }
    }

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> FirstFragment()
            else -> SecondFragment()
        }
    }

    override fun getCount(): Int {
        return 2
    }


}