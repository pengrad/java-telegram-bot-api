package com.pengrad.telegrambot.model.request

import java.io.Serializable

/**
 * Stas Parshin
 * 06 May 2016
 */
class InputTextMessageContent(private val message_text: String) : InputMessageContent(), Serializable {
    private var parse_mode: ParseMode? = null
    private var disable_web_page_preview: Boolean? = null

    fun parseMode(parseMode: ParseMode): InputTextMessageContent {
        this.parse_mode = parseMode
        return this
    }

    fun disableWebPagePreview(disableWebPagePreview: Boolean?): InputTextMessageContent {
        this.disable_web_page_preview = disableWebPagePreview
        return this
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}
