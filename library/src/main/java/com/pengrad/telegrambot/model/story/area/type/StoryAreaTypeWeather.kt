package com.pengrad.telegrambot.model.story.area.type

@Suppress("unused")
class StoryAreaTypeWeather(
    @get:JvmName("temperature") val temperature: Double,
    @get:JvmName("emoji") val emoji: String,
    @get:JvmName("backgroundColor") val backgroundColor: Int
): StoryAreaType(type = "weather")