package com.innodevs.chatsphere.viewmodel

import androidx.lifecycle.ViewModel
import com.innodevs.chatsphere.model.TabItem
import com.innodevs.chatsphere.view.ChatsFragment
import com.innodevs.chatsphere.view.StatusFragment
import com.innodevs.chatsphere.view.CallsFragment

class TabsViewModel : ViewModel() {

    // List of tabs with titles and corresponding fragments
    val tabs = listOf(
        TabItem("Chats", ChatsFragment()),
        TabItem("Status", StatusFragment()),
        TabItem("Calls", CallsFragment())
    )
}