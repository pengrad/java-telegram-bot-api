package com.pengrad.telegrambot.model

@Suppress("unused")
data class DirectMessagesTopic (
    @get:JvmName("topicId") val topicId: Long,
    @get:JvmName("user") val user: User?
) {
}