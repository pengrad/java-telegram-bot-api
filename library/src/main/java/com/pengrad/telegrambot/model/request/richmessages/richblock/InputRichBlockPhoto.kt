package com.pengrad.telegrambot.model.request.richmessages.richblock

import com.pengrad.telegrambot.model.request.InputMedia
import com.pengrad.telegrambot.model.request.InputMediaPhoto
import com.pengrad.telegrambot.model.richmessages.richblock.RichBlockCaption

class InputRichBlockPhoto private constructor(
    @get:JvmName("photo") val photo: InputMediaPhoto,
    @get:JvmName("caption") var caption: RichBlockCaption?
) : InputRichBlock {

    constructor(photo: InputMediaPhoto) : this(
        photo = photo,
        caption = null
    )

    override val type: String = InputRichBlockType.PHOTO

    override fun inputMedia(): List<InputMedia<*>> = listOf(photo)

    fun caption(caption: RichBlockCaption) = apply { this.caption = caption }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as InputRichBlockPhoto
        return type == other.type &&
                photo == other.photo &&
                caption == other.caption
    }

    override fun hashCode(): Int {
        var result = type.hashCode()
        result = 31 * result + photo.hashCode()
        result = 31 * result + (caption?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String =
        "InputRichBlockPhoto(type=$type, photo=$photo, caption=$caption)"
}
