package com.pengrad.telegrambot.model

data class CommunityChatJoined(
    @get:JvmName("community") val community: Community,
)
