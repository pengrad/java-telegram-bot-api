package com.pengrad.telegrambot.model.request

import java.io.Serializable

/**
 * Stas Parshin
 * 06 May 2016
 */
class InputVenueMessageContent(private val latitude: Float?, private val longitude: Float?, private val title: String, private val address: String) : InputMessageContent(), Serializable {
    private var foursquare_id: String? = null
    private var foursquare_type: String? = null

    fun foursquareId(foursquareId: String): InputVenueMessageContent {
        this.foursquare_id = foursquareId
        return this
    }

    fun foursquareType(foursquareType: String): InputVenueMessageContent {
        this.foursquare_type = foursquareType
        return this
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}
