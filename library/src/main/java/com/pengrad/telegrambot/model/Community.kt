package com.pengrad.telegrambot.model

data class Community(
    @get:JvmName("id") val id: Long,
    @get:JvmName("name") val name: String,
)
