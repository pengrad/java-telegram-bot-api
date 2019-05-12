package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * Stas Parshin
 * 24 May 2017
 */
class PreCheckoutQuery : Serializable {

    private val id: String? = null
    private val from: User? = null
    private val currency: String? = null
    private val total_amount: Int? = null
    private val invoice_payload: String? = null
    private val shipping_option_id: String? = null
    private val order_info: OrderInfo? = null

    fun id(): String? {
        return id
    }

    fun from(): User? {
        return from
    }

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

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val that = o as PreCheckoutQuery?

        if (if (id != null) id != that!!.id else that!!.id != null) return false
        if (if (from != null) from != that.from else that.from != null) return false
        if (if (currency != null) currency != that.currency else that.currency != null) return false
        if (if (total_amount != null) total_amount != that.total_amount else that.total_amount != null) return false
        if (if (invoice_payload != null) invoice_payload != that.invoice_payload else that.invoice_payload != null)
            return false
        if (if (shipping_option_id != null) shipping_option_id != that.shipping_option_id else that.shipping_option_id != null)
            return false
        return if (order_info != null) order_info == that.order_info else that.order_info == null
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }

    override fun toString(): String {
        return "PreCheckoutQuery{" +
                "id='" + id + '\''.toString() +
                ", from=" + from +
                ", currency='" + currency + '\''.toString() +
                ", total_amount=" + total_amount +
                ", invoice_payload='" + invoice_payload + '\''.toString() +
                ", shipping_option_id='" + shipping_option_id + '\''.toString() +
                ", order_info=" + order_info +
                '}'.toString()
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}
