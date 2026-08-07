package com.pengrad.telegrambot.model.request.richmessages.inputrichblock

import com.pengrad.telegrambot.model.request.InputMediaVoiceNote
import com.pengrad.telegrambot.model.richmessages.richblock.RichBlockCaption
import com.pengrad.telegrambot.model.richmessages.richblock.RichBlockType

data class InputRichBlockVoiceNote(
    @get:JvmName("voiceNote") val voiceNote: InputMediaVoiceNote,
    @get:JvmName("caption") val caption: RichBlockCaption? = null
) : InputRichBlock {
    override val type: String get() = RichBlockType.VOICE_NOTE
}
