package com.pengrad.telegrambot.model

import com.pengrad.telegrambot.impl.SerialName
import java.io.Serializable

/**
 * Stas Parshin
 * 24 May 2017
 */
data class OrderInfo(
        @get:JvmName("name") val name: String? = null,
        @get:JvmName("phoneNumber") @SerialName("phone_number") val phoneNumber: String? = null,
        @get:JvmName("email") val email: String? = null,
        @get:JvmName("shippingAddress") @SerialName("shipping_address") val shippingAddress: ShippingAddress? = null
) : Serializable {
    companion object {
        private const val serialVersionUID = 0L
    }
}