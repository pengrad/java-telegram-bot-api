package com.pengrad.telegrambot.model.request

import java.io.Serializable

/**
 * Stas Parshin
 * 06 May 2016
 */
class InlineQueryResultCachedDocument(id: String, private val document_file_id: String, private val title: String) : InlineQueryResult<InlineQueryResultCachedDocument>("document", id), Serializable {

    private var description: String? = null
    private var caption: String? = null
    private var parse_mode: String? = null

    fun description(description: String): InlineQueryResultCachedDocument {
        this.description = description
        return this
    }

    fun caption(caption: String): InlineQueryResultCachedDocument {
        this.caption = caption
        return this
    }

    fun parseMode(parseMode: ParseMode): InlineQueryResultCachedDocument {
        this.parse_mode = parseMode.name
        return this
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}
