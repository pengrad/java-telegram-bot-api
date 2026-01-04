package com.pengrad.telegrambot.model.story.area.type

class StoryAreaTypeUniqueGift(
    @get:JvmName("name") val name: String
) : StoryAreaType(type = "unique_gift") {
    override fun toString(): String {
        return "StoryAreaTypeUniqueGift(name='$name')"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as StoryAreaTypeUniqueGift

        return name == other.name && type == other.type
    }

    override fun hashCode(): Int {
        return name.hashCode()
    }


}