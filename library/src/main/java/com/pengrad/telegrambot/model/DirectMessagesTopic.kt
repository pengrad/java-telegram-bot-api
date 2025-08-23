package com.pengrad.telegrambot.model

@Suppress("unused")
data class DirectMessagesTopic (
    @get:JvmName("topicId") val topicId: Int,
    @get:JvmName("user") val user: User?
) {
}