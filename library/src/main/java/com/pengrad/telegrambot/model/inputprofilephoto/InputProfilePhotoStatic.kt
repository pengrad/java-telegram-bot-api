package com.pengrad.telegrambot.model.inputprofilephoto

class InputProfilePhotoStatic(
    @get:JvmName("photo") val photo: String
) : InputProfilePhoto(type = "static") {
    override fun toString(): String {
        return "InputProfilePhotoStatic(photo='$photo')"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as InputProfilePhotoStatic

        return photo == other.photo && type == other.type
    }

    override fun hashCode(): Int {
        return photo.hashCode()
    }


}