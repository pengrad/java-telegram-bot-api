package com.pengrad.telegrambot.model.story

import com.pengrad.telegrambot.model.story.area.StoryAreaPosition
import com.pengrad.telegrambot.model.story.area.type.StoryAreaType

class StoryArea(
    @get:JvmName("position") val position: StoryAreaPosition,
    @get:JvmName("type") val type: StoryAreaType
) {
    override fun toString(): String {
        return "StoryArea(position=$position, type=$type)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as StoryArea

        if (position != other.position) return false
        if (type != other.type) return false

        return true
    }

    override fun hashCode(): Int {
        var result = position.hashCode()
        result = 31 * result + type.hashCode()
        return result
    }


}