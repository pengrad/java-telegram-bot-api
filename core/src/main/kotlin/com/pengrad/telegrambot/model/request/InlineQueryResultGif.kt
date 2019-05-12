package com.pengrad.telegrambot.model.request

import java.io.Serializable

/**
 * stas
 * 1/12/16.
 */
class InlineQueryResultGif(id: String, private val gif_url: String, private val thumb_url: String) : InlineQueryResult<InlineQueryResultGif>("gif", id), Serializable {

    private var gif_width: Int? = null
    private var gif_height: Int? = null
    private var gif_duration: Int? = null
    private var title: String? = null
    private var caption: String? = null
    private var parse_mode: String? = null

    fun gifWidth(gifWidth: Int?): InlineQueryResultGif {
        this.gif_width = gifWidth
        return this
    }

    fun gifHeight(gifHeight: Int?): InlineQueryResultGif {
        this.gif_height = gifHeight
        return this
    }

    fun gifDuration(gifDuration: Int?): InlineQueryResultGif {
        this.gif_duration = gifDuration
        return this
    }

    fun title(title: String): InlineQueryResultGif {
        this.title = title
        return this
    }

    fun caption(caption: String): InlineQueryResultGif {
        this.caption = caption
        return this
    }

    fun parseMode(parseMode: ParseMode): InlineQueryResultGif {
        this.parse_mode = parseMode.name
        return this
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}
