package com.pengrad.telegrambot.request

import com.pengrad.telegrambot.response.GetUserGiftsResponse
import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter
import com.pengrad.telegrambot.utility.kotlin.requestParameter

class GetUserGifts(
    userId: Long
) : KBaseRequest<GetUserGifts, GetUserGiftsResponse>(GetUserGiftsResponse::class) {

    val userId: Long by requestParameter(userId)

    var excludeUnlimited: Boolean? by optionalRequestParameter()
    var excludeLimitedUpgradable: Boolean? by optionalRequestParameter()
    var excludeLimitedNonUpgradable: Boolean? by optionalRequestParameter()
    var excludeFromBlockchain: Boolean? by optionalRequestParameter()
    var excludeUnique: Boolean? by optionalRequestParameter()
    var sortByPrice: Boolean? by optionalRequestParameter()
    var offset: String? by optionalRequestParameter()
    var limit: Int? by optionalRequestParameter()

    fun excludeUnlimited(excludeUnlimited: Boolean) = applySelf { this.excludeUnlimited = excludeUnlimited }

    fun excludeLimitedUpgradable(excludeLimitedUpgradable: Boolean) = applySelf { this.excludeLimitedUpgradable = excludeLimitedUpgradable }

    fun excludeLimitedNonUpgradable(excludeLimitedNonUpgradable: Boolean) = applySelf { this.excludeLimitedNonUpgradable = excludeLimitedNonUpgradable }

    fun excludeFromBlockchain(excludeFromBlockchain: Boolean) = applySelf { this.excludeFromBlockchain = excludeFromBlockchain }

    fun excludeUnique(excludeUnique: Boolean) = applySelf { this.excludeUnique = excludeUnique }

    fun sortByPrice(sortByPrice: Boolean) = applySelf { this.sortByPrice = sortByPrice }

    fun offset(offset: String) = applySelf { this.offset = offset }

    fun limit(limit: Int) = applySelf { this.limit = limit }

}
