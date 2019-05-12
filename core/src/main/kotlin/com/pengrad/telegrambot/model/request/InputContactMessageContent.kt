package com.pengrad.telegrambot.model.request

import java.io.Serializable

/**
 * Stas Parshin
 * 06 May 2016
 */
class InputContactMessageContent(private val phone_number: String, private val first_name: String) : InputMessageContent(), Serializable {
    private var last_name: String? = null
    private var vcard: String? = null

    fun lastName(lastName: String): InputContactMessageContent {
        this.last_name = lastName
        return this
    }

    fun vcard(vcard: String): InputContactMessageContent {
        this.vcard = vcard
        return this
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}
