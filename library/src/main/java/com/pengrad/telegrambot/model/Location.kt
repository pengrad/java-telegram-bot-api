package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * stas
 * 8/5/15.
 */
data class Location(
        @get:JvmName("longitude") val longitude: Float? = null,
        @get:JvmName("latitude") val latitude: Float? = null
) : Serializable {
    companion object {
        private const val serialVersionUID = 0L
    }
}