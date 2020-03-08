package com.pengrad.telegrambot.model

import com.pengrad.telegrambot.impl.SerialName
import java.io.Serializable

/**
 * Stas Parshin
 * 07 May 2016
 */
data class CallbackQuery(
        @get:JvmName("id") val id: String? = null,
        @get:JvmName("from") val from: User? = null,
        @get:JvmName("message") val message: Message? = null,
        @get:JvmName("inlineMessageId") @SerialName("inline_message_id") val inlineMessageId: String? = null,
        @get:JvmName("chatInstance") @SerialName("chat_instance") val chatInstance: String? = null,
        @get:JvmName("data") val data: String? = null,
        @get:JvmName("gameShortName") @SerialName("game_short_name") val gameShortName: String? = null
) : Serializable {
    companion object {
        private const val serialVersionUID = 0L
    }
}