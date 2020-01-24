package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * Stas Parshin
 * 24 May 2017
 */
class Invoice : Serializable {

    private val title: String? = null
    private val description: String? = null
    private val start_parameter: String? = null
    private val currency: String? = null
    private val total_amount: Int? = null

    fun title(): String? {
        return title
    }

    fun description(): String? {
        return description
    }

    fun startParameter(): String? {
        return start_parameter
    }

    fun currency(): String? {
        return currency
    }

    fun totalAmount(): Int? {
        return total_amount
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val invoice = o as Invoice?

        if (if (title != null) title != invoice!!.title else invoice!!.title != null) return false
        if (if (description != null) description != invoice.description else invoice.description != null) return false
        if (if (start_parameter != null) start_parameter != invoice.start_parameter else invoice.start_parameter != null)
            return false
        if (if (currency != null) currency != invoice.currency else invoice.currency != null) return false
        return if (total_amount != null) total_amount == invoice.total_amount else invoice.total_amount == null
    }

    override fun hashCode(): Int {
        var result = title?.hashCode() ?: 0
        result = 31 * result + (description?.hashCode() ?: 0)
        result = 31 * result + (start_parameter?.hashCode() ?: 0)
        result = 31 * result + (currency?.hashCode() ?: 0)
        result = 31 * result + (total_amount?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "Invoice{" +
                "title='" + title + '\''.toString() +
                ", description='" + description + '\''.toString() +
                ", start_parameter='" + start_parameter + '\''.toString() +
                ", currency='" + currency + '\''.toString() +
                ", total_amount=" + total_amount +
                '}'.toString()
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}
