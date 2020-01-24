package com.pengrad.telegrambot.model.request

import java.io.Serializable

/**
 * Stas Parshin
 * 06 May 2016
 */
class InlineQueryResultLocation(id: String, private val latitude: Float, private val longitude: Float, private val title: String) : InlineQueryResult<InlineQueryResultLocation>("location", id), Serializable {

    private var live_period: Int? = null
    private var thumb_url: String? = null
    private var thumb_width: Int? = null
    private var thumb_height: Int? = null

    fun livePeriod(livePeriod: Int?): InlineQueryResultLocation {
        live_period = livePeriod
        return this
    }

    fun thumbUrl(thumbUrl: String): InlineQueryResultLocation {
        this.thumb_url = thumbUrl
        return this
    }

    fun thumbWidth(thumbWidth: Int?): InlineQueryResultLocation {
        this.thumb_width = thumbWidth
        return this
    }

    fun thumbHeight(thumbHeight: Int?): InlineQueryResultLocation {
        this.thumb_height = thumbHeight
        return this
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}
