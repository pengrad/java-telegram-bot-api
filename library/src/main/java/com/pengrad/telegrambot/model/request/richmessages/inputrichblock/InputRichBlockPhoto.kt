package com.pengrad.telegrambot.model.request.richmessages.inputrichblock

import com.pengrad.telegrambot.model.request.InputMediaPhoto
import com.pengrad.telegrambot.model.richmessages.richblock.RichBlockCaption
import com.pengrad.telegrambot.model.richmessages.richblock.RichBlockType

data class InputRichBlockPhoto(
    @get:JvmName("photo") val photo: InputMediaPhoto,
    @get:JvmName("caption") val caption: RichBlockCaption? = null
) : InputRichBlock {
    override val type: String get() = RichBlockType.PHOTO
}
