package com.pengrad.telegrambot.model.request.richmessages.richblock

import com.pengrad.telegrambot.model.richmessages.RichMessageButton

class InputRichBlockButtons private constructor(
    @get:JvmName("buttons") val buttons: Array<RichMessageButton>,
    @get:JvmName("align") var align: String?
) : InputRichBlock {

    constructor(vararg buttons: RichMessageButton) : this(
        buttons = arrayOf(*buttons),
        align = null
    )

    override val type: String = InputRichBlockType.BUTTONS

    fun align(align: String) = apply { this.align = align }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as InputRichBlockButtons
        return type == other.type &&
                buttons.contentEquals(other.buttons) &&
                align == other.align
    }

    override fun hashCode(): Int {
        var result = type.hashCode()
        result = 31 * result + buttons.contentHashCode()
        result = 31 * result + (align?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String =
        "InputRichBlockButtons(type=$type, buttons=${buttons.contentToString()}, align=$align)"
}
