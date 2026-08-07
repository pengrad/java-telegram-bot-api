package com.pengrad.telegrambot.utility.gson

import com.google.gson.JsonElement
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import com.pengrad.telegrambot.model.request.richmessages.inputrichblock.InputRichBlock
import java.lang.reflect.Type

/**
 * [InputRichBlock] carries its discriminator in a computed property, which Gson does not
 * serialize, so it is added explicitly here after delegating to the concrete type.
 */
object InputRichBlockSerializer : JsonSerializer<InputRichBlock> {

    override fun serialize(src: InputRichBlock, typeOfSrc: Type, context: JsonSerializationContext): JsonElement =
        context.serialize(src, src.javaClass).asJsonObject.apply {
            addProperty("type", src.type)
        }
}
