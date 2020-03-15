package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * Stas Parshin
 * 24 May 2017
 */
data class ShippingAddress(
        @get:JvmName("countryCode") val country_code: String? = null,
        @get:JvmName("state") val state: String? = null,
        @get:JvmName("city") val city: String? = null,
        @get:JvmName("streetLine1") val street_line1: String? = null,
        @get:JvmName("streetLine2") val street_line2: String? = null,
        @get:JvmName("postCode") val post_code: String? = null
) : Serializable {
    companion object {
        private const val serialVersionUID = 0L
    }
}