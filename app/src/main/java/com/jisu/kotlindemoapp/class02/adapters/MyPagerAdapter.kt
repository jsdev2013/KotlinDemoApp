package com.jisu.kotlindemoapp.class02.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.jisu.kotlindemoapp.class02.fragments.FirstFragment
import com.jisu.kotlindemoapp.class02.fragments.SecondFragment
import com.jisu.kotlindemoapp.class02.fragments.ThirdFragment

class MyPagerAdapter (fm: FragmentManager) :FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment {
//        if(position == 0) {
//            return FirstFragment()
//        } else if (position ==1) {
//            return SecondFragment()
//        } else {
//            return ThirdFragment()
//        }

        return when(position){
            0 -> FirstFragment()
            1 -> SecondFragment()
            else -> ThirdFragment()
        }
    }

    override fun getCount(): Int {
        return 3
    }

}