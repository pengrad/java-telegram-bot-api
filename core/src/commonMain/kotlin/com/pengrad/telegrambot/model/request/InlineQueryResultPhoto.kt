package com.pengrad.telegrambot.model.request

import java.io.Serializable

/**
 * stas
 * 1/12/16.
 */
class InlineQueryResultPhoto(id: String, private val photo_url: String, private val thumb_url: String) : InlineQueryResult<InlineQueryResultPhoto>("photo", id), Serializable {

    private var photo_width: Int? = null
    private var photo_height: Int? = null
    private var title: String? = null
    private var description: String? = null
    private var caption: String? = null
    private var parse_mode: String? = null

    fun photoWidth(photoWidth: Int?): InlineQueryResultPhoto {
        this.photo_width = photoWidth
        return this
    }

    fun photoHeight(photoHeight: Int?): InlineQueryResultPhoto {
        this.photo_height = photoHeight
        return this
    }

    fun title(title: String): InlineQueryResultPhoto {
        this.title = title
        return this
    }

    fun description(description: String): InlineQueryResultPhoto {
        this.description = description
        return this
    }

    fun caption(caption: String): InlineQueryResultPhoto {
        this.caption = caption
        return this
    }

    fun parseMode(parseMode: ParseMode): InlineQueryResultPhoto {
        this.parse_mode = parseMode.name
        return this
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}
