package com.pengrad.telegrambot.model.request

import java.io.Serializable

/**
 * Stas Parshin
 * 06 May 2016
 */
class InputLocationMessageContent(private val latitude: Float?, private val longitude: Float?) : InputMessageContent(), Serializable {
    private var live_period: Int? = null

    fun livePeriod(livePeriod: Int?): InputLocationMessageContent {
        live_period = livePeriod
        return this
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}
