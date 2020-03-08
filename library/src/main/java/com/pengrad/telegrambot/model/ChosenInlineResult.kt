package com.pengrad.telegrambot.model

import com.pengrad.telegrambot.impl.SerialName
import java.io.Serializable

/**
 * stas
 * 1/20/16.
 */
data class ChosenInlineResult(
        @get:JvmName("resultId") @SerialName("result_id") val resultId: String? = null,
        @get:JvmName("from") val from: User? = null,
        @get:JvmName("location") val location: Location? = null,
        @get:JvmName("inlineMessageId") @SerialName("inline_message_id") val inlineMessageId: String? = null,
        @get:JvmName("query") @SerialName("query") val query: String? = null
) : Serializable {
    companion object {
        private const val serialVersionUID = 0L
    }
}