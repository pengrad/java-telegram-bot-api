package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * Stas Parshin
 * 03 October 2016
 */
data class ResponseParameters(
        @get:JvmName("migrateToChatId") val migrate_to_chat_id: Long? = null,
        @get:JvmName("retryAfter") val retry_after: Int? = null
) : Serializable {
    companion object {
        private const val serialVersionUID = 0L
    }
}