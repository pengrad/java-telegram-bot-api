package com.pengrad.telegrambot.request.business

import com.pengrad.telegrambot.request.KBaseRequest
import com.pengrad.telegrambot.response.GetBusinessAccountGiftsResponse
import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter
import com.pengrad.telegrambot.utility.kotlin.requestParameter

@Suppress("unused")
class GetBusinessAccountGifts private constructor(
    businessConnectionId: String,
    excludeUnsaved: Boolean?,
    excludeSaved: Boolean?,
    excludeUnlimited: Boolean?,
    excludeLimited: Boolean?,
    excludeLimitedUpgradable: Boolean?,
    excludeLimitedNonUpgradable: Boolean?,
    excludeUnique: Boolean?,
    excludeFromBlockchain: Boolean?,
    sortByPrice: Boolean?,
    offset: String?,
    limit: Int?
): KBaseRequest<GetBusinessAccountGifts, GetBusinessAccountGiftsResponse>(GetBusinessAccountGiftsResponse::class) {

    constructor(businessConnectionId: String) : this(
        businessConnectionId = businessConnectionId,
        excludeUnsaved = null,
        excludeSaved = null,
        excludeUnlimited = null,
        excludeLimited = null,
        excludeLimitedUpgradable = null,
        excludeLimitedNonUpgradable = null,
        excludeUnique = null,
        excludeFromBlockchain = null,
        sortByPrice = null,
        offset = null,
        limit = null,
    )

    val businessConnectionId: String by requestParameter(businessConnectionId, customParameterName = "business_connection_id")

    var excludeUnsaved: Boolean? by optionalRequestParameter(excludeUnsaved, customParameterName = "exclude_unsaved")
    fun excludeUnsaved(excludeUnsaved: Boolean) = applySelf { this.excludeUnsaved = excludeUnsaved }

    var excludeSaved: Boolean? by optionalRequestParameter(excludeSaved, customParameterName = "exclude_saved")
    fun excludeSaved(excludeSaved: Boolean) = applySelf { this.excludeSaved = excludeSaved }

    var excludeUnlimited: Boolean? by optionalRequestParameter(excludeUnlimited, customParameterName = "exclude_unlimited")
    fun excludeUnlimited(excludeUnlimited: Boolean) = applySelf { this.excludeUnlimited = excludeUnlimited }

    @Deprecated("Use excludeLimitedUpgradable and excludeLimitedNonUpgradable instead")
    var excludeLimited: Boolean? by optionalRequestParameter(excludeLimited, customParameterName = "exclude_limited")
    @Deprecated("Use excludeLimitedUpgradable and excludeLimitedNonUpgradable instead")
    fun excludeLimited(excludeLimited: Boolean) = applySelf { this.excludeLimited = excludeLimited }

    var excludeLimitedUpgradable: Boolean? by optionalRequestParameter(excludeLimitedUpgradable, customParameterName = "exclude_limited_upgradable")
    fun excludeLimitedUpgradable(excludeLimitedUpgradable: Boolean) = applySelf { this.excludeLimitedUpgradable = excludeLimitedUpgradable }

    var excludeLimitedNonUpgradable: Boolean? by optionalRequestParameter(excludeLimitedNonUpgradable, customParameterName = "exclude_limited_non_upgradable")
    fun excludeLimitedNonUpgradable(excludeLimitedNonUpgradable: Boolean) = applySelf { this.excludeLimitedNonUpgradable = excludeLimitedNonUpgradable }

    var excludeUnique: Boolean? by optionalRequestParameter(excludeUnique, customParameterName = "exclude_unique")
    fun excludeUnique(excludeUnique: Boolean) = applySelf { this.excludeUnique = excludeUnique }

    var excludeFromBlockchain: Boolean? by optionalRequestParameter(excludeFromBlockchain, customParameterName = "exclude_from_blockchain")
    fun excludeFromBlockchain(excludeFromBlockchain: Boolean) = applySelf { this.excludeFromBlockchain = excludeFromBlockchain }

    var sortByPrice: Boolean? by optionalRequestParameter(sortByPrice, customParameterName = "sort_by_price")
    fun sortByPrice(sortByPrice: Boolean) = applySelf { this.sortByPrice = sortByPrice }

    var offset: String? by optionalRequestParameter(offset, customParameterName = "offset")
    fun offset(offset: String) = applySelf { this.offset = offset }

    var limit: Int? by optionalRequestParameter(limit, customParameterName = "limit")
    fun limit(limit: Int) = applySelf { this.limit = limit }

}