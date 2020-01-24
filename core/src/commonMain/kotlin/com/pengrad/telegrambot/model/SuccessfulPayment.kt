package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * Stas Parshin
 * 24 May 2017
 */
class SuccessfulPayment : Serializable {

    private val currency: String? = null
    private val total_amount: Int? = null
    private val invoice_payload: String? = null
    private val shipping_option_id: String? = null
    private val order_info: OrderInfo? = null
    private val telegram_payment_charge_id: String? = null
    private val provider_payment_charge_id: String? = null

    fun currency(): String? {
        return currency
    }

    fun totalAmount(): Int? {
        return total_amount
    }

    fun invoicePayload(): String? {
        return invoice_payload
    }

    fun shippingOptionId(): String? {
        return shipping_option_id
    }

    fun orderInfo(): OrderInfo? {
        return order_info
    }

    fun telegramPaymentChargeId(): String? {
        return telegram_payment_charge_id
    }

    fun providerPaymentChargeId(): String? {
        return provider_payment_charge_id
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val that = o as SuccessfulPayment?

        if (if (currency != null) currency != that!!.currency else that!!.currency != null) return false
        if (if (total_amount != null) total_amount != that.total_amount else that.total_amount != null) return false
        if (if (invoice_payload != null) invoice_payload != that.invoice_payload else that.invoice_payload != null)
            return false
        if (if (shipping_option_id != null) shipping_option_id != that.shipping_option_id else that.shipping_option_id != null)
            return false
        if (if (order_info != null) order_info != that.order_info else that.order_info != null) return false
        if (if (telegram_payment_charge_id != null) telegram_payment_charge_id != that.telegram_payment_charge_id else that.telegram_payment_charge_id != null)
            return false
        return if (provider_payment_charge_id != null) provider_payment_charge_id == that.provider_payment_charge_id else that.provider_payment_charge_id == null

    }

    override fun hashCode(): Int {
        var result = currency?.hashCode() ?: 0
        result = 31 * result + (total_amount?.hashCode() ?: 0)
        result = 31 * result + (invoice_payload?.hashCode() ?: 0)
        result = 31 * result + (shipping_option_id?.hashCode() ?: 0)
        result = 31 * result + (order_info?.hashCode() ?: 0)
        result = 31 * result + (telegram_payment_charge_id?.hashCode() ?: 0)
        result = 31 * result + (provider_payment_charge_id?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "SuccessfulPayment{" +
                "currency='" + currency + '\''.toString() +
                ", total_amount=" + total_amount +
                ", invoice_payload='" + invoice_payload + '\''.toString() +
                ", shipping_option_id='" + shipping_option_id + '\''.toString() +
                ", order_info=" + order_info +
                ", telegram_payment_charge_id='" + telegram_payment_charge_id + '\''.toString() +
                ", provider_payment_charge_id='" + provider_payment_charge_id + '\''.toString() +
                '}'.toString()
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}
