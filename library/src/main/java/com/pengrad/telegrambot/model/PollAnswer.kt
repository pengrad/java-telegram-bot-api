package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * Stas Parshin
 * 25 January 2020
 */
data class PollAnswer(
        @get:JvmName("pollId") val poll_id: String? = null,
        @get:JvmName("user") val user: User? = null,
        @get:JvmSynthetic val option_ids: List<Int>? = null
) : Serializable {

    fun optionIds(): Array<Int>? = option_ids?.toTypedArray()

    companion object {
        private const val serialVersionUID = 0L
    }
}