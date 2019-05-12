package com.pengrad.telegrambot.model.request

import java.io.Serializable

/**
 * Stas Parshin
 * 06 May 2016
 */
class InlineQueryResultCachedVoice(id: String, private val voice_file_id: String, private val title: String) : InlineQueryResult<InlineQueryResultCachedVoice>("voice", id), Serializable {

    private var caption: String? = null
    private var parse_mode: String? = null

    fun caption(caption: String): InlineQueryResultCachedVoice {
        this.caption = caption
        return this
    }

    fun parseMode(parseMode: ParseMode): InlineQueryResultCachedVoice {
        this.parse_mode = parseMode.name
        return this
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}
