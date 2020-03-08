package com.pengrad.telegrambot.model

import com.pengrad.telegrambot.impl.SerialName
import java.io.Serializable

/**
 * stas
 * 5/3/16.
 */
data class Venue(
        @get:JvmName("location") val location: Location? = null,
        @get:JvmName("title") val title: String? = null,
        @get:JvmName("address") val address: String? = null,
        @get:JvmName("foursquareId") @SerialName("foursquare_id") val foursquareId: String? = null,
        @get:JvmName("foursquareType") @SerialName("foursquare_type") val foursquareType: String? = null
) : Serializable {
    companion object {
        private const val serialVersionUID = 0L
    }
}