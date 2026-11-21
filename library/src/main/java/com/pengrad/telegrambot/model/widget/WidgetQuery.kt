package com.pengrad.telegrambot.model.widget

import com.pengrad.telegrambot.model.Chat
import com.pengrad.telegrambot.model.User
import java.io.Serializable

data class WidgetQuery(
    @get:JvmName("id") val id: String,
    @get:JvmName("from") val from: User,
    @get:JvmName("chat") val chat: Chat? = null,
    @get:JvmName("messageId") val messageId: Int? = null,
    @get:JvmName("inlineMessageId") val inlineMessageId: String? = null,
    @get:JvmName("chatInstance") val chatInstance: String,
    @get:JvmName("chatType") val chatType: String? = null,
    @get:JvmName("type") val type: WidgetQueryType,
    @get:JvmName("data") val data: String,
    @get:JvmName("widgetId") val widgetId: String? = null,
) : Serializable
