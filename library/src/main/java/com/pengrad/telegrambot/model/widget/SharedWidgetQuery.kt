package com.pengrad.telegrambot.model.widget

import com.pengrad.telegrambot.model.User
import java.io.Serializable

data class SharedWidgetQuery(
    @get:JvmName("id") val id: String,
    @get:JvmName("from") val from: User,
    @get:JvmName("type") val type: WidgetQueryType,
    @get:JvmName("data") val data: String,
    @get:JvmName("widgetId") val widgetId: String,
) : Serializable
