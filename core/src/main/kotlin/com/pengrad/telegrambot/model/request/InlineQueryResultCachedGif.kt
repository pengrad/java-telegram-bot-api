package com.pengrad.telegrambot.model.request

import java.io.Serializable

/**
 * Stas Parshin
 * 06 May 2016
 */
class InlineQueryResultCachedGif(id: String, private val gif_file_id: String) : InlineQueryResult<InlineQueryResultCachedGif>("gif", id), Serializable {

    private var title: String? = null
    private var caption: String? = null
    private var parse_mode: String? = null

    fun title(title: String): InlineQueryResultCachedGif {
        this.title = title
        return this
    }

    fun caption(caption: String): InlineQueryResultCachedGif {
        this.caption = caption
        return this
    }

    fun parseMode(parseMode: ParseMode): InlineQueryResultCachedGif {
        this.parse_mode = parseMode.name
        return this
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}
