package com.jisu.kotlindemoapp.class03.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.jisu.kotlindemoapp.class03.fragmentsMain.MainFirstFragment
import com.jisu.kotlindemoapp.class03.fragmentsMain.MainSecondFragment
import com.jisu.kotlindemoapp.class03.fragmentsMain.MainThirdFragment
import com.jisu.kotlindemoapp.class03.fragmentsSub.SubFirstFragment
import com.jisu.kotlindemoapp.class03.fragmentsSub.SubSecondFragment

class MyPagerAdapter (fm: FragmentManager, FragmentCd :String) :FragmentPagerAdapter(fm) {

    val whichFragments = FragmentCd

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "프로필 화면"
            1 -> "수강생 목록"
            else -> "뷰페이저 화면"
        }
    }

    override fun getItem(position: Int): Fragment {
        return when(whichFragments){
            "Sub" -> when (position) {  0 -> SubFirstFragment()
                                        else -> SubSecondFragment()}
            else -> when (position)  {  0 -> MainFirstFragment()
                                        1 -> MainSecondFragment()
                                        else -> MainThirdFragment()}
        }
    }

    override fun getCount(): Int {
        return when(whichFragments){
            "Sub" -> return 2
            else -> return 3
        }
    }
}