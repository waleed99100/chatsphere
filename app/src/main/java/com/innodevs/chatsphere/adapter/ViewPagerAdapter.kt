package com.innodevs.chatsphere.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.innodevs.chatsphere.model.TabItem

class ViewPagerAdapter(
    fragmentActivity: FragmentActivity,
    private val tabs: List<TabItem>
) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int = tabs.size

    override fun createFragment(position: Int): Fragment = tabs[position].fragment
}