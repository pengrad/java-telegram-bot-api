package com.pengrad.telegrambot.model.request.richmessages.richblock

import com.pengrad.telegrambot.model.request.InputMedia
import com.pengrad.telegrambot.model.request.InputMediaAudio
import com.pengrad.telegrambot.model.richmessages.richblock.RichBlockCaption

class InputRichBlockAudio private constructor(
    @get:JvmName("audio") val audio: InputMediaAudio,
    @get:JvmName("caption") var caption: RichBlockCaption?
) : InputRichBlock {

    constructor(audio: InputMediaAudio) : this(
        audio = audio,
        caption = null
    )

    override val type: String = InputRichBlockType.AUDIO

    override fun inputMedia(): List<InputMedia<*>> = listOf(audio)

    fun caption(caption: RichBlockCaption) = apply { this.caption = caption }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as InputRichBlockAudio
        return type == other.type &&
                audio == other.audio &&
                caption == other.caption
    }

    override fun hashCode(): Int {
        var result = type.hashCode()
        result = 31 * result + audio.hashCode()
        result = 31 * result + (caption?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String =
        "InputRichBlockAudio(type=$type, audio=$audio, caption=$caption)"
}
