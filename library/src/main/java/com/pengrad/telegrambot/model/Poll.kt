package com.pengrad.telegrambot.model

import com.pengrad.telegrambot.impl.SerialName
import java.io.Serializable
import java.util.*

/**
 * Stas Parshin
 * 17 April 2019
 */
data class Poll(
        @get:JvmName("id") val id: String? = null,
        @get:JvmName("question") val question: String? = null,
        @get:JvmSynthetic val options: List<PollOption>? = null,
        @get:JvmName("totalVoterCount") @SerialName("total_voter_count") val totalVoterCount: Int? = null,
        @get:JvmName("isClosed") @SerialName("is_closed") val isClosed: Boolean? = null,
        @get:JvmName("isAnonymous") @SerialName("is_anonymous") val isAnonymous: Boolean? = null,
        @get:JvmName("type") val type: Type? = null,
        @get:JvmName("allowsMultipleAnswers") @SerialName("allows_multiple_answers") val allowsMultipleAnswers: Boolean? = null,
        @get:JvmName("correctOptionId") @SerialName("correct_option_id") val correctOptionId: Int? = null
) : Serializable {

    enum class Type {
        quiz, regular
    }

    fun options(): Array<PollOption>? = options?.toTypedArray()

    companion object {
        private const val serialVersionUID = 0L
    }
}