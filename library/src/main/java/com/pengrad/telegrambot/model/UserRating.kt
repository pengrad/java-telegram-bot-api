package com.pengrad.telegrambot.model

data class UserRating(
    @get:JvmName("level") val level: Int,
    @get:JvmName("rating") val rating: Int,
    @get:JvmName("currentLevelRating") val currentLevelRating: Int,
    @get:JvmName("nextLevelRating") val nextLevelRating: Int? = null
)
