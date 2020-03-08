package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * stas
 * 5/3/16.
 */
data class MessageEntity(
        @get:JvmName("type") val type: Type? = null,
        @get:JvmName("offset") val offset: Int? = null,
        @get:JvmName("length") val length: Int? = null,
        @get:JvmName("url") val url: String? = null,
        @get:JvmName("user") val user: User? = null,
        @get:JvmName("language") val language: String? = null
) : Serializable {

    enum class Type {
        mention, hashtag, cashtag, bot_command, url, email, phone_number, bold, italic, code, pre, text_link, text_mention, underline, strikethrough
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}