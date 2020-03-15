package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * Stas Parshin
 * 07 May 2016
 */
data class CallbackQuery(
        @get:JvmName("id") val id: String? = null,
        @get:JvmName("from") val from: User? = null,
        @get:JvmName("message") val message: Message? = null,
        @get:JvmName("inlineMessageId") val inline_message_id: String? = null,
        @get:JvmName("chatInstance") val chat_instance: String? = null,
        @get:JvmName("data") val data: String? = null,
        @get:JvmName("gameShortName") val game_short_name: String? = null
) : Serializable {
    companion object {
        private const val serialVersionUID = 0L
    }
}