package com.innodevs.chatsphere.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.innodevs.chatsphere.R
import com.innodevs.chatsphere.model.UserChat

class ChatAdapter(private val chatList: List<UserChat>) :
    RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {

    inner class ChatViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val profileImage: ImageView = view.findViewById(R.id.profileImage)
        val userName: TextView = view.findViewById(R.id.userName)
        //val phoneNumber: TextView = view.findViewById(R.id.phoneNumber)
        val lastMessage: TextView = view.findViewById(R.id.lastMessage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_chat, parent, false)
        return ChatViewHolder(view)
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val chat = chatList[position]
        holder.profileImage.setImageResource(chat.profileImage)
        holder.userName.text = chat.phoneNumber
      //  holder.phoneNumber.text = chat.phoneNumber
        holder.lastMessage.text = chat.lastMessage
    }

    override fun getItemCount(): Int = chatList.size
}