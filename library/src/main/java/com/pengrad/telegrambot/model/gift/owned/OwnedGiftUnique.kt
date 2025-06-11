package com.pengrad.telegrambot.model.gift.owned

import com.pengrad.telegrambot.model.User
import com.pengrad.telegrambot.model.gift.Gift

@Suppress("unused")
class OwnedGiftUnique(
    @get:JvmName("gift")  val gift: Gift,
    @get:JvmName("ownedGiftId") var ownedGiftId: String?,
    @get:JvmName("senderUser") var senderUser: User?,
    @get:JvmName("sendDate") var sendDate: Long,
    @get:JvmName("isSaved") var isSaved: Boolean?,
    @get:JvmName("canBeTransferred") var canBeTransferred: Boolean?,
    @get:JvmName("transferStarCount") var prepaidUpgradeStarCount: Int?
) : OwnedGift(type = "unique")