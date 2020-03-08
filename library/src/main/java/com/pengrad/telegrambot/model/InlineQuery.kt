package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * stas
 * 1/12/16.
 */
data class InlineQuery(
        @get:JvmName("id") val id: String? = null,
        @get:JvmName("from") val from: User? = null,
        @get:JvmName("location") val location: Location? = null,
        @get:JvmName("query") val query: String? = null,
        @get:JvmName("offset") val offset: String? = null
) : Serializable {
    companion object {
        private const val serialVersionUID = 0L
    }
}