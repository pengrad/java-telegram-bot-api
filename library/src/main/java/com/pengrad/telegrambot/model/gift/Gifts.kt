package com.pengrad.telegrambot.model.gift

data class Gifts(
    @get:JvmName("gifts") val gifts: Array<Gift>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Gifts) return false

        if (!gifts.contentEquals(other.gifts)) return false

        return true
    }

    override fun hashCode(): Int {
        return gifts.contentHashCode()
    }
}
