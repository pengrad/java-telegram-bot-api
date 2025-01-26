package com.pengrad.telegrambot.model

data class SuccessfulPayment(
    @get:JvmName("currency") val currency: String,
    @get:JvmName("totalAmount") val totalAmount: Int,
    @get:JvmName("invoicePayload") val invoicePayload: String,
    @get:JvmName("subscriptionExpirationDate") val subscriptionExpirationDate: Int? = null,
    @get:JvmName("isRecurring") val isRecurring: Boolean? = null,
    @get:JvmName("isFirstRecurring") val isFirstRecurring: Boolean? = null,
    @get:JvmName("shippingOptionId") val shippingOptionId: String? = null,
    @get:JvmName("orderInfo") val orderInfo: OrderInfo? = null,
    @get:JvmName("telegramPaymentChargeId") val telegramPaymentChargeId: String,
    @get:JvmName("providerPaymentChargeId") val providerPaymentChargeId: String
)
