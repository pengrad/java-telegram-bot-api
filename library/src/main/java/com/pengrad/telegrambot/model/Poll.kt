package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * Stas Parshin
 * 17 April 2019
 */
data class Poll(
        @get:JvmName("id") val id: String? = null,
        @get:JvmName("question") val question: String? = null,
        @get:JvmSynthetic val options: List<PollOption>? = null,
        @get:JvmName("totalVoterCount") val total_voter_count: Int? = null,
        @get:JvmName("isClosed") val is_closed: Boolean? = null,
        @get:JvmName("isAnonymous") val is_anonymous: Boolean? = null,
        @get:JvmName("type") val type: Type? = null,
        @get:JvmName("allowsMultipleAnswers") val allows_multiple_answers: Boolean? = null,
        @get:JvmName("correctOptionId") val correct_option_id: Int? = null
) : Serializable {

    enum class Type {
        quiz, regular
    }

    fun options(): Array<PollOption>? = options?.toTypedArray()

    companion object {
        private const val serialVersionUID = 0L
    }
}