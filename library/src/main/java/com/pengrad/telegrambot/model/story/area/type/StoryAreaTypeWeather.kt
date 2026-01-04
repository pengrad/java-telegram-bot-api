package com.pengrad.telegrambot.model.story.area.type

class StoryAreaTypeWeather(
    @get:JvmName("temperature") val temperature: Double,
    @get:JvmName("emoji") val emoji: String,
    @get:JvmName("backgroundColor") val backgroundColor: Int
) : StoryAreaType(type = "weather") {
    override fun toString(): String {
        return "StoryAreaTypeWeather(temperature=$temperature, emoji='$emoji', backgroundColor=$backgroundColor)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as StoryAreaTypeWeather

        if (temperature.compareTo(other.temperature) != 0) return false
        if (emoji != other.emoji) return false
        if (backgroundColor != other.backgroundColor) return false
        if (type != other.type) return false

        return true
    }

    override fun hashCode(): Int {
        var result = temperature.hashCode()
        result = 31 * result + emoji.hashCode()
        result = 31 * result + backgroundColor
        return result
    }


}