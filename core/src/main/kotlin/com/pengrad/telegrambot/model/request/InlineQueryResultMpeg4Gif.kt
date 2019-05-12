package com.pengrad.telegrambot.model.request

import java.io.Serializable

/**
 * stas
 * 1/12/16.
 */
class InlineQueryResultMpeg4Gif(id: String, private val mpeg4_url: String, private val thumb_url: String) : InlineQueryResult<InlineQueryResultMpeg4Gif>("mpeg4_gif", id), Serializable {

    private var mpeg4_width: Int? = null
    private var mpeg4_height: Int? = null
    private var mpeg4_duration: Int? = null
    private var title: String? = null
    private var caption: String? = null
    private var parse_mode: String? = null

    fun mpeg4Width(mpeg4Width: Int?): InlineQueryResultMpeg4Gif {
        this.mpeg4_width = mpeg4Width
        return this
    }

    fun mpeg4Height(mpeg4Height: Int?): InlineQueryResultMpeg4Gif {
        this.mpeg4_height = mpeg4Height
        return this
    }

    fun mpeg4Duration(mpeg4Duration: Int?): InlineQueryResultMpeg4Gif {
        this.mpeg4_duration = mpeg4Duration
        return this
    }

    fun title(title: String): InlineQueryResultMpeg4Gif {
        this.title = title
        return this
    }

    fun caption(caption: String): InlineQueryResultMpeg4Gif {
        this.caption = caption
        return this
    }

    fun parseMode(parseMode: ParseMode): InlineQueryResultMpeg4Gif {
        this.parse_mode = parseMode.name
        return this
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}
