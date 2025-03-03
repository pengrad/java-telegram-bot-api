package com.pengrad.telegrambot.request

import com.pengrad.telegrambot.utility.kotlin.checkDeprecatedConstructorParameters
import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter
import com.pengrad.telegrambot.utility.kotlin.requestParameter

class SendVenue private constructor(
    chatId: Long? = null,
    channelUsername: String? = null,

    latitude: Float,
    longitude: Float,
    title: String,
    address: String
) : KAbstractSendRequest<SendVenue>(
    chatId = chatId,
    channelUsername = channelUsername,
) {

    constructor(
        chatId: Long,
        latitude: Float,
        longitude: Float,
        title: String,
        address: String
    ) : this(
        chatId = chatId,
        channelUsername = null,
        latitude = latitude,
        longitude = longitude,
        title = title,
        address = address
    )

    constructor(
        channelUsername: String,
        latitude: Float,
        longitude: Float,
        title: String,
        address: String
    ) : this(
        chatId = null,
        channelUsername = channelUsername,
        latitude = latitude,
        longitude = longitude,
        title = title,
        address = address
    )

    @Deprecated("Use constructor with chatId or channelUsername instead", ReplaceWith("SendVenue(chatId, latitude, longitude, title, address)"))
    constructor(
        chatId: Any,
        latitude: Float,
        longitude: Float,
        title: String,
        address: String
    ) : this(
        chatId = (chatId as? Number)?.toLong(),
        channelUsername = chatId as? String,
        latitude = latitude,
        longitude = longitude,
        title = title,
        address = address
    ) {
        checkDeprecatedConstructorParameters()
    }

    val latitude: Float by requestParameter(latitude)
    val longitude: Float by requestParameter(longitude)
    val title: String by requestParameter(title)
    val address: String by requestParameter(address)

    var foursquareId: String? by optionalRequestParameter()
    var foursquareType: String? by optionalRequestParameter()

    var googlePlaceId: String? by optionalRequestParameter()
    var googlePlaceType: String? by optionalRequestParameter()

    fun foursquareId(foursquareId: String) = applySelf { this.foursquareId = foursquareId }

    fun foursquareType(foursquareType: String) = applySelf { this.foursquareType = foursquareType }

    fun googlePlaceId(googlePlaceId: String) = applySelf { this.googlePlaceId = googlePlaceId }

    fun googlePlaceType(googlePlaceType: String) = applySelf { this.googlePlaceType = googlePlaceType }

}