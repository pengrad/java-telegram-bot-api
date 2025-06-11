package com.pengrad.telegrambot.model.inputstory

@Suppress("unused")
class InputStoryContentVideo private constructor(
    val video: String,
    var duration: Double?,
    var coverFrameTimestamp: Double?,
    var isAnimation: Boolean?
) : InputStoryContent(type = "video") {

    constructor(video: String) : this(
        video = video,
        duration = null,
        coverFrameTimestamp = null,
        isAnimation = null
    )

    fun duration(duration: Double) = apply {
        this.duration = duration
    }

    fun coverFrameTimestamp(coverFrameTimestamp: Double) = apply {
        this.coverFrameTimestamp = coverFrameTimestamp
    }

    fun isAnimation(isAnimation: Boolean) = apply {
        this.isAnimation = isAnimation
    }

}