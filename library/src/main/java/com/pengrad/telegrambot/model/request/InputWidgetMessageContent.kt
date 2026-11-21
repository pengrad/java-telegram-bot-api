package com.pengrad.telegrambot.model.request

import com.pengrad.telegrambot.model.MessageEntity

class InputWidgetMessageContent private constructor(
    @get:JvmName("html") val html: String,
    @get:JvmName("width") var width: Int?,
    @get:JvmName("height") var height: Int?,
    @get:JvmName("publicData") var publicData: String?,
    @get:JvmName("chatData") var chatData: String?,
    @get:JvmName("caption") var caption: String?,
    @get:JvmName("parseMode") var parseMode: ParseMode?,
    @get:JvmName("captionEntities") var captionEntities: Array<MessageEntity>?,
    @get:JvmName("showCaptionAboveMedia") var showCaptionAboveMedia: Boolean?,
    @get:JvmName("allowQueries") var allowQueries: Boolean?,
    @get:JvmName("isShared") var isShared: Boolean?,
) : InputMessageContent() {

    constructor(html: String) : this(
        html = html,
        width = null,
        height = null,
        publicData = null,
        chatData = null,
        caption = null,
        parseMode = null,
        captionEntities = null,
        showCaptionAboveMedia = null,
        allowQueries = null,
        isShared = null,
    )

    fun width(width: Int) = apply { this.width = width }

    fun height(height: Int) = apply { this.height = height }

    fun publicData(publicData: String) = apply { this.publicData = publicData }

    fun chatData(chatData: String) = apply { this.chatData = chatData }

    fun caption(caption: String) = apply { this.caption = caption }

    fun parseMode(parseMode: ParseMode) = apply { this.parseMode = parseMode }

    fun captionEntities(vararg captionEntities: MessageEntity) = apply { this.captionEntities = arrayOf(*captionEntities) }

    fun showCaptionAboveMedia(showCaptionAboveMedia: Boolean) = apply { this.showCaptionAboveMedia = showCaptionAboveMedia }

    fun allowQueries(allowQueries: Boolean) = apply { this.allowQueries = allowQueries }

    fun isShared(isShared: Boolean) = apply { this.isShared = isShared }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as InputWidgetMessageContent
        return html == other.html &&
                width == other.width &&
                height == other.height &&
                publicData == other.publicData &&
                chatData == other.chatData &&
                caption == other.caption &&
                parseMode == other.parseMode &&
                captionEntities contentEquals other.captionEntities &&
                showCaptionAboveMedia == other.showCaptionAboveMedia &&
                allowQueries == other.allowQueries &&
                isShared == other.isShared
    }

    override fun hashCode(): Int {
        var result = html.hashCode()
        result = 31 * result + (width ?: 0)
        result = 31 * result + (height ?: 0)
        result = 31 * result + (publicData?.hashCode() ?: 0)
        result = 31 * result + (chatData?.hashCode() ?: 0)
        result = 31 * result + (caption?.hashCode() ?: 0)
        result = 31 * result + (parseMode?.hashCode() ?: 0)
        result = 31 * result + (captionEntities?.contentHashCode() ?: 0)
        result = 31 * result + (showCaptionAboveMedia?.hashCode() ?: 0)
        result = 31 * result + (allowQueries?.hashCode() ?: 0)
        result = 31 * result + (isShared?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String =
        "InputWidgetMessageContent(html=$html, width=$width, height=$height, publicData=$publicData, " +
                "chatData=$chatData, caption=$caption, parseMode=$parseMode, " +
                "captionEntities=${captionEntities?.contentToString()}, showCaptionAboveMedia=$showCaptionAboveMedia, " +
                "allowQueries=$allowQueries, isShared=$isShared)"
}
