package com.pengrad.telegrambot.model.request

import java.io.Serializable

/**
 * stas
 * 1/12/16.
 */
abstract class InlineQueryResult<T>(
        private val type: String,
        private val id: String
) : Serializable {

    private val thisAsT = this as T
    private var input_message_content: InputMessageContent? = null
    private var reply_markup: InlineKeyboardMarkup? = null

    fun inputMessageContent(inputMessageContent: InputMessageContent): T {
        this.input_message_content = inputMessageContent
        return thisAsT
    }

    fun replyMarkup(replyMarkup: InlineKeyboardMarkup): T {
        this.reply_markup = replyMarkup
        return thisAsT
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}
