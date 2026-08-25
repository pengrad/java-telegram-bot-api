package com.pengrad.telegrambot.model.request.richmessages.richblock

import com.pengrad.telegrambot.model.request.InputMedia
import com.pengrad.telegrambot.model.request.InputMediaVoiceNote
import com.pengrad.telegrambot.model.richmessages.richblock.RichBlockCaption

class InputRichBlockVoiceNote private constructor(
    @get:JvmName("voiceNote") val voiceNote: InputMediaVoiceNote,
    @get:JvmName("caption") var caption: RichBlockCaption?
) : InputRichBlock {

    constructor(voiceNote: InputMediaVoiceNote) : this(
        voiceNote = voiceNote,
        caption = null
    )

    override val type: String = InputRichBlockType.VOICE_NOTE

    override fun inputMedia(): List<InputMedia<*>> = listOf(voiceNote)

    fun caption(caption: RichBlockCaption) = apply { this.caption = caption }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as InputRichBlockVoiceNote
        return type == other.type &&
                voiceNote == other.voiceNote &&
                caption == other.caption
    }

    override fun hashCode(): Int {
        var result = type.hashCode()
        result = 31 * result + voiceNote.hashCode()
        result = 31 * result + (caption?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String =
        "InputRichBlockVoiceNote(type=$type, voiceNote=$voiceNote, caption=$caption)"
}
