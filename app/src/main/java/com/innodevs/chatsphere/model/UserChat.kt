package com.innodevs.chatsphere.model

data class UserChat(
    val id: String,
    val phoneNumber: String,
    val profileImage: Int,  // Resource ID for the profile picture
    val lastMessage: String
)