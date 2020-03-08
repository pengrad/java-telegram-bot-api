package com.pengrad.telegrambot.model

import com.pengrad.telegrambot.impl.SerialName
import java.io.Serializable
import java.util.*

/**
 * Stas Parshin
 * 25 January 2020
 */
data class PollAnswer(
        @get:JvmName("pollId") @SerialName("poll_id") val pollId: String? = null,
        @get:JvmName("user") val user: User? = null,
        @get:JvmSynthetic @SerialName("option_ids") val optionIds: List<Int>? = null
) : Serializable {

    fun optionIds(): Array<Int>? = optionIds?.toTypedArray()

    companion object {
        private const val serialVersionUID = 0L
    }
}