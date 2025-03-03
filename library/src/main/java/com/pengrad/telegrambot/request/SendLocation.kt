package com.pengrad.telegrambot.request

import com.pengrad.telegrambot.utility.kotlin.checkDeprecatedConstructorParameters
import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter
import com.pengrad.telegrambot.utility.kotlin.requestParameter

class SendLocation private constructor(
    chatId: Long? = null,
    channelUsername: String? = null,

    latitude: Float,
    longitude: Float
) : KAbstractSendRequest<SendLocation>(
    chatId = chatId,
    channelUsername = channelUsername,
) {

    constructor(chatId: Long, latitude: Float, longitude: Float) : this(
        chatId = chatId,
        channelUsername = null,
        latitude = latitude,
        longitude = longitude
    )

    constructor(channelUsername: String, latitude: Float, longitude: Float) : this(
        chatId = null,
        channelUsername = channelUsername,
        latitude = latitude,
        longitude = longitude
    )

    @Deprecated("Use constructor with chatId or channelUsername instead", ReplaceWith("SendLocation(chatId, latitude, longitude)"))
    constructor(chatId: Any, latitude: Float, longitude: Float) : this(
        chatId = (chatId as? Number)?.toLong(),
        channelUsername = chatId as? String,
        latitude = latitude,
        longitude = longitude
    ) {
        checkDeprecatedConstructorParameters()
    }

    val latitude: Float by requestParameter(latitude)
    val longitude: Float by requestParameter(longitude)

    var horizontalAccuracy:  Float? by optionalRequestParameter()
    var livePeriod: Int? by optionalRequestParameter()
    var heading: Int? by optionalRequestParameter()
    var proximityAlertRadius: Int? by optionalRequestParameter()

    fun horizontalAccuracy(horizontalAccuracy: Float) = applySelf { this.horizontalAccuracy = horizontalAccuracy }

    fun livePeriod(livePeriod: Int) = applySelf { this.livePeriod = livePeriod }

    fun heading(heading: Int) = applySelf { this.heading = heading }

    fun proximityAlertRadius(proximityAlertRadius: Int) =  applySelf { this.proximityAlertRadius = proximityAlertRadius }

}