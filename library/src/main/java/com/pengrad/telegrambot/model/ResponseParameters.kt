package com.pengrad.telegrambot.model

import com.pengrad.telegrambot.impl.SerialName
import java.io.Serializable

/**
 * Stas Parshin
 * 03 October 2016
 */
data class ResponseParameters(
        @get:JvmName("migrateToChatId") @SerialName("migrate_to_chat_id") val migrateToChatId: Long? = null,
        @get:JvmName("retryAfter") @SerialName("retry_after") val retryAfter: Int? = null
) : Serializable {
    companion object {
        private const val serialVersionUID = 0L
    }
}