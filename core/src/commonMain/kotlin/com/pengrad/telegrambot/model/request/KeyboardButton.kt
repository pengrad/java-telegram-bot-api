package com.pengrad.telegrambot.model.request

import java.io.Serializable

/**
 * Stas Parshin
 * 06 May 2016
 */
class KeyboardButton(private val text: String) : Serializable {
    private var request_contact: Boolean = false
    private var request_location: Boolean = false

    fun requestLocation(requestLocation: Boolean): KeyboardButton {
        request_location = requestLocation
        return this
    }

    fun requestContact(requestContact: Boolean): KeyboardButton {
        request_contact = requestContact
        return this
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}
