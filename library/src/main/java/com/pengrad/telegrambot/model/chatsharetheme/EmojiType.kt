package com.pengrad.telegrambot.model.chatsharetheme

import java.io.Serializable

interface EmojiType : Serializable {
    val type: String

    companion object {
        const val EMOJI = "emoji"
        const val CUSTOM_EMOJI = "custom_emoji"
        const val UNKNOWN = "unknown"
    }
}
