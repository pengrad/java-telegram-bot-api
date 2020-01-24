package com.pengrad.telegrambot.model.request

import java.io.Serializable

/**
 * Stas Parshin
 * 06 May 2016
 */
class InlineKeyboardButton
//todo can use only one optional field, make different constructors or static methods

(private val text: String) : Serializable {
    private var url: String? = null
    private var callback_data: String? = null
    private var switch_inline_query: String? = null
    private var switch_inline_query_current_chat: String? = null
    private var callback_game: String? = null
    private var pay: Boolean? = null

    fun url(url: String): InlineKeyboardButton {
        this.url = url
        return this
    }

    fun callbackData(callbackData: String): InlineKeyboardButton {
        callback_data = callbackData
        return this
    }

    fun switchInlineQuery(switchInlineQuery: String): InlineKeyboardButton {
        switch_inline_query = switchInlineQuery
        return this
    }

    fun switchInlineQueryCurrentChat(switchInlineQueryCurrentChat: String): InlineKeyboardButton {
        switch_inline_query_current_chat = switchInlineQueryCurrentChat
        return this
    }

    fun callbackGame(callbackGame: String): InlineKeyboardButton {
        callback_game = callbackGame
        return this
    }

    fun pay(): InlineKeyboardButton {
        this.pay = true
        return this
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}
