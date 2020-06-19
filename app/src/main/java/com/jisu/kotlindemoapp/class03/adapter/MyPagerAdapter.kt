package com.jisu.kotlindemoapp.class03.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.jisu.kotlindemoapp.class03.fragmentsMain.MainEtcFragment
import com.jisu.kotlindemoapp.class03.fragmentsMain.MainFirstFragment
import com.jisu.kotlindemoapp.class03.fragmentsMain.MainSecondFragment
import com.jisu.kotlindemoapp.class03.fragmentsMain.MainThirdFragment
import com.jisu.kotlindemoapp.class03.fragmentsStore.ChickenFragment
import com.jisu.kotlindemoapp.class03.fragmentsStore.PizzaFragment
import com.jisu.kotlindemoapp.class03.fragmentsStore.Sub01MenuImgFragment
import com.jisu.kotlindemoapp.class03.fragmentsStore.Sub02ItemImgFragment
import com.jisu.kotlindemoapp.class03.fragmentsSub.SubFirstFragment
import com.jisu.kotlindemoapp.class03.fragmentsSub.SubSecondFragment
import com.jisu.kotlindemoapp.class03.fragmentsTab.Class03LbTabLayoutVtT1Fragment

class MyPagerAdapter (fm: FragmentManager, FragmentCd :String) :FragmentPagerAdapter(fm) {

    val whichFragments = FragmentCd

    override fun getPageTitle(position: Int): CharSequence? {

        return when(whichFragments){
            "Main" -> when (position)  {  0 -> "프로필 화면"
                                          1 -> "수강생 목록"
                                          else -> "뷰페이저 화면"}
            "StoreMain" -> when (position) {  0 -> "피자가게"
                                              else -> "치킨가게"}
            "StoreDetail" -> when (position) {  0 -> "이달의 베스트 메뉴"
                                                else -> "이벤트"}
            "TabVt" -> when (position)  {   0 -> "프로필변경"
                                            1 -> "총급여액"
                                            2 -> "인적공제"
                                            3 -> "소득공제"
                                            4 -> "세액감면"
                                            5 -> "세액공제"
                                           else -> "상세결과"}
            else -> "없음"
        }
    }

    override fun getItem(position: Int): Fragment {
        return when(whichFragments){
            "Main" -> when (position)  {  0 -> MainFirstFragment()
                                          1 -> MainSecondFragment()
                                          else -> MainThirdFragment()}
            "Sub" -> when (position) {  0 -> SubFirstFragment()
                                        else -> SubSecondFragment()}
            "StoreMain" -> when (position) {  0 -> PizzaFragment()
                                              else -> ChickenFragment()}
            "StoreDetail" -> when (position) {  0 -> Sub01MenuImgFragment()
                                                else -> Sub02ItemImgFragment()}
            "TabVt" -> when (position)  {   0 -> Class03LbTabLayoutVtT1Fragment()
                                            1 -> Class03LbTabLayoutVtT1Fragment()
                                            2 -> Class03LbTabLayoutVtT1Fragment()
                                            3 -> Class03LbTabLayoutVtT1Fragment()
                                            4 -> Class03LbTabLayoutVtT1Fragment()
                                            5 -> Class03LbTabLayoutVtT1Fragment()
                                            else -> Class03LbTabLayoutVtT1Fragment()}
            else -> MainEtcFragment()
        }
    }

    override fun getCount(): Int {
        return when(whichFragments){
            "Main" -> return 3
            "Sub" -> return 2
            "StoreMain" -> return 2
            "StoreDetail" -> return 2
            "TabVt" -> return 7
            else -> return 0
        }
    }
}