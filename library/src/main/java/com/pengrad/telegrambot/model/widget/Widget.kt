package com.pengrad.telegrambot.model.widget

import java.io.Serializable

data class Widget(
    @get:JvmName("id") val id: String? = null,
    @get:JvmName("width") val width: Int? = null,
    @get:JvmName("height") val height: Int? = null,
    @get:JvmName("html") val html: String,
    @get:JvmName("publicData") val publicData: String? = null,
    @get:JvmName("chatData") val chatData: String? = null,
) : Serializable
