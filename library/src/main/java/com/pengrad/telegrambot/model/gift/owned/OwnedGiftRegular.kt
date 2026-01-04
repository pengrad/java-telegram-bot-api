package com.pengrad.telegrambot.model.gift.owned

import com.pengrad.telegrambot.model.MessageEntity
import com.pengrad.telegrambot.model.User
import com.pengrad.telegrambot.model.gift.Gift

class OwnedGiftRegular private constructor(
    @get:JvmName("gift")  val gift: Gift,
    @get:JvmName("ownedGiftId") var ownedGiftId: String?,
    @get:JvmName("senderUser") var senderUser: User?,
    @get:JvmName("sendDate") val sendDate: Long,
    @get:JvmName("text") var text: String?,
    @get:JvmName("entities") var entities: Array<MessageEntity>?,
    @get:JvmName("isPrivate") var isPrivate: Boolean?,
    @get:JvmName("isSaved") var isSaved: Boolean?,
    @get:JvmName("canBeUpgraded") var canBeUpgraded: Boolean?,
    @get:JvmName("wasRefunded") var wasRefunded: Boolean?,
    @get:JvmName("convertStarCount") var convertStarCount: Int?,
    @get:JvmName("prepaidUpgradeStarCount") var prepaidUpgradeStarCount: Int?,
    @get:JvmName("isUpgradeSeparate") var isUpgradeSeparate: Boolean?,
    @get:JvmName("uniqueGiftNumber") var uniqueGiftNumber: Int?
) : OwnedGift(type = TYPE) {

    companion object {
        const val TYPE = "regular"
    }

    constructor(gift: Gift, sendDate: Long) : this(
        gift = gift,
        ownedGiftId = null,
        senderUser = null,
        sendDate = sendDate,
        text = null,
        entities = null,
        isPrivate = null,
        isSaved = null,
        canBeUpgraded = null,
        wasRefunded = null,
        convertStarCount = null,
        prepaidUpgradeStarCount = null,
        isUpgradeSeparate = null,
        uniqueGiftNumber = null,
    )

    fun ownedGiftId(ownedGiftId: String) = apply {
        this.ownedGiftId = ownedGiftId
    }

    fun senderUser(senderUser: User) = apply {
        this.senderUser = senderUser
    }

    fun text(text: String) = apply {
        this.text = text
    }

    fun entities(entities: Array<MessageEntity>) = apply {
        this.entities = entities
    }

    fun isPrivate(isPrivate: Boolean) = apply {
        this.isPrivate = isPrivate
    }

    fun isSaved(isSaved: Boolean) = apply {
        this.isSaved = isSaved
    }

    fun canBeUpgraded(canBeUpgraded: Boolean) = apply {
        this.canBeUpgraded = canBeUpgraded
    }

    fun wasRefunded(wasRefunded: Boolean) = apply {
        this.wasRefunded = wasRefunded
    }

    fun convertStarCount(convertStarCount: Int) = apply {
        this.convertStarCount = convertStarCount
    }

    fun prepaidUpgradeStarCount(prepaidUpgradeStarCount: Int) = apply {
        this.prepaidUpgradeStarCount = prepaidUpgradeStarCount
    }

    fun isUpgradeSeparate(isUpgradeSeparate: Boolean) = apply {
        this.isUpgradeSeparate = isUpgradeSeparate
    }

    fun uniqueGiftNumber(uniqueGiftNumber: Int) = apply {
        this.uniqueGiftNumber = uniqueGiftNumber
    }

    override fun toString(): String {
        return "OwnedGiftRegular(gift=$gift, ownedGiftId=$ownedGiftId, senderUser=$senderUser, sendDate=$sendDate, text=$text, entities=${entities?.contentToString()}, isPrivate=$isPrivate, isSaved=$isSaved, canBeUpgraded=$canBeUpgraded, wasRefunded=$wasRefunded, convertStarCount=$convertStarCount, prepaidUpgradeStarCount=$prepaidUpgradeStarCount, isUpgradeSeparate=$isUpgradeSeparate, uniqueGiftNumber=$uniqueGiftNumber)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        if (!super.equals(other)) return false

        other as OwnedGiftRegular

        if (gift != other.gift) return false
        if (ownedGiftId != other.ownedGiftId) return false
        if (senderUser != other.senderUser) return false
        if (sendDate != other.sendDate) return false
        if (text != other.text) return false
        if (entities != null) {
            if (other.entities == null) return false
            if (!entities.contentEquals(other.entities)) return false
        } else if (other.entities != null) return false
        if (isPrivate != other.isPrivate) return false
        if (isSaved != other.isSaved) return false
        if (canBeUpgraded != other.canBeUpgraded) return false
        if (wasRefunded != other.wasRefunded) return false
        if (convertStarCount != other.convertStarCount) return false
        if (prepaidUpgradeStarCount != other.prepaidUpgradeStarCount) return false
        if (isUpgradeSeparate != other.isUpgradeSeparate) return false
        if (uniqueGiftNumber != other.uniqueGiftNumber) return false

        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + gift.hashCode()
        result = 31 * result + (ownedGiftId?.hashCode() ?: 0)
        result = 31 * result + (senderUser?.hashCode() ?: 0)
        result = 31 * result + sendDate.hashCode()
        result = 31 * result + (text?.hashCode() ?: 0)
        result = 31 * result + (entities?.contentHashCode() ?: 0)
        result = 31 * result + (isPrivate?.hashCode() ?: 0)
        result = 31 * result + (isSaved?.hashCode() ?: 0)
        result = 31 * result + (canBeUpgraded?.hashCode() ?: 0)
        result = 31 * result + (wasRefunded?.hashCode() ?: 0)
        result = 31 * result + (convertStarCount ?: 0)
        result = 31 * result + (prepaidUpgradeStarCount ?: 0)
        result = 31 * result + (isUpgradeSeparate?.hashCode() ?: 0)
        result = 31 * result + (uniqueGiftNumber ?: 0)
        return result
    }


}