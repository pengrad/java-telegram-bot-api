package com.pengrad.telegrambot.model.gift.owned

import com.pengrad.telegrambot.model.User
import com.pengrad.telegrambot.model.gift.Gift

class OwnedGiftUnique(
    @get:JvmName("gift") val gift: Gift,
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

    override fun toString(): String {
        return "OwnedGiftUnique(gift=$gift, ownedGiftId=$ownedGiftId, senderUser=$senderUser, sendDate=$sendDate, isSaved=$isSaved, canBeTransferred=$canBeTransferred, prepaidUpgradeStarCount=$prepaidUpgradeStarCount, nextTransferDate=$nextTransferDate)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        if (!super.equals(other)) return false

        other as OwnedGiftUnique

        if (gift != other.gift) return false
        if (ownedGiftId != other.ownedGiftId) return false
        if (senderUser != other.senderUser) return false
        if (sendDate != other.sendDate) return false
        if (isSaved != other.isSaved) return false
        if (canBeTransferred != other.canBeTransferred) return false
        if (prepaidUpgradeStarCount != other.prepaidUpgradeStarCount) return false
        if (nextTransferDate != other.nextTransferDate) return false

        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + gift.hashCode()
        result = 31 * result + (ownedGiftId?.hashCode() ?: 0)
        result = 31 * result + (senderUser?.hashCode() ?: 0)
        result = 31 * result + sendDate.hashCode()
        result = 31 * result + (isSaved?.hashCode() ?: 0)
        result = 31 * result + (canBeTransferred?.hashCode() ?: 0)
        result = 31 * result + (prepaidUpgradeStarCount ?: 0)
        result = 31 * result + (nextTransferDate?.hashCode() ?: 0)
        return result
    }


}