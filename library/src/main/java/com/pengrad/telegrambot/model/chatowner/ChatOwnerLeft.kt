package com.pengrad.telegrambot.model.chatowner

import com.pengrad.telegrambot.model.User

data class ChatOwnerLeft(
    @get:JvmName("newOwner") val newOwner: User
)