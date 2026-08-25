package com.pengrad.telegrambot.model.request.richmessages.richblock

import com.pengrad.telegrambot.model.request.InputMedia

class InputRichBlockListItem private constructor(
    @get:JvmName("blocks") val blocks: Array<InputRichBlock>,
    @get:JvmName("hasCheckbox") var hasCheckbox: Boolean?,
    @get:JvmName("isChecked") var isChecked: Boolean?,
    @get:JvmName("value") var value: Int?,
    @get:JvmName("type") var type: String?
) {

    constructor(vararg blocks: InputRichBlock) : this(
        blocks = arrayOf(*blocks),
        hasCheckbox = null,
        isChecked = null,
        value = null,
        type = null
    )

    fun hasCheckbox(hasCheckbox: Boolean) = apply { this.hasCheckbox = hasCheckbox }

    fun isChecked(isChecked: Boolean) = apply { this.isChecked = isChecked }

    fun value(value: Int) = apply { this.value = value }

    fun type(type: String) = apply { this.type = type }

    /**
     * The media carried by the blocks of this item, for requests that have to upload them.
     */
    fun inputMedia(): List<InputMedia<*>> = blocks.flatMap { it.inputMedia() }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as InputRichBlockListItem
        return blocks.contentEquals(other.blocks) &&
                hasCheckbox == other.hasCheckbox &&
                isChecked == other.isChecked &&
                value == other.value &&
                type == other.type
    }

    override fun hashCode(): Int {
        var result = blocks.contentHashCode()
        result = 31 * result + (hasCheckbox?.hashCode() ?: 0)
        result = 31 * result + (isChecked?.hashCode() ?: 0)
        result = 31 * result + (value ?: 0)
        result = 31 * result + (type?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String =
        "InputRichBlockListItem(blocks=${blocks.contentToString()}, hasCheckbox=$hasCheckbox, isChecked=$isChecked, value=$value, type=$type)"
}
