package com.pengrad.telegrambot.model.request.richmessages.richblock

import com.pengrad.telegrambot.model.richmessages.richblock.RichBlockCaption

class InputRichBlockSlideshow private constructor(
    @get:JvmName("blocks") val blocks: Array<InputRichBlock>,
    @get:JvmName("caption") var caption: RichBlockCaption?
) : InputRichBlock {

    constructor(vararg blocks: InputRichBlock) : this(
        blocks = arrayOf(*blocks),
        caption = null
    )

    override val type: String = InputRichBlockType.SLIDESHOW

    fun caption(caption: RichBlockCaption) = apply { this.caption = caption }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as InputRichBlockSlideshow
        return type == other.type &&
                blocks.contentEquals(other.blocks) &&
                caption == other.caption
    }

    override fun hashCode(): Int {
        var result = type.hashCode()
        result = 31 * result + blocks.contentHashCode()
        result = 31 * result + (caption?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String =
        "InputRichBlockSlideshow(type=$type, blocks=${blocks.contentToString()}, caption=$caption)"
}
