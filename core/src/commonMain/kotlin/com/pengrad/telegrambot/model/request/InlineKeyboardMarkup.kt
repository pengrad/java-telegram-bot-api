package com.pengrad.telegrambot.model.request

import java.io.Serializable

/**
 * stas
 * 8/4/15.
 */
class InlineKeyboardMarkup(vararg keyboard: Array<InlineKeyboardButton>) : Keyboard(), Serializable {

    private val inline_keyboard: Array<out Array<InlineKeyboardButton>> = keyboard

    companion object {
        private const val serialVersionUID = 0L
    }
}
