package com.pengrad.telegrambot.model.request.richmessages.richblock

import com.pengrad.telegrambot.model.Location
import com.pengrad.telegrambot.model.richmessages.richblock.RichBlockCaption

class InputRichBlockMap private constructor(
    @get:JvmName("location") val location: Location,
    @get:JvmName("zoom") var zoom: Int?,
    @get:JvmName("width") var width: Int?,
    @get:JvmName("height") var height: Int?,
    @get:JvmName("caption") var caption: RichBlockCaption?
) : InputRichBlock {

    constructor(location: Location) : this(
        location = location,
        zoom = null,
        width = null,
        height = null,
        caption = null
    )

    override val type: String = InputRichBlockType.MAP

    fun zoom(zoom: Int) = apply { this.zoom = zoom }

    fun width(width: Int) = apply { this.width = width }

    fun height(height: Int) = apply { this.height = height }

    fun caption(caption: RichBlockCaption) = apply { this.caption = caption }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as InputRichBlockMap
        return type == other.type &&
                location == other.location &&
                zoom == other.zoom &&
                width == other.width &&
                height == other.height &&
                caption == other.caption
    }

    override fun hashCode(): Int {
        var result = type.hashCode()
        result = 31 * result + location.hashCode()
        result = 31 * result + (zoom ?: 0)
        result = 31 * result + (width ?: 0)
        result = 31 * result + (height ?: 0)
        result = 31 * result + (caption?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String =
        "InputRichBlockMap(type=$type, location=$location, zoom=$zoom, width=$width, height=$height, caption=$caption)"
}
