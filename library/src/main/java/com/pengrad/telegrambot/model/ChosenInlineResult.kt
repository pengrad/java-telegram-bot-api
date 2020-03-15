package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * stas
 * 1/20/16.
 */
data class ChosenInlineResult(
        @get:JvmName("resultId") val result_id: String? = null,
        @get:JvmName("from") val from: User? = null,
        @get:JvmName("location") val location: Location? = null,
        @get:JvmName("inlineMessageId") val inline_message_id: String? = null,
        @get:JvmName("query") val query: String? = null
) : Serializable {
    companion object {
        private const val serialVersionUID = 0L
    }
}