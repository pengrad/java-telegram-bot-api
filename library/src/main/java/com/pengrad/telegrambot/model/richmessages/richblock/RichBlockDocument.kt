package com.pengrad.telegrambot.model.richmessages.richblock

import com.pengrad.telegrambot.model.Document

data class RichBlockDocument(
    @get:JvmName("document") val document: Document,
    @get:JvmName("caption") val caption: RichBlockCaption? = null
) : RichBlock {
    override val type: String get() = RichBlockType.DOCUMENT
}
