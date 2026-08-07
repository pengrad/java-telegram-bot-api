package com.pengrad.telegrambot.utility.gson

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import com.pengrad.telegrambot.model.richmessages.richblock.*
import java.lang.reflect.Type

object RichBlockTypeAdapter : JsonDeserializer<RichBlock>, JsonSerializer<RichBlock> {

    private val typeMapping = mapOf(
        RichBlockType.PARAGRAPH to RichBlockParagraph::class,
        RichBlockType.HEADING to RichBlockSectionHeading::class,
        RichBlockType.PRE to RichBlockPreformatted::class,
        RichBlockType.FOOTER to RichBlockFooter::class,
        RichBlockType.DIVIDER to RichBlockDivider::class,
        RichBlockType.MATHEMATICAL_EXPRESSION to RichBlockMathematicalExpression::class,
        RichBlockType.ANCHOR to RichBlockAnchor::class,
        RichBlockType.LIST to RichBlockList::class,
        RichBlockType.BLOCKQUOTE to RichBlockBlockQuotation::class,
        RichBlockType.PULLQUOTE to RichBlockPullQuotation::class,
        RichBlockType.COLLAGE to RichBlockCollage::class,
        RichBlockType.SLIDESHOW to RichBlockSlideshow::class,
        RichBlockType.TABLE to RichBlockTable::class,
        RichBlockType.DETAILS to RichBlockDetails::class,
        RichBlockType.MAP to RichBlockMap::class,
        RichBlockType.ANIMATION to RichBlockAnimation::class,
        RichBlockType.AUDIO to RichBlockAudio::class,
        RichBlockType.PHOTO to RichBlockPhoto::class,
        RichBlockType.VIDEO to RichBlockVideo::class,
        RichBlockType.VOICE_NOTE to RichBlockVoiceNote::class,
        RichBlockType.THINKING to RichBlockThinking::class
    )

    @Throws(JsonParseException::class)
    override fun deserialize(element: JsonElement, type: Type, context: JsonDeserializationContext): RichBlock {
        val obj = element.asJsonObject
        val discriminator = obj.getAsJsonPrimitive("type")?.asString ?: RichBlockType.UNKNOWN
        return typeMapping[discriminator]?.let {
            context.deserialize(obj, it.java)
        } ?: RichBlockUnknown(discriminator)
    }

    /**
     * The discriminator is a computed property, so Gson leaves it out of the reflective
     * output and it has to be added back explicitly.
     */
    override fun serialize(src: RichBlock, typeOfSrc: Type, context: JsonSerializationContext): JsonElement =
        context.serialize(src, src.javaClass).asJsonObject.apply {
            addProperty("type", src.type)
        }
}
