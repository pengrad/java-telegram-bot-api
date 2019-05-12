package com.pengrad.telegrambot.model.request

import java.io.Serializable

/**
 * stas
 * 1/12/16.
 */
class InlineQueryResultArticle(id: String, private val title: String, inputMessageContent: InputMessageContent) : InlineQueryResult<InlineQueryResultArticle>("article", id), Serializable {

    private var url: String? = null
    private var hide_url: Boolean? = null
    private var description: String? = null
    private var thumb_url: String? = null
    private var thumb_width: Int? = null
    private var thumb_height: Int? = null

    constructor(id: String, title: String, messageText: String) : this(id, title, InputTextMessageContent(messageText)) {}

    init {
        inputMessageContent(inputMessageContent)
    }

    fun url(url: String): InlineQueryResultArticle {
        this.url = url
        return this
    }

    fun hideUrl(hideUrl: Boolean?): InlineQueryResultArticle {
        this.hide_url = hideUrl
        return this
    }

    fun description(description: String): InlineQueryResultArticle {
        this.description = description
        return this
    }

    fun thumbUrl(thumbUrl: String): InlineQueryResultArticle {
        this.thumb_url = thumbUrl
        return this
    }

    fun thumbWidth(thumbWidth: Int?): InlineQueryResultArticle {
        this.thumb_width = thumbWidth
        return this
    }

    fun thumbHeight(thumbHeight: Int?): InlineQueryResultArticle {
        this.thumb_height = thumbHeight
        return this
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}
