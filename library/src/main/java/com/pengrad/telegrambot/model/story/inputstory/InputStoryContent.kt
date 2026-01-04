package com.pengrad.telegrambot.model.story.inputstory

open class InputStoryContent(
    @get:JvmName("type") val type: String
) {
    override fun toString(): String {
        return "InputStoryContent(type='$type')"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as InputStoryContent

        return type == other.type
    }

    override fun hashCode(): Int {
        return type.hashCode()
    }


}