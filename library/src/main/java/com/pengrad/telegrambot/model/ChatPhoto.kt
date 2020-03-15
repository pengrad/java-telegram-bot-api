package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * Stas Parshin
 * 01 July 2017
 */
data class ChatPhoto(
        @get:JvmName("smallFileId") val small_file_id: String? = null,
        @get:JvmName("smallFileUniqueId") val small_file_unique_id: String? = null,
        @get:JvmName("bigFileId") val big_file_id: String? = null,
        @get:JvmName("bigFileUniqueId") val big_file_unique_id: String? = null
) : Serializable {
    companion object {
        private const val serialVersionUID = 0L
    }
}