package com.pengrad.telegrambot.model

import com.pengrad.telegrambot.impl.SerialName
import java.io.Serializable

/**
 * Stas Parshin
 * 24 May 2017
 */
data class ShippingAddress(
        @get:JvmName("countryCode") @SerialName("country_code") val countryCode: String? = null,
        @get:JvmName("state") val state: String? = null,
        @get:JvmName("city") val city: String? = null,
        @get:JvmName("streetLine1") @SerialName("street_line1") val streetLine1: String? = null,
        @get:JvmName("streetLine2") @SerialName("street_line2") val streetLine2: String? = null,
        @get:JvmName("postCode") @SerialName("post_code") val postCode: String? = null
) : Serializable {
    companion object {
        private const val serialVersionUID = 0L
    }
}