package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * Stas Parshin
 * 24 May 2017
 */
data class SuccessfulPayment(
        @get:JvmName("currency") val currency: String? = null,
        @get:JvmName("totalAmount") val total_amount: Int? = null,
        @get:JvmName("invoicePayload") val invoice_payload: String? = null,
        @get:JvmName("shippingOptionId") val shipping_option_id: String? = null,
        @get:JvmName("orderInfo") val order_info: OrderInfo? = null,
        @get:JvmName("telegramPaymentChargeId") val telegram_payment_charge_id: String? = null,
        @get:JvmName("providerPaymentChargeId") val provider_payment_charge_id: String? = null
) : Serializable {
    companion object {
        private const val serialVersionUID = 0L
    }
}