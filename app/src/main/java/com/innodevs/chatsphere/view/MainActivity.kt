package com.innodevs.chatsphere.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.innodevs.chatsphere.R
import com.innodevs.chatsphere.adapter.ViewPagerAdapter
import com.innodevs.chatsphere.model.TabItem
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager = findViewById<ViewPager2>(R.id.viewPager)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)

        // Define tabs with their respective fragments
        val tabs = listOf(
            TabItem("Chats", ChatsFragment()),
            TabItem("Status", StatusFragment()),
            TabItem("Calls", CallsFragment())
        )

        // Set up the ViewPager with the adapter
        val adapter = ViewPagerAdapter(this, tabs)
        viewPager.adapter = adapter

        // Connect TabLayout and ViewPager
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabs[position].title
        }.attach()
    }
}