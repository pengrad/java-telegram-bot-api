package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * Stas Parshin
 * 04 October 2016
 */
data class GameHighScore(
        @get:JvmName("position") val position: Int? = null,
        @get:JvmName("user") val user: User? = null,
        @get:JvmName("score") val score: Int? = null
) : Serializable {
    companion object {
        private const val serialVersionUID = 0L
    }
}