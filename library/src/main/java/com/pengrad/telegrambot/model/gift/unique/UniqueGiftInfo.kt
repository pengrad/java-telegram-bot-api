package com.pengrad.telegrambot.model.gift.unique

import com.pengrad.telegrambot.model.MessageEntity

@Suppress("unused")
data class UniqueGiftInfo(
    @get:JvmName("gift")  val gift: UniqueGift,
    @get:JvmName("origin")  val origin: String,
    @get:JvmName("ownedGiftId")  val ownedGiftId: String?,
    @get:JvmName("transferStarCount")  val transferStarCount: Int?,
    @get:JvmName("nextTransferDate") var nextTransferDate: Long?,
    @Deprecated("Use lastResaleCurrency and lastResaleAmount instead")
    @get:JvmName("lastResaleStarCount")  val lastResaleStarCount: Int?,
    @get:JvmName("lastResaleCurrency")  val lastResaleCurrency: String?,
    @get:JvmName("lastResaleAmount")  val lastResaleAmount: Long?,
    @get:JvmName("text") val text: String? = null,
    @get:JvmName("entities") val entities: Array<MessageEntity>? = null,
    @get:JvmName("isPrivate") val isPrivate: Boolean? = null,
) {

    @Suppress("DEPRECATION")
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is UniqueGiftInfo) return false

        return gift == other.gift &&
                origin == other.origin &&
                ownedGiftId == other.ownedGiftId &&
                transferStarCount == other.transferStarCount &&
                nextTransferDate == other.nextTransferDate &&
                lastResaleStarCount == other.lastResaleStarCount &&
                lastResaleCurrency == other.lastResaleCurrency &&
                lastResaleAmount == other.lastResaleAmount &&
                text == other.text &&
                entities contentEquals other.entities &&
                isPrivate == other.isPrivate
    }

    @Suppress("DEPRECATION")
    override fun hashCode(): Int {
        var result = gift.hashCode()
        result = 31 * result + origin.hashCode()
        result = 31 * result + (ownedGiftId?.hashCode() ?: 0)
        result = 31 * result + (transferStarCount ?: 0)
        result = 31 * result + (nextTransferDate?.hashCode() ?: 0)
        result = 31 * result + (lastResaleStarCount ?: 0)
        result = 31 * result + (lastResaleCurrency?.hashCode() ?: 0)
        result = 31 * result + (lastResaleAmount?.hashCode() ?: 0)
        result = 31 * result + (text?.hashCode() ?: 0)
        result = 31 * result + (entities?.contentHashCode() ?: 0)
        result = 31 * result + (isPrivate?.hashCode() ?: 0)
        return result
    }

    @Suppress("DEPRECATION")
    override fun toString(): String {
        return "UniqueGiftInfo(gift=$gift, origin=$origin, ownedGiftId=$ownedGiftId, " +
                "transferStarCount=$transferStarCount, nextTransferDate=$nextTransferDate, " +
                "lastResaleStarCount=$lastResaleStarCount, lastResaleCurrency=$lastResaleCurrency, " +
                "lastResaleAmount=$lastResaleAmount, text=$text, " +
                "entities=${entities?.contentToString()}, isPrivate=$isPrivate)"
    }

}
