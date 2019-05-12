package com.pengrad.telegrambot.model.request

import java.io.Serializable

/**
 * Stas Parshin
 * 03 October 2016
 */
class InlineQueryResultGame(id: String, private val game_short_name: String) : InlineQueryResult<InlineQueryResultGame>("game", id), Serializable {
    companion object {
        private const val serialVersionUID = 0L
    }
}
