package com.pengrad.telegrambot.model.inputprofilephoto

@Suppress("unused")
class InputProfilePhotoAnimated private constructor(
    @get:JvmName("animation") val animation: String,
    @get:JvmName("mainFrameTimestamp") var mainFrameTimestamp: Double?
) : InputProfilePhoto(type = "animated") {

    constructor(animation: String) : this(
        animation = animation,
        mainFrameTimestamp = null
    )

    fun mainFrameTimestamp(mainFrameTimestamp: Double) = apply {
        this.mainFrameTimestamp = mainFrameTimestamp
    }
}