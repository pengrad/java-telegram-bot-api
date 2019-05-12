package com.pengrad.telegrambot.model.request

import java.io.Serializable

/**
 * stas
 * 8/4/15.
 */
@Deprecated("")
class ReplyKeyboardHide @JvmOverloads constructor(private val selective: Boolean = false) : Keyboard(), Serializable {

    private val hide_keyboard = true

    companion object {
        private const val serialVersionUID = 0L
    }
}
