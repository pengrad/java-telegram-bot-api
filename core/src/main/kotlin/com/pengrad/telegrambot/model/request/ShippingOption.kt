package com.pengrad.telegrambot.model.request

import java.io.Serializable

/**
 * Stas Parshin
 * 24 May 2017
 */
class ShippingOption(
        private val id: String,
        private val title: String,
        private vararg val prices: LabeledPrice
) : Serializable {
    companion object {
        @JvmStatic
        private val serialVersionUID = 0L

    }
}
