package com.pengrad.telegrambot.model.request

import java.io.Serializable

/**
 * Stas Parshin
 * 06 May 2016
 */
class InlineQueryResultCachedPhoto(id: String, private val photo_file_id: String) : InlineQueryResult<InlineQueryResultCachedPhoto>("photo", id), Serializable {

    private var title: String? = null
    private var description: String? = null
    private var caption: String? = null
    private var parse_mode: String? = null

    fun title(title: String): InlineQueryResultCachedPhoto {
        this.title = title
        return this
    }

    fun description(description: String): InlineQueryResultCachedPhoto {
        this.description = description
        return this
    }

    fun caption(caption: String): InlineQueryResultCachedPhoto {
        this.caption = caption
        return this
    }

    fun parseMode(parseMode: ParseMode): InlineQueryResultCachedPhoto {
        this.parse_mode = parseMode.name
        return this
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}
