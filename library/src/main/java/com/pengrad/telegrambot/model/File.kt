package com.pengrad.telegrambot.model

import com.pengrad.telegrambot.impl.SerialName
import java.io.Serializable

/**
 * Stas Parshin
 * 16 October 2015
 */
data class File(
        @get:JvmName("fileId") @SerialName("file_id") val fileId: String? = null,
        @get:JvmName("fileUniqueId") @SerialName("file_unique_id") val fileUniqueId: String? = null,
        @get:JvmName("fileSize") @SerialName("file_size") val fileSize: Int? = null,
        @get:JvmName("filePath") @SerialName("file_path") val filePath: String? = null
) : Serializable {
    companion object {
        private const val serialVersionUID = 0L
    }
}