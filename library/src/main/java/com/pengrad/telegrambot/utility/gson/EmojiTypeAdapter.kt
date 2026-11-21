package com.pengrad.telegrambot.utility.gson

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import com.pengrad.telegrambot.model.chatsharetheme.EmojiType
import com.pengrad.telegrambot.model.chatsharetheme.EmojiTypeCustomEmoji
import com.pengrad.telegrambot.model.chatsharetheme.EmojiTypeEmoji
import com.pengrad.telegrambot.model.chatsharetheme.EmojiTypeUnknown
import java.lang.reflect.Type

object EmojiTypeAdapter : JsonDeserializer<EmojiType> {

    @Throws(JsonParseException::class)
    override fun deserialize(element: JsonElement, type: Type, context: JsonDeserializationContext): EmojiType {
        val obj = element.asJsonObject
        return when (obj.getAsJsonPrimitive("type")?.asString) {
            EmojiType.EMOJI -> context.deserialize(obj, EmojiTypeEmoji::class.java)
            EmojiType.CUSTOM_EMOJI -> context.deserialize(obj, EmojiTypeCustomEmoji::class.java)
            else -> EmojiTypeUnknown()
        }
    }
}
