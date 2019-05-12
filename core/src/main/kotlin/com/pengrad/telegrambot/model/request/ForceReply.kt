package com.pengrad.telegrambot.model.request

import java.io.Serializable

/**
 * stas
 * 8/4/15.
 */
class ForceReply @JvmOverloads constructor(private val selective: Boolean = false) : Keyboard(), Serializable {

    private val force_reply = true

    companion object {
        private const val serialVersionUID = 0L
    }
}
