package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * stas
 * 5/3/16.
 */
data class Venue(
        @get:JvmName("location") val location: Location? = null,
        @get:JvmName("title") val title: String? = null,
        @get:JvmName("address") val address: String? = null,
        @get:JvmName("foursquareId") val foursquare_id: String? = null,
        @get:JvmName("foursquareType") val foursquare_type: String? = null
) : Serializable {
    companion object {
        private const val serialVersionUID = 0L
    }
}