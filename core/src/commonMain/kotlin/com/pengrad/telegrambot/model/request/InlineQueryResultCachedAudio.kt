package com.pengrad.telegrambot.model.request

import java.io.Serializable

/**
 * Stas Parshin
 * 06 May 2016
 */
class InlineQueryResultCachedAudio(id: String, private val audio_file_id: String) : InlineQueryResult<InlineQueryResultCachedAudio>("audio", id), Serializable {

    private var caption: String? = null
    private var parse_mode: String? = null

    fun caption(caption: String): InlineQueryResultCachedAudio {
        this.caption = caption
        return this
    }

    fun parseMode(parseMode: ParseMode): InlineQueryResultCachedAudio {
        this.parse_mode = parseMode.name
        return this
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}
