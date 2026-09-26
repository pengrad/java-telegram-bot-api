package com.pengrad.telegrambot.model

data class MessageGenerationStopped(
    @get:JvmName("chat") val chat: Chat,
    @get:JvmName("messageThreadId") val messageThreadId: Long? = null,
    @get:JvmName("draftId") val draftId: Int,
)
