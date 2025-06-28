package com.pengrad.telegrambot.model.gift.owned

data class OwnedGifts(
    @get:JvmName("totalAmount") var totalAmount: Int,
    @get:JvmName("gifts") var gifts: Array<OwnedGift>,
    @get:JvmName("nextOffset") var nextOffset: String?
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is OwnedGifts) return false

        return totalAmount == other.totalAmount &&
                gifts.contentEquals(other.gifts) &&
                nextOffset == other.nextOffset
    }

    override fun hashCode(): Int {
        var result = totalAmount
        result = 31 * result + gifts.contentHashCode()
        result = 31 * result + (nextOffset?.hashCode() ?: 0)
        return result
    }

}