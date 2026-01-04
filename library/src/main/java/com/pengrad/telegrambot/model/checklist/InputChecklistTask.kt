package com.pengrad.telegrambot.model.checklist

import com.pengrad.telegrambot.model.MessageEntity

class InputChecklistTask private constructor(
    @get:JvmName("id") val id: Int,
    @get:JvmName("text") val text: String,
    @get:JvmName("parseMode") var parseMode: String?,
    @get:JvmName("textEntities") var textEntities: Array<MessageEntity>?
) {

    constructor(id: Int, text: String) : this(
        id = id,
        text = text,
        parseMode = null,
        textEntities = null
    )

    fun parseMode(parseMode: String) = apply {
        this.parseMode = parseMode
    }

    fun textEntities(textEntities: Array<MessageEntity>) = apply {
        this.textEntities = textEntities
    }



    override fun toString(): String {
        return "InputChecklistTask(id=$id, text='$text', parseMode=$parseMode, textEntities=${textEntities?.contentToString()})"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as InputChecklistTask

        if (id != other.id) return false
        if (text != other.text) return false
        if (parseMode != other.parseMode) return false
        if (textEntities != null) {
            if (other.textEntities == null) return false
            if (!textEntities.contentEquals(other.textEntities)) return false
        } else if (other.textEntities != null) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + text.hashCode()
        result = 31 * result + (parseMode?.hashCode() ?: 0)
        result = 31 * result + (textEntities?.contentHashCode() ?: 0)
        return result
    }


}