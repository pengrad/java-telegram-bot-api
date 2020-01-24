package com.pengrad.telegrambot.model.request

import java.io.Serializable

/**
 * Stas Parshin
 * 06 May 2016
 */
class InlineQueryResultDocument(id: String, private val document_url: String, private val title: String, private val mime_type: String) : InlineQueryResult<InlineQueryResultDocument>("document", id), Serializable {

    private var caption: String? = null
    private var parse_mode: String? = null
    private var description: String? = null
    private var thumb_url: String? = null
    private var thumb_width: Int? = null
    private var thumb_height: Int? = null

    fun caption(caption: String): InlineQueryResultDocument {
        this.caption = caption
        return this
    }

    fun parseMode(parseMode: ParseMode): InlineQueryResultDocument {
        this.parse_mode = parseMode.name
        return this
    }

    fun description(description: String): InlineQueryResultDocument {
        this.description = description
        return this
    }

    fun thumbUrl(thumbUrl: String): InlineQueryResultDocument {
        this.thumb_url = thumbUrl
        return this
    }

    fun thumbWidth(thumbWidth: Int?): InlineQueryResultDocument {
        this.thumb_width = thumbWidth
        return this
    }

    fun thumbHeight(thumbHeight: Int?): InlineQueryResultDocument {
        this.thumb_height = thumbHeight
        return this
    }

    companion object {
        private const val serialVersionUID = 0L

        val MIME_APP_PDFL = "application/pdf"
        val MIME_APP_ZIP = "application/zip"
    }
}
