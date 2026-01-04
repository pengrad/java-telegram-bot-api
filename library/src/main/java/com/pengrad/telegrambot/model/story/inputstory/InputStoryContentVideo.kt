package com.pengrad.telegrambot.model.story.inputstory

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

    override fun toString(): String {
        return "InputStoryContentVideo(video='$video', duration=$duration, coverFrameTimestamp=$coverFrameTimestamp, isAnimation=$isAnimation)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        if (!super.equals(other)) return false

        other as InputStoryContentVideo

        if (video != other.video) return false
        if (duration?.compareTo(other.duration ?: Double.NaN) != 0 && duration != other.duration) return false
        if (coverFrameTimestamp?.compareTo(
                other.coverFrameTimestamp ?: Double.NaN
            ) != 0 && coverFrameTimestamp != other.coverFrameTimestamp
        ) return false
        if (isAnimation != other.isAnimation) return false

        return true
    }

    override fun hashCode(): Int {
        var result = super.hashCode()
        result = 31 * result + video.hashCode()
        result = 31 * result + (duration?.hashCode() ?: 0)
        result = 31 * result + (coverFrameTimestamp?.hashCode() ?: 0)
        result = 31 * result + (isAnimation?.hashCode() ?: 0)
        return result
    }


}