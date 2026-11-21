package com.pengrad.telegrambot.model

import java.io.Serializable

data class AreaPosition(
    @get:JvmName("xPercentage") val xPercentage: Double,
    @get:JvmName("yPercentage") val yPercentage: Double,
    @get:JvmName("widthPercentage") val widthPercentage: Double,
    @get:JvmName("heightPercentage") val heightPercentage: Double,
    @get:JvmName("rotationAngle") val rotationAngle: Double,
    @get:JvmName("cornerRadiusPercentage") val cornerRadiusPercentage: Double
) : Serializable
