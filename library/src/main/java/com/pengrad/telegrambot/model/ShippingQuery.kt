package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * Stas Parshin
 * 24 May 2017
 */
data class ShippingQuery(
        @get:JvmName("id") val id: String? = null,
        @get:JvmName("from") val from: User? = null,
        @get:JvmName("invoicePayload") val invoice_payload: String? = null,
        @get:JvmName("shippingAddress") val shipping_address: ShippingAddress? = null
) : Serializable {
    companion object {
        private const val serialVersionUID = 0L
    }
}