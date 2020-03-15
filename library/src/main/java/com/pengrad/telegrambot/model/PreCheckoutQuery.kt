package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * Stas Parshin
 * 24 May 2017
 */
data class PreCheckoutQuery(
        @get:JvmName("id") val id: String? = null,
        @get:JvmName("from") val from: User? = null,
        @get:JvmName("currency") val currency: String? = null,
        @get:JvmName("totalAmount") val total_amount: Int? = null,
        @get:JvmName("invoicePayload") val invoice_payload: String? = null,
        @get:JvmName("shippingOptionId") val shipping_option_id: String? = null,
        @get:JvmName("orderInfo") val order_info: OrderInfo? = null
) : Serializable {
    companion object {
        private const val serialVersionUID = 0L
    }
}