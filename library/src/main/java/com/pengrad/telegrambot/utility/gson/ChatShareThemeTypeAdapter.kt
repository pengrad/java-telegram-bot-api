package com.pengrad.telegrambot.utility.gson

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import com.pengrad.telegrambot.model.chatsharetheme.ChatShareTheme
import com.pengrad.telegrambot.model.chatsharetheme.ChatShareThemeEmoji
import com.pengrad.telegrambot.model.chatsharetheme.ChatShareThemeUniqueGift
import com.pengrad.telegrambot.model.chatsharetheme.ChatShareThemeUnknown
import java.lang.reflect.Type

object ChatShareThemeTypeAdapter : JsonDeserializer<ChatShareTheme> {

    @Throws(JsonParseException::class)
    override fun deserialize(element: JsonElement, type: Type, context: JsonDeserializationContext): ChatShareTheme {
        val obj = element.asJsonObject
        return when (obj.getAsJsonPrimitive("type")?.asString) {
            ChatShareTheme.EMOJI -> context.deserialize(obj, ChatShareThemeEmoji::class.java)
            ChatShareTheme.UNIQUE_GIFT -> context.deserialize(obj, ChatShareThemeUniqueGift::class.java)
            else -> ChatShareThemeUnknown()
        }
    }
}
