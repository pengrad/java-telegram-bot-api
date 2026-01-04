package com.pengrad.telegrambot.model.story.area.type

open class StoryAreaType(
    @get:JvmName("type") val type: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as StoryAreaType

        return type == other.type
    }

    override fun hashCode(): Int {
        return type.hashCode()
    }

    override fun toString(): String {
        return "StoryAreaType(type='$type')"
    }


}