package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * stas
 * 8/5/15.
 */
class Contact : Serializable {

    private val phone_number: String? = null
    private val first_name: String? = null
    private val last_name: String? = null
    private val user_id: Int? = null
    private val vcard: String? = null

    fun phoneNumber(): String? {
        return phone_number
    }

    fun firstName(): String? {
        return first_name
    }

    fun lastName(): String? {
        return last_name
    }

    fun userId(): Int? {
        return user_id
    }

    fun vcard(): String? {
        return vcard
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val contact = o as Contact?

        if (if (phone_number != null) phone_number != contact!!.phone_number else contact!!.phone_number != null) return false
        if (if (first_name != null) first_name != contact.first_name else contact.first_name != null) return false
        if (if (last_name != null) last_name != contact.last_name else contact.last_name != null) return false
        if (if (user_id != null) user_id != contact.user_id else contact.user_id != null) return false
        return if (vcard != null) vcard == contact.vcard else contact.vcard == null
    }

    override fun hashCode(): Int {
        return phone_number?.hashCode() ?: 0
    }

    override fun toString(): String {
        return "Contact{" +
                "phone_number='" + phone_number + '\''.toString() +
                ", first_name='" + first_name + '\''.toString() +
                ", last_name='" + last_name + '\''.toString() +
                ", user_id=" + user_id +
                ", vcard='" + vcard + '\''.toString() +
                '}'.toString()
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}
