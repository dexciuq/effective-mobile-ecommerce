package com.dexciuq.effective_mobile.presentation.screen.picture

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class PictureViewPagerAdapter(
    fragmentActivity: FragmentActivity,
    private val pictureList: List<Int>,
) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = pictureList.size

    override fun createFragment(position: Int): Fragment {
        val picture = pictureList[position]
        return PictureFragment.newInstance(picture)
    }
}