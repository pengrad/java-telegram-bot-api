package com.pengrad.telegrambot.model.request.richmessages.inputrichblock

import com.pengrad.telegrambot.model.request.InputMediaAnimation
import com.pengrad.telegrambot.model.richmessages.richblock.RichBlockCaption
import com.pengrad.telegrambot.model.richmessages.richblock.RichBlockType

data class InputRichBlockAnimation(
    @get:JvmName("animation") val animation: InputMediaAnimation,
    @get:JvmName("caption") val caption: RichBlockCaption? = null
) : InputRichBlock {
    override val type: String get() = RichBlockType.ANIMATION
}
