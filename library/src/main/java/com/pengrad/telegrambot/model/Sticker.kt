package com.pengrad.telegrambot.model

import com.pengrad.telegrambot.impl.SerialName
import java.io.Serializable

/**
 * stas
 * 8/5/15.
 */
data class Sticker(
        @get:JvmName("fileId") @SerialName("file_id") val fileId: String? = null,
        @get:JvmName("fileUniqueId") @SerialName("file_unique_id") val fileUniqueId: String? = null,
        @get:JvmName("width") val width: Int? = null,
        @get:JvmName("height") val height: Int? = null,
        @get:JvmName("isAnimated") @SerialName("is_animated") val isAnimated: Boolean? = null,
        @get:JvmName("thumb") val thumb: PhotoSize? = null,
        @get:JvmName("emoji") val emoji: String? = null,
        @get:JvmName("setName") @SerialName("set_name") val setName: String? = null,
        @get:JvmName("maskPosition") @SerialName("mask_position") val maskPosition: MaskPosition? = null,
        @get:JvmName("fileSize") @SerialName("file_size") val fileSize: Int? = null
) : Serializable {
    companion object {
        private const val serialVersionUID = 0L
    }
}