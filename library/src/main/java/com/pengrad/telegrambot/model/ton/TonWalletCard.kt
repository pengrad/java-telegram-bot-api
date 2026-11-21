package com.pengrad.telegrambot.model.ton

import java.io.Serializable

data class TonWalletCard(
    @get:JvmName("address") val address: String,
    @get:JvmName("amount") val amount: String,
    @get:JvmName("stickers") val stickers: Array<TonWalletCardSticker>,
    @get:JvmName("backgroundNftAddress") val backgroundNftAddress: String? = null,
) : Serializable {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is TonWalletCard) return false
        return address == other.address &&
                amount == other.amount &&
                stickers contentEquals other.stickers &&
                backgroundNftAddress == other.backgroundNftAddress
    }

    override fun hashCode(): Int {
        var result = address.hashCode()
        result = 31 * result + amount.hashCode()
        result = 31 * result + stickers.contentHashCode()
        result = 31 * result + (backgroundNftAddress?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String =
        "TonWalletCard(address=$address, amount=$amount, stickers=${stickers.contentToString()}, backgroundNftAddress=$backgroundNftAddress)"
}
