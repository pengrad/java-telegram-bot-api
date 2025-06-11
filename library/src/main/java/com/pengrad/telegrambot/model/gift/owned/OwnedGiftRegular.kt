package com.pengrad.telegrambot.model.gift.owned

import com.pengrad.telegrambot.model.User
import com.pengrad.telegrambot.model.gift.Gift

@Suppress("unused")
class OwnedGiftRegular(
    @get:JvmName("gift")  val gift: Gift,
    @get:JvmName("ownedGiftId") var ownedGiftId: String?,
    @get:JvmName("senderUser") var senderUser: User?,
    @get:JvmName("sendDate") var sendDate: Long,
    @get:JvmName("text") var text: String?,
    @get:JvmName("entities") var entities: Array<Int>?,
    @get:JvmName("isPrivate") var isPrivate: Boolean?,
    @get:JvmName("isSaved") var isSaved: Boolean?,
    @get:JvmName("canBeUpgraded") var canBeUpgraded: Boolean?,
    @get:JvmName("wasRefunded") var wasRefunded: Boolean?,
    @get:JvmName("convertStarCount") var convertStarCount: Int?,
    @get:JvmName("prepaidUpgradeStarCount") var prepaidUpgradeStarCount: Int?
) : OwnedGift(type = "regular")