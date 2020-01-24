package com.pengrad.telegrambot.model.request

import java.io.Serializable

/**
 * Stas Parshin
 * 06 May 2016
 */
class InlineQueryResultCachedMpeg4Gif(id: String, private val mpeg4_file_id: String) : InlineQueryResult<InlineQueryResultCachedMpeg4Gif>("mpeg4_gif", id), Serializable {

    private var title: String? = null
    private var caption: String? = null
    private var parse_mode: String? = null

    fun title(title: String): InlineQueryResultCachedMpeg4Gif {
        this.title = title
        return this
    }

    fun caption(caption: String): InlineQueryResultCachedMpeg4Gif {
        this.caption = caption
        return this
    }

    fun parseMode(parseMode: ParseMode): InlineQueryResultCachedMpeg4Gif {
        this.parse_mode = parseMode.name
        return this
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}
