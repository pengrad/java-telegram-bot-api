package com.pengrad.telegrambot.utility.gson

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import com.pengrad.telegrambot.model.widget.WidgetQueryType
import com.pengrad.telegrambot.model.widget.WidgetQueryTypeData
import com.pengrad.telegrambot.model.widget.WidgetQueryTypeSentTransaction
import com.pengrad.telegrambot.model.widget.WidgetQueryTypeSignData
import com.pengrad.telegrambot.model.widget.WidgetQueryTypeUnknown
import java.lang.reflect.Type

object WidgetQueryTypeAdapter : JsonDeserializer<WidgetQueryType> {

    @Throws(JsonParseException::class)
    override fun deserialize(element: JsonElement, type: Type, context: JsonDeserializationContext): WidgetQueryType {
        val obj = element.asJsonObject
        return when (obj.getAsJsonPrimitive("type")?.asString) {
            WidgetQueryType.DATA -> context.deserialize(obj, WidgetQueryTypeData::class.java)
            WidgetQueryType.SIGN_DATA -> context.deserialize(obj, WidgetQueryTypeSignData::class.java)
            WidgetQueryType.SENT_TRANSACTION -> context.deserialize(obj, WidgetQueryTypeSentTransaction::class.java)
            else -> WidgetQueryTypeUnknown()
        }
    }
}
