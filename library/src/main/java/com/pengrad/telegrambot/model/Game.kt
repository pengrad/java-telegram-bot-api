package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * Stas Parshin
 * 03 October 2016
 */
data class Game(
        @get:JvmName("title") val title: String? = null,
        @get:JvmName("description") val description: String? = null,
        @get:JvmSynthetic val photo: List<PhotoSize>? = null,
        @get:JvmName("text") val text: String? = null,
        @get:JvmSynthetic val text_entities: List<MessageEntity>? = null,
        @get:JvmName("animation") val animation: Animation? = null
) : Serializable {

    fun photo(): Array<PhotoSize>? = photo?.toTypedArray()
    fun textEntities(): Array<MessageEntity>? = text_entities?.toTypedArray()

    companion object {
        private const val serialVersionUID = 0L
    }
}