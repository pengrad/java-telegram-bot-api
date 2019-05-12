package com.pengrad.telegrambot.model.request

import java.io.Serializable

/**
 * Stas Parshin
 * 24 May 2017
 */
class LabeledPrice(private val label: String, private val amount: Int?) : Serializable {
    companion object {
        private const val serialVersionUID = 0L
    }
}
