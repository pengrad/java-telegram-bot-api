package com.pengrad.telegrambot.model.request.richmessages.richblock

import com.pengrad.telegrambot.model.request.InputMediaVideo
import com.pengrad.telegrambot.model.richmessages.richblock.RichBlockCaption

class InputRichBlockVideo private constructor(
    @get:JvmName("video") val video: InputMediaVideo,
    @get:JvmName("caption") var caption: RichBlockCaption?
) : InputRichBlock {

    constructor(video: InputMediaVideo) : this(
        video = video,
        caption = null
    )

    override val type: String = InputRichBlockType.VIDEO

    fun caption(caption: RichBlockCaption) = apply { this.caption = caption }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as InputRichBlockVideo
        return type == other.type &&
                video == other.video &&
                caption == other.caption
    }

    override fun hashCode(): Int {
        var result = type.hashCode()
        result = 31 * result + video.hashCode()
        result = 31 * result + (caption?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String =
        "InputRichBlockVideo(type=$type, video=$video, caption=$caption)"
}
