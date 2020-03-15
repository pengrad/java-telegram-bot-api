package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * stas
 * 8/5/15.
 */
data class UserProfilePhotos(
        @get:JvmName("totalCount") val total_count: Int? = null,
        @get:JvmSynthetic val photos: List<List<PhotoSize>>? = null
) : Serializable {

    fun photos(): Array<Array<PhotoSize>>? = photos?.map { it.toTypedArray() }?.toTypedArray()

    companion object {
        private const val serialVersionUID = 0L
    }
}