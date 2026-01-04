package com.pengrad.telegrambot.model.inputprofilephoto

open class InputProfilePhoto(
    @get:JvmName("type") val type: String
) {
    override fun toString(): String {
        return "InputProfilePhoto(type='$type')"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as InputProfilePhoto

        return type == other.type
    }

    override fun hashCode(): Int {
        return type.hashCode()
    }


}