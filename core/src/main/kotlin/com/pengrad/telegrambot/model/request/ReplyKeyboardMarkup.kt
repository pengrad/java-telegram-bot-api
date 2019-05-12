package com.pengrad.telegrambot.model.request

import java.io.Serializable

/**
 * stas
 * 8/4/15.
 */
class ReplyKeyboardMarkup(
        private val keyboard: Array<out Array<KeyboardButton>>,
        private var resize_keyboard: Boolean = false,
        private var one_time_keyboard: Boolean = false,
        private var selective: Boolean = false
) : Keyboard(), Serializable {

    constructor(vararg keyboard: Array<String>) : this(
            keyboard.map { it.map { text -> KeyboardButton(text) }.toTypedArray() }.toTypedArray()
    )

    constructor(vararg keyboard: Array<KeyboardButton>) : this(keyboard)

    fun resizeKeyboard(resizeKeyboard: Boolean): ReplyKeyboardMarkup {
        val r = ReplyKeyboardMarkup(arrayOf(KeyboardButton(""), KeyboardButton("")))
        this.resize_keyboard = resizeKeyboard
        return this
    }

    fun oneTimeKeyboard(oneTimeKeyboard: Boolean): ReplyKeyboardMarkup {
        this.one_time_keyboard = oneTimeKeyboard
        return this
    }

    fun selective(selective: Boolean): ReplyKeyboardMarkup {
        this.selective = selective
        return this
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}
