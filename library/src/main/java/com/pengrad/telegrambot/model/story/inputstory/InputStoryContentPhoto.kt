package com.pengrad.telegrambot.model.story.inputstory

class InputStoryContentPhoto(
    @get:JvmName("photo") val photo: String
) : InputStoryContent(type = "photo") {
    override fun toString(): String {
        return "InputStoryContentPhoto(photo='$photo')"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        if (!super.equals(other)) return false

        other as InputStoryContentPhoto

        return photo == other.photo
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + photo.hashCode()
        return result
    }


}