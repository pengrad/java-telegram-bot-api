package com.pengrad.telegrambot.model

import com.pengrad.telegrambot.impl.SerialName
import java.io.Serializable

/**
 * Stas Parshin
 * 24 May 2017
 */
data class ShippingQuery(
        @get:JvmName("id") val id: String? = null,
        @get:JvmName("from") val from: User? = null,
        @get:JvmName("invoicePayload") @SerialName("invoice_payload") val invoicePayload: String? = null,
        @get:JvmName("shippingAddress") @SerialName("shipping_address") val shippingAddress: ShippingAddress? = null
) : Serializable {
    companion object {
        private const val serialVersionUID = 0L
    }
}