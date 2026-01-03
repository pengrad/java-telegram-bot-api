package com.pengrad.telegrambot.request

import com.pengrad.telegrambot.response.GetChatGiftsResponse
import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter

class GetChatGifts private constructor(
    chatId: Long? = null,
    channelUsername: String? = null
) : KBaseRequest<GetChatGifts, GetChatGiftsResponse>(GetChatGiftsResponse::class) {

    constructor(chatId: Long) : this(
        chatId = chatId,
        channelUsername = null
    )

    constructor(channelUsername: String) : this(
        chatId = null,
        channelUsername = channelUsername
    )

    val chatId: Long? by optionalRequestParameter(chatId, customParameterName = "chat_id")
    val channelUsername: String? by optionalRequestParameter(channelUsername, customParameterName = "chat_id")

    var excludeUnsaved: Boolean? by optionalRequestParameter()
    var excludeSaved: Boolean? by optionalRequestParameter()
    var excludeUnlimited: Boolean? by optionalRequestParameter()
    var excludeLimitedUpgradable: Boolean? by optionalRequestParameter()
    var excludeLimitedNonUpgradable: Boolean? by optionalRequestParameter()
    var excludeFromBlockchain: Boolean? by optionalRequestParameter()
    var excludeUnique: Boolean? by optionalRequestParameter()
    var sortByPrice: Boolean? by optionalRequestParameter()
    var offset: String? by optionalRequestParameter()
    var limit: Int? by optionalRequestParameter()

    fun excludeUnsaved(excludeUnsaved: Boolean) = applySelf { this.excludeUnsaved = excludeUnsaved }

    fun excludeSaved(excludeSaved: Boolean) = applySelf { this.excludeSaved = excludeSaved }

    fun excludeUnlimited(excludeUnlimited: Boolean) = applySelf { this.excludeUnlimited = excludeUnlimited }

    fun excludeLimitedUpgradable(excludeLimitedUpgradable: Boolean) = applySelf { this.excludeLimitedUpgradable = excludeLimitedUpgradable }

    fun excludeLimitedNonUpgradable(excludeLimitedNonUpgradable: Boolean) = applySelf { this.excludeLimitedNonUpgradable = excludeLimitedNonUpgradable }

    fun excludeFromBlockchain(excludeFromBlockchain: Boolean) = applySelf { this.excludeFromBlockchain = excludeFromBlockchain }

    fun excludeUnique(excludeUnique: Boolean) = applySelf { this.excludeUnique = excludeUnique }

    fun sortByPrice(sortByPrice: Boolean) = applySelf { this.sortByPrice = sortByPrice }

    fun offset(offset: String) = applySelf { this.offset = offset }

    fun limit(limit: Int) = applySelf { this.limit = limit }

}
