package com.pengrad.telegrambot.model.story.area.type

class StoryAreaTypeLink(
    @get:JvmName("url") val url: String
): StoryAreaType(type = "link") {
    override fun toString(): String {
        return "StoryAreaTypeLink(url='$url')"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        if (!super.equals(other)) return false

        other as StoryAreaTypeLink

        return url == other.url
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + url.hashCode()
        return result
    }


}