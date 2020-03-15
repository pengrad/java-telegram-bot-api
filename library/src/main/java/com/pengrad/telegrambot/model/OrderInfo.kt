package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * Stas Parshin
 * 24 May 2017
 */
data class OrderInfo(
        @get:JvmName("name") val name: String? = null,
        @get:JvmName("phoneNumber") val phone_number: String? = null,
        @get:JvmName("email") val email: String? = null,
        @get:JvmName("shippingAddress") val shipping_address: ShippingAddress? = null
) : Serializable {
    companion object {
        private const val serialVersionUID = 0L
    }
}