package com.pengrad.telegrambot.utility.gson

import com.google.gson.JsonArray
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import com.google.gson.JsonPrimitive
import com.google.gson.JsonSerializationContext
import com.google.gson.JsonSerializer
import com.pengrad.telegrambot.model.richmessages.richtext.*
import java.lang.reflect.Type

object RichTextTypeAdapter : JsonDeserializer<RichText>, JsonSerializer<RichText> {

    private val typeMapping = mapOf(
        RichTextType.BOLD to RichTextBold::class,
        RichTextType.ITALIC to RichTextItalic::class,
        RichTextType.UNDERLINE to RichTextUnderline::class,
        RichTextType.STRIKETHROUGH to RichTextStrikethrough::class,
        RichTextType.SPOILER to RichTextSpoiler::class,
        RichTextType.DATE_TIME to RichTextDateTime::class,
        RichTextType.TEXT_MENTION to RichTextTextMention::class,
        RichTextType.SUBSCRIPT to RichTextSubscript::class,
        RichTextType.SUPERSCRIPT to RichTextSuperscript::class,
        RichTextType.MARKED to RichTextMarked::class,
        RichTextType.CODE to RichTextCode::class,
        RichTextType.CUSTOM_EMOJI to RichTextCustomEmoji::class,
        RichTextType.MATHEMATICAL_EXPRESSION to RichTextMathematicalExpression::class,
        RichTextType.URL to RichTextUrl::class,
        RichTextType.EMAIL_ADDRESS to RichTextEmailAddress::class,
        RichTextType.PHONE_NUMBER to RichTextPhoneNumber::class,
        RichTextType.BANK_CARD_NUMBER to RichTextBankCardNumber::class,
        RichTextType.MENTION to RichTextMention::class,
        RichTextType.HASHTAG to RichTextHashtag::class,
        RichTextType.CASHTAG to RichTextCashtag::class,
        RichTextType.BOT_COMMAND to RichTextBotCommand::class,
        RichTextType.ANCHOR to RichTextAnchor::class,
        RichTextType.ANCHOR_LINK to RichTextAnchorLink::class,
        RichTextType.REFERENCE to RichTextReference::class,
        RichTextType.REFERENCE_LINK to RichTextReferenceLink::class
    )

    @Throws(JsonParseException::class)
    override fun deserialize(element: JsonElement, type: Type, context: JsonDeserializationContext): RichText {
        return when {
            element.isJsonPrimitive -> RichTextPlain(element.asString)
            element.isJsonArray -> {
                val elements = element.asJsonArray
                    .map { context.deserialize<RichText>(it, RichText::class.java) }
                    .toTypedArray()
                RichTextArray(elements)
            }
            element.isJsonObject -> {
                val obj = element.asJsonObject
                val discriminator = obj.getAsJsonPrimitive("type")?.asString ?: RichTextType.UNKNOWN
                typeMapping[discriminator]?.let {
                    context.deserialize(obj, it.java)
                } ?: RichTextUnknown(discriminator)
            }
            else -> RichTextUnknown(RichTextType.UNKNOWN)
        }
    }

    override fun serialize(src: RichText, type: Type, context: JsonSerializationContext): JsonElement {
        return when (src) {
            is RichTextPlain -> JsonPrimitive(src.text)
            is RichTextArray -> JsonArray().apply {
                src.elements.forEach { add(context.serialize(it, RichText::class.java)) }
            }
            else -> context.serialize(src, src.javaClass)
        }
    }
}
