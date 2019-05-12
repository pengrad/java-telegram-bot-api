package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * Stas Parshin
 * 24 May 2017
 */
class ShippingQuery : Serializable {

    private val id: String? = null
    private val from: User? = null
    private val invoice_payload: String? = null
    private val shipping_address: ShippingAddress? = null

    fun id(): String? {
        return id
    }

    fun from(): User? {
        return from
    }

    fun invoicePayload(): String? {
        return invoice_payload
    }

    fun shippingAddress(): ShippingAddress? {
        return shipping_address
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val that = o as ShippingQuery?

        if (if (id != null) id != that!!.id else that!!.id != null) return false
        if (if (from != null) from != that.from else that.from != null) return false
        if (if (invoice_payload != null) invoice_payload != that.invoice_payload else that.invoice_payload != null)
            return false
        return if (shipping_address != null) shipping_address == that.shipping_address else that.shipping_address == null
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }

    override fun toString(): String {
        return "ShippingQuery{" +
                "id='" + id + '\''.toString() +
                ", from=" + from +
                ", invoice_payload='" + invoice_payload + '\''.toString() +
                ", shipping_address=" + shipping_address +
                '}'.toString()
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}
