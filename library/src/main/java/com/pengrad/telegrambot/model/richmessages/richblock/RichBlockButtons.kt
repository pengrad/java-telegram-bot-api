package com.pengrad.telegrambot.model.richmessages.richblock

import com.pengrad.telegrambot.model.richmessages.RichMessageButton

class RichBlockButtons(
    @get:JvmName("buttons") val buttons: Array<RichMessageButton>,
    @get:JvmName("align") val align: String? = null
) : RichBlock {

    override val type: String get() = RichBlockType.BUTTONS

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as RichBlockButtons
        return buttons.contentEquals(other.buttons) && align == other.align
    }

    override fun hashCode(): Int {
        var result = buttons.contentHashCode()
        result = 31 * result + (align?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String = "RichBlockButtons(buttons=${buttons.contentToString()}, align=$align)"
}
