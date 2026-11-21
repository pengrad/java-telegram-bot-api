package com.pengrad.telegrambot.model.ton

import com.pengrad.telegrambot.model.gift.unique.UniqueGift
import java.io.Serializable

data class TonNft(
    @get:JvmName("address") val address: String,
    @get:JvmName("collectionAddress") val collectionAddress: String? = null,
    @get:JvmName("index") val index: String,
    @get:JvmName("name") val name: String,
    @get:JvmName("description") val description: String,
    @get:JvmName("attributes") val attributes: Array<TonNftAttribute>? = null,
    @get:JvmName("gift") val gift: UniqueGift? = null,
) : Serializable {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is TonNft) return false
        return address == other.address &&
                collectionAddress == other.collectionAddress &&
                index == other.index &&
                name == other.name &&
                description == other.description &&
                attributes contentEquals other.attributes &&
                gift == other.gift
    }

    override fun hashCode(): Int {
        var result = address.hashCode()
        result = 31 * result + (collectionAddress?.hashCode() ?: 0)
        result = 31 * result + index.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + description.hashCode()
        result = 31 * result + (attributes?.contentHashCode() ?: 0)
        result = 31 * result + (gift?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String =
        "TonNft(address=$address, collectionAddress=$collectionAddress, index=$index, name=$name, " +
                "description=$description, attributes=${attributes?.contentToString()}, gift=$gift)"
}
