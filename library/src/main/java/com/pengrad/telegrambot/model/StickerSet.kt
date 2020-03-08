package com.pengrad.telegrambot.model

import com.pengrad.telegrambot.impl.SerialName
import java.io.Serializable

/**
 * Stas Parshin
 * 23 July 2017
 */
data class StickerSet(
        @get:JvmName("name") val name: String? = null,
        @get:JvmName("title") val title: String? = null,
        @get:JvmName("isAnimated") @SerialName("is_animated") val isAnimated: Boolean? = null,
        @get:JvmName("containsMasks") @SerialName("contains_masks") val containsMasks: Boolean? = null,
        @get:JvmSynthetic val stickers: List<Sticker>? = null
) : Serializable {

    fun stickers(): Array<Sticker>? = stickers?.toTypedArray()

    companion object {
        private const val serialVersionUID = 0L
    }
}