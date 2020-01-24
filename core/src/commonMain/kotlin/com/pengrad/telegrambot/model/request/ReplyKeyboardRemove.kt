package com.pengrad.telegrambot.model.request

import java.io.Serializable

/**
 * Stas Parshin
 * 23 November 2016
 */
class ReplyKeyboardRemove @JvmOverloads constructor(private val selective: Boolean = false) : Keyboard(), Serializable {

    private val remove_keyboard = true

    companion object {
        private const val serialVersionUID = 0L
    }

}
