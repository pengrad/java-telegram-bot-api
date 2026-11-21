package com.pengrad.telegrambot.model.chatsharetheme

import java.io.Serializable

interface ChatShareTheme : Serializable {
    val type: String

    companion object {
        const val EMOJI = "emoji"
        const val UNIQUE_GIFT = "unique_gift"
        const val UNKNOWN = "unknown"
    }
}
