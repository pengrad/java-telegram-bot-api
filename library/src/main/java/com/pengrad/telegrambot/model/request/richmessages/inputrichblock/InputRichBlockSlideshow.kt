package com.pengrad.telegrambot.model.request.richmessages.inputrichblock

import com.pengrad.telegrambot.model.richmessages.richblock.RichBlockCaption
import com.pengrad.telegrambot.model.richmessages.richblock.RichBlockType

class InputRichBlockSlideshow(
    @get:JvmName("blocks") val blocks: Array<InputRichBlock>,
    @get:JvmName("caption") val caption: RichBlockCaption? = null
) : InputRichBlock {

    override val type: String get() = RichBlockType.SLIDESHOW

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as InputRichBlockSlideshow
        return blocks.contentEquals(other.blocks) && caption == other.caption
    }

    override fun hashCode(): Int {
        var result = blocks.contentHashCode()
        result = 31 * result + (caption?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String = "InputRichBlockSlideshow(blocks=${blocks.contentToString()}, caption=$caption)"
}
