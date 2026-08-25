package com.pengrad.telegrambot.model.request.richmessages.richblock

class InputRichBlockAnchor(
    @get:JvmName("name") val name: String
) : InputRichBlock {

    override val type: String = InputRichBlockType.ANCHOR

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as InputRichBlockAnchor
        return type == other.type &&
                name == other.name
    }

    override fun hashCode(): Int {
        var result = type.hashCode()
        result = 31 * result + name.hashCode()
        return result
    }

    override fun toString(): String =
        "InputRichBlockAnchor(type=$type, name=$name)"
}
