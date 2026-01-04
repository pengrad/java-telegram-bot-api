package com.pengrad.telegrambot.model.gift.owned

open class OwnedGift(
    @get:JvmName("type") val type: String
) {
    override fun toString(): String {
        return "OwnedGift(type='$type')"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as OwnedGift

        return type == other.type
    }

    override fun hashCode(): Int {
        return type.hashCode()
    }


}