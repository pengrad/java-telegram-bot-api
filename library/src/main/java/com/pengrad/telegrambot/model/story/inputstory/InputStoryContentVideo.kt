package com.pengrad.telegrambot.model.story.inputstory

@Suppress("unused")
class InputStoryContentVideo private constructor(
    @get:JvmName("video") val video: String,
    @get:JvmName("duration") var duration: Double?,
    @get:JvmName("coverFrameTimestamp") var coverFrameTimestamp: Double?,
    @get:JvmName("isAnimation") var isAnimation: Boolean?
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