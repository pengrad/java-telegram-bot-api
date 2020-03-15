package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * Stas Parshin
 * 23 July 2017
 */
data class StickerSet(
        @get:JvmName("name") val name: String? = null,
        @get:JvmName("title") val title: String? = null,
        @get:JvmName("isAnimated") val is_animated: Boolean? = null,
        @get:JvmName("containsMasks") val contains_masks: Boolean? = null,
        @get:JvmSynthetic val stickers: List<Sticker>? = null
) : Serializable {

    fun stickers(): Array<Sticker>? = stickers?.toTypedArray()

    companion object {
        private const val serialVersionUID = 0L
    }
}