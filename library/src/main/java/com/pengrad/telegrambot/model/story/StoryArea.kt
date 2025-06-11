package com.pengrad.telegrambot.model.story

import com.pengrad.telegrambot.model.story.area.StoryAreaPosition
import com.pengrad.telegrambot.model.story.area.type.StoryAreaType

@Suppress("unused")
class StoryArea(
    @get:JvmName("position") val position: StoryAreaPosition,
    @get:JvmName("type") val type: StoryAreaType
)