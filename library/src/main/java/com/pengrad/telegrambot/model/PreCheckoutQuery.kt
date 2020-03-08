package com.pengrad.telegrambot.model

import com.pengrad.telegrambot.impl.SerialName
import java.io.Serializable

/**
 * Stas Parshin
 * 24 May 2017
 */
data class PreCheckoutQuery(
        @get:JvmName("id") val id: String? = null,
        @get:JvmName("from") val from: User? = null,
        @get:JvmName("currency") val currency: String? = null,
        @get:JvmName("totalAmount") @SerialName("total_amount") val totalAmount: Int? = null,
        @get:JvmName("invoicePayload") @SerialName("invoice_payload") val invoicePayload: String? = null,
        @get:JvmName("shippingOptionId") @SerialName("shipping_option_id") val shippingOptionId: String? = null,
        @get:JvmName("orderInfo") @SerialName("order_info") val orderInfo: OrderInfo? = null
) : Serializable {
    companion object {
        private const val serialVersionUID = 0L
    }
}