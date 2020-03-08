package com.pengrad.telegrambot.model

import com.pengrad.telegrambot.impl.SerialName
import java.io.Serializable

/**
 * stas
 * 8/5/15.
 */
data class UserProfilePhotos(
        @get:JvmName("totalCount") @SerialName("total_count") val totalCount: Int? = null,
        @get:JvmSynthetic val photos: List<List<PhotoSize>>? = null
) : Serializable {

    fun photos(): Array<Array<PhotoSize>>? = photos?.map { it.toTypedArray() }?.toTypedArray()

    companion object {
        private const val serialVersionUID = 0L
    }
}