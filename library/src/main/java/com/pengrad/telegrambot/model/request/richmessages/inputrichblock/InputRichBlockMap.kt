package com.pengrad.telegrambot.model.request.richmessages.inputrichblock

import com.pengrad.telegrambot.model.Location
import com.pengrad.telegrambot.model.richmessages.richblock.RichBlockCaption
import com.pengrad.telegrambot.model.richmessages.richblock.RichBlockType

data class InputRichBlockMap(
    @get:JvmName("location") val location: Location,
    @get:JvmName("zoom") val zoom: Int,
    @get:JvmName("width") val width: Int,
    @get:JvmName("height") val height: Int,
    @get:JvmName("caption") val caption: RichBlockCaption? = null
) : InputRichBlock {
    override val type: String get() = RichBlockType.MAP
}
