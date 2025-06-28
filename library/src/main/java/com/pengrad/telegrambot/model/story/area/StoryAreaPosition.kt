package com.pengrad.telegrambot.model.story.area

data class StoryAreaPosition(
    @get:JvmName("xPercentage") val xPercentage: Double,
    @get:JvmName("yPercentage") val yPercentage: Double,
    @get:JvmName("widthPercentage") val widthPercentage: Double,
    @get:JvmName("heightPercentage") val heightPercentage: Double,
    @get:JvmName("rotationAngle") val rotationAngle: Double,
    @get:JvmName("cornerRadiusPercentage") val cornerRadiusPercentage: Double
)