package com.pengrad.telegrambot.model.request

import java.io.Serializable

/**
 * Stas Parshin
 * 06 May 2016
 */
class InlineQueryResultCachedVideo(id: String, private val video_file_id: String, private val title: String) : InlineQueryResult<InlineQueryResultCachedVideo>("video", id), Serializable {

    private var description: String? = null
    private var caption: String? = null
    private var parse_mode: String? = null

    fun description(description: String): InlineQueryResultCachedVideo {
        this.description = description
        return this
    }

    fun caption(caption: String): InlineQueryResultCachedVideo {
        this.caption = caption
        return this
    }

    fun parseMode(parseMode: ParseMode): InlineQueryResultCachedVideo {
        this.parse_mode = parseMode.name
        return this
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}
