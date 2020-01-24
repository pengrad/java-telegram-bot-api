package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * Stas Parshin
 * 24 May 2017
 */
class ShippingAddress : Serializable {

    private val country_code: String? = null
    private val state: String? = null
    private val city: String? = null
    private val street_line1: String? = null
    private val street_line2: String? = null
    private val post_code: String? = null

    fun countryCode(): String? {
        return country_code
    }

    fun state(): String? {
        return state
    }

    fun city(): String? {
        return city
    }

    fun streetLine1(): String? {
        return street_line1
    }

    fun streetLine2(): String? {
        return street_line2
    }

    fun postCode(): String? {
        return post_code
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val that = o as ShippingAddress?

        if (if (country_code != null) country_code != that!!.country_code else that!!.country_code != null) return false
        if (if (state != null) state != that.state else that.state != null) return false
        if (if (city != null) city != that.city else that.city != null) return false
        if (if (street_line1 != null) street_line1 != that.street_line1 else that.street_line1 != null) return false
        if (if (street_line2 != null) street_line2 != that.street_line2 else that.street_line2 != null) return false
        return if (post_code != null) post_code == that.post_code else that.post_code == null

    }

    override fun hashCode(): Int {
        var result = country_code?.hashCode() ?: 0
        result = 31 * result + (state?.hashCode() ?: 0)
        result = 31 * result + (city?.hashCode() ?: 0)
        result = 31 * result + (street_line1?.hashCode() ?: 0)
        result = 31 * result + (street_line2?.hashCode() ?: 0)
        result = 31 * result + (post_code?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "ShippingAddress{" +
                "country_code='" + country_code + '\''.toString() +
                ", state='" + state + '\''.toString() +
                ", city='" + city + '\''.toString() +
                ", street_line1='" + street_line1 + '\''.toString() +
                ", street_line2='" + street_line2 + '\''.toString() +
                ", post_code='" + post_code + '\''.toString() +
                '}'.toString()
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}
