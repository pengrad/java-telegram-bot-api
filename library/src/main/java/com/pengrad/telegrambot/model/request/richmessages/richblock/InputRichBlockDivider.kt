package com.pengrad.telegrambot.model.request.richmessages.richblock

class InputRichBlockDivider : InputRichBlock {

    override val type: String = InputRichBlockType.DIVIDER

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as InputRichBlockDivider
        return type == other.type
    }

    override fun hashCode(): Int = type.hashCode()

    override fun toString(): String = "InputRichBlockDivider(type=$type)"
}
