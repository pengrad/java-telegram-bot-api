package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * Stas Parshin
 * 17 April 2019
 */
data class PollOption(
        @get:JvmName("text") val text: String? = null,
        @get:JvmName("voterCount") val voter_count: Int? = null
) : Serializable {
    companion object {
        private const val serialVersionUID = 0L
    }
}