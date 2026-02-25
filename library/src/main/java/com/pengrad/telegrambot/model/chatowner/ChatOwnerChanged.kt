package com.pengrad.telegrambot.model.chatowner

import com.pengrad.telegrambot.model.User

data class ChatOwnerChanged(
    @get:JvmName("newOwner") val newOwner: User
)