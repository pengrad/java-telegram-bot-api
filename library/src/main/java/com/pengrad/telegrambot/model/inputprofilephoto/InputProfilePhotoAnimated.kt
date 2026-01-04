package com.pengrad.telegrambot.model.inputprofilephoto

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


    override fun toString(): String {
        return "InputProfilePhotoAnimated(animation='$animation', mainFrameTimestamp=$mainFrameTimestamp)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as InputProfilePhotoAnimated

        if (animation != other.animation) return false
        if (mainFrameTimestamp?.compareTo(
                other.mainFrameTimestamp ?: Double.NaN
            ) != 0 && mainFrameTimestamp != other.mainFrameTimestamp
        ) return false
        if (type != other.type) return false;


        return true
    }

    override fun hashCode(): Int {
        var result = animation.hashCode()
        result = 31 * result + (mainFrameTimestamp?.hashCode() ?: 0)
        return result
    }
}