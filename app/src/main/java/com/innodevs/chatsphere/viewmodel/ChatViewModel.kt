package com.innodevs.chatsphere.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.innodevs.chatsphere.model.SocketManager
import com.innodevs.chatsphere.model.UserChat



class ChatViewModel(context: Context) : ViewModel() {

    private val socketManager = SocketManager(context)

    // Exposes LiveData of chat data to observe in the fragment
    val chatData: LiveData<List<UserChat>> = socketManager.chatData

    // Disconnect the socket when no longer needed
    fun disconnectSocket() {
        socketManager.disconnect()
    }
}