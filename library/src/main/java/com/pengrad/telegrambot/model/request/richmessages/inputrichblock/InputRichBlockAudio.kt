package com.pengrad.telegrambot.model.request.richmessages.inputrichblock

import com.pengrad.telegrambot.model.request.InputMediaAudio
import com.pengrad.telegrambot.model.richmessages.richblock.RichBlockCaption
import com.pengrad.telegrambot.model.richmessages.richblock.RichBlockType

data class InputRichBlockAudio(
    @get:JvmName("audio") val audio: InputMediaAudio,
    @get:JvmName("caption") val caption: RichBlockCaption? = null
) : InputRichBlock {
    override val type: String get() = RichBlockType.AUDIO
}
