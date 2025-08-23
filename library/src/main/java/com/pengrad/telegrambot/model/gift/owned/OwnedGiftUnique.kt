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
    @get:JvmName("transferStarCount") var prepaidUpgradeStarCount: Int?,
    @get:JvmName("nextTransferDate") var nextTransferDate: Long?
) : OwnedGift(type = TYPE) {

    companion object {
        const val TYPE = "unique"
    }

}