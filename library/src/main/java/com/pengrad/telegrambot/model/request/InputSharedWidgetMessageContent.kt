package com.pengrad.telegrambot.model.request

import com.pengrad.telegrambot.model.MessageEntity

class InputSharedWidgetMessageContent private constructor(
    @get:JvmName("widgetId") val widgetId: String,
    @get:JvmName("chatData") var chatData: String?,
    @get:JvmName("caption") var caption: String?,
    @get:JvmName("parseMode") var parseMode: ParseMode?,
    @get:JvmName("captionEntities") var captionEntities: Array<MessageEntity>?,
    @get:JvmName("showCaptionAboveMedia") var showCaptionAboveMedia: Boolean?,
) : InputMessageContent() {

    constructor(widgetId: String) : this(
        widgetId = widgetId,
        chatData = null,
        caption = null,
        parseMode = null,
        captionEntities = null,
        showCaptionAboveMedia = null,
    )

    fun chatData(chatData: String) = apply { this.chatData = chatData }

    fun caption(caption: String) = apply { this.caption = caption }

    fun parseMode(parseMode: ParseMode) = apply { this.parseMode = parseMode }

    fun captionEntities(vararg captionEntities: MessageEntity) = apply { this.captionEntities = arrayOf(*captionEntities) }

    fun showCaptionAboveMedia(showCaptionAboveMedia: Boolean) = apply { this.showCaptionAboveMedia = showCaptionAboveMedia }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as InputSharedWidgetMessageContent
        return widgetId == other.widgetId &&
                chatData == other.chatData &&
                caption == other.caption &&
                parseMode == other.parseMode &&
                captionEntities contentEquals other.captionEntities &&
                showCaptionAboveMedia == other.showCaptionAboveMedia
    }

    override fun hashCode(): Int {
        var result = widgetId.hashCode()
        result = 31 * result + (chatData?.hashCode() ?: 0)
        result = 31 * result + (caption?.hashCode() ?: 0)
        result = 31 * result + (parseMode?.hashCode() ?: 0)
        result = 31 * result + (captionEntities?.contentHashCode() ?: 0)
        result = 31 * result + (showCaptionAboveMedia?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String =
        "InputSharedWidgetMessageContent(widgetId=$widgetId, chatData=$chatData, caption=$caption, " +
                "parseMode=$parseMode, captionEntities=${captionEntities?.contentToString()}, " +
                "showCaptionAboveMedia=$showCaptionAboveMedia)"
}
