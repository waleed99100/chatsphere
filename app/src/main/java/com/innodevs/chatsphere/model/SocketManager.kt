package com.innodevs.chatsphere.model

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.innodevs.chatsphere.R
import io.socket.client.IO
import io.socket.client.Socket
import io.socket.emitter.Emitter
import org.json.JSONArray
import org.json.JSONObject
import java.net.URISyntaxException

class SocketManager(private val context: Context) {

    private lateinit var socket: Socket
    private val _chatData = MutableLiveData<List<UserChat>>()
    val chatData: LiveData<List<UserChat>> get() = _chatData

    init {
        // Initialize Socket.IO connection
        try {
            socket = IO.socket("http://192.168.0.196:3000") // Your server IP
            socket.connect()

            // Listen for 'load-chat-data' event from the server
            socket.on("load-chat-data", Emitter.Listener { args ->
                val data = args[0] as JSONArray
                val chatList = mutableListOf<UserChat>()
                for (i in 0 until data.length()) {
                    val userObject = data.getJSONObject(i)
                    val userChat = UserChat(
                        id = userObject.getString("id"),
                        phoneNumber = userObject.getString("phoneNumber"),
                        profileImage = R.drawable.profile_pic1, // Placeholder, modify as needed
                        lastMessage = userObject.getString("lastMessage")
                    )
                    chatList.add(userChat)
                }

                // Post updated chat list to LiveData
                _chatData.postValue(chatList)
            })

            // Handle connection errors
            socket.on(Socket.EVENT_CONNECT_ERROR) {
                Toast.makeText(context, "Connection failed", Toast.LENGTH_SHORT).show()
            }

        } catch (e: URISyntaxException) {
            e.printStackTrace()
        }
    }

    fun disconnect() {
        if (::socket.isInitialized) {
            socket.disconnect()
        }
    }
}