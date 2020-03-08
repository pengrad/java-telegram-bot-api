package com.pengrad.telegrambot.model

import com.pengrad.telegrambot.impl.SerialName
import java.io.Serializable

/**
 * Stas Parshin
 * 01 July 2017
 */
data class ChatPhoto(
        @get:JvmName("smallFileId") @SerialName("small_file_id") val smallFileId: String? = null,
        @get:JvmName("smallFileUniqueId") @SerialName("small_file_unique_id") val smallFileUniqueId: String? = null,
        @get:JvmName("bigFileId") @SerialName("big_file_id") val bigFileId: String? = null,
        @get:JvmName("bigFileUniqueId") @SerialName("big_file_unique_id") val bigFileUniqueId: String? = null
) : Serializable {
    companion object {
        private const val serialVersionUID = 0L
    }
}