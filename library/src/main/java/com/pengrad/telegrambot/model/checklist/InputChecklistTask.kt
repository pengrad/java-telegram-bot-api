package com.pengrad.telegrambot.model.checklist

import com.pengrad.telegrambot.model.MessageEntity

@Suppress("unused")
class InputChecklistTask private constructor (
    @get:JvmName("id") val id: Int,
    @get:JvmName("text") val text: String,
    @get:JvmName("parseMode") var parseMode: String?,
    @get:JvmName("textEntities") var textEntities: Array<MessageEntity>?
){

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

}