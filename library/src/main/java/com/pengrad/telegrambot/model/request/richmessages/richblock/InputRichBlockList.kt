package com.pengrad.telegrambot.model.request.richmessages.richblock

class InputRichBlockList(vararg items: InputRichBlockListItem) : InputRichBlock {

    @get:JvmName("items") val items: Array<InputRichBlockListItem> = arrayOf(*items)

    override val type: String = InputRichBlockType.LIST

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as InputRichBlockList
        return type == other.type &&
                items.contentEquals(other.items)
    }

    override fun hashCode(): Int {
        var result = type.hashCode()
        result = 31 * result + items.contentHashCode()
        return result
    }

    override fun toString(): String =
        "InputRichBlockList(type=$type, items=${items.contentToString()})"
}
