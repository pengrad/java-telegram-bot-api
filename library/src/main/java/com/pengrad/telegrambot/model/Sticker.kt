package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * stas
 * 8/5/15.
 */
data class Sticker(
        @get:JvmName("fileId") val file_id: String? = null,
        @get:JvmName("fileUniqueId") val file_unique_id: String? = null,
        @get:JvmName("width") val width: Int? = null,
        @get:JvmName("height") val height: Int? = null,
        @get:JvmName("isAnimated") val is_animated: Boolean? = null,
        @get:JvmName("thumb") val thumb: PhotoSize? = null,
        @get:JvmName("emoji") val emoji: String? = null,
        @get:JvmName("setName") val set_name: String? = null,
        @get:JvmName("maskPosition") val mask_position: MaskPosition? = null,
        @get:JvmName("fileSize") val file_size: Int? = null
) : Serializable {
    companion object {
        private const val serialVersionUID = 0L
    }
}