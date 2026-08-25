package com.pengrad.telegrambot.model

data class CommunityChatAdded(
    @get:JvmName("community") val community: Community,
)
