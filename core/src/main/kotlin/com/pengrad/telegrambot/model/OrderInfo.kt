package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * Stas Parshin
 * 24 May 2017
 */
class OrderInfo : Serializable {

    private val name: String? = null
    private val phone_number: String? = null
    private val email: String? = null
    private val shipping_address: ShippingAddress? = null

    fun name(): String? {
        return name
    }

    fun phoneNumber(): String? {
        return phone_number
    }

    fun email(): String? {
        return email
    }

    fun shippingAddress(): ShippingAddress? {
        return shipping_address
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val orderInfo = o as OrderInfo?

        if (if (name != null) name != orderInfo!!.name else orderInfo!!.name != null) return false
        if (if (phone_number != null) phone_number != orderInfo.phone_number else orderInfo.phone_number != null) return false
        if (if (email != null) email != orderInfo.email else orderInfo.email != null) return false
        return if (shipping_address != null) shipping_address == orderInfo.shipping_address else orderInfo.shipping_address == null

    }

    override fun hashCode(): Int {
        var result = name?.hashCode() ?: 0
        result = 31 * result + (phone_number?.hashCode() ?: 0)
        result = 31 * result + (email?.hashCode() ?: 0)
        result = 31 * result + (shipping_address?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "OrderInfo{" +
                "name='" + name + '\''.toString() +
                ", phone_number='" + phone_number + '\''.toString() +
                ", email='" + email + '\''.toString() +
                ", shipping_address=" + shipping_address +
                '}'.toString()
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}
