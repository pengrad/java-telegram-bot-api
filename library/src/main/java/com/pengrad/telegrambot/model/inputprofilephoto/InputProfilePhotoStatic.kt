package com.pengrad.telegrambot.model.inputprofilephoto

@Suppress("unused")
class InputProfilePhotoStatic(
    @get:JvmName("photo") val photo: String
) : InputProfilePhoto(type = "static")