package com.pengrad.telegrambot.model.request

import java.io.Serializable

/**
 * Stas Parshin
 * 06 May 2016
 */
class InlineQueryResultVenue(id: String, private val latitude: Float, private val longitude: Float, private val title: String, private val address: String) : InlineQueryResult<InlineQueryResultVenue>("venue", id), Serializable {

    private var foursquare_id: String? = null
    private var foursquare_type: String? = null
    private var thumb_url: String? = null
    private var thumb_width: Int? = null
    private var thumb_height: Int? = null

    fun foursquareId(foursquareId: String): InlineQueryResultVenue {
        this.foursquare_id = foursquareId
        return this
    }

    fun foursquareType(foursquareType: String): InlineQueryResultVenue {
        this.foursquare_type = foursquareType
        return this
    }

    fun thumbUrl(thumbUrl: String): InlineQueryResultVenue {
        this.thumb_url = thumbUrl
        return this
    }

    fun thumbWidth(thumbWidth: Int?): InlineQueryResultVenue {
        this.thumb_width = thumbWidth
        return this
    }

    fun thumbHeight(thumbHeight: Int?): InlineQueryResultVenue {
        this.thumb_height = thumbHeight
        return this
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}
