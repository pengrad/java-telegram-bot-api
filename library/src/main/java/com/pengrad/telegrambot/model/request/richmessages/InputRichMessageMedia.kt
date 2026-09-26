package com.pengrad.telegrambot.model.request.richmessages

import com.pengrad.telegrambot.model.request.InputMedia

class InputRichMessageMedia(
    @get:JvmName("id") val id: String,
    @get:JvmName("media") val media: InputMedia<*>
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as InputRichMessageMedia
        return id == other.id &&
                media == other.media
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + media.hashCode()
        return result
    }

    override fun toString(): String = "InputRichMessageMedia(id=$id, media=$media)"
}
