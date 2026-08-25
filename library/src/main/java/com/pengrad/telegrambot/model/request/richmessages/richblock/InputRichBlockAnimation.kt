package com.pengrad.telegrambot.model.request.richmessages.richblock

import com.pengrad.telegrambot.model.request.InputMedia
import com.pengrad.telegrambot.model.request.InputMediaAnimation
import com.pengrad.telegrambot.model.richmessages.richblock.RichBlockCaption

class InputRichBlockAnimation private constructor(
    @get:JvmName("animation") val animation: InputMediaAnimation,
    @get:JvmName("caption") var caption: RichBlockCaption?
) : InputRichBlock {

    constructor(animation: InputMediaAnimation) : this(
        animation = animation,
        caption = null
    )

    override val type: String = InputRichBlockType.ANIMATION

    override fun inputMedia(): List<InputMedia<*>> = listOf(animation)

    fun caption(caption: RichBlockCaption) = apply { this.caption = caption }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as InputRichBlockAnimation
        return type == other.type &&
                animation == other.animation &&
                caption == other.caption
    }

    override fun hashCode(): Int {
        var result = type.hashCode()
        result = 31 * result + animation.hashCode()
        result = 31 * result + (caption?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String =
        "InputRichBlockAnimation(type=$type, animation=$animation, caption=$caption)"
}
