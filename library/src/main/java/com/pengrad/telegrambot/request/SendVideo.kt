package com.pengrad.telegrambot.request

import com.pengrad.telegrambot.model.MessageEntity
import com.pengrad.telegrambot.model.request.ParseMode
import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter
import java.io.File

class SendVideo private constructor(
    chatId: Long? = null,
    channelUsername: String? = null,

    videoUrl: String? = null,
    videoFile: File? = null,
    videoBytes: ByteArray? = null
) : AbstractThumbnailedMultipartRequest<SendVideo>(
    chatId = chatId,
    channelUsername = channelUsername,

    contentParameterName = "video",
    contentUrl = videoUrl,
    contentFile = videoFile,
    contentBytes = videoBytes,

    defaultFileName = ContentTypes.VIDEO_FILE_NAME,
    defaultContentType = ContentTypes.VIDEO_MIME_TYPE
) {

    constructor(chatId: Long, videoUrl: String) : this(
        chatId = chatId,
        channelUsername = null,
        videoUrl = videoUrl
    )

    constructor(channelUsername: String, videoUrl: String) : this(
        chatId = null,
        channelUsername = channelUsername,
        videoUrl = videoUrl
    )


    constructor(chatId: Long, videoFile: File) : this(
        chatId = chatId,
        channelUsername = null,
        videoFile = videoFile
    )

    constructor(channelUsername: String, videoFile: File) : this(
        chatId = null,
        channelUsername = channelUsername,
        videoFile = videoFile
    )


    constructor(chatId: Long, videoBytes: ByteArray) : this(
        chatId = chatId,
        channelUsername = null,
        videoBytes = videoBytes
    )

    constructor(channelUsername: String, videoBytes: ByteArray) : this(
        chatId = null,
        channelUsername = channelUsername,
        videoBytes = videoBytes
    )


    @Deprecated("Use constructor with chatId or channelUsername instead", ReplaceWith("SendVideo(chatId, video)"))
    constructor(chatId: Any, video: String) : this(
        chatId = (chatId as? Number)?.toLong(),
        channelUsername = chatId as? String,
        videoUrl = video
    ) {
        checkDeprecatedConstructorParameters()
    }

    @Deprecated("Use constructor with chatId or channelUsername instead", ReplaceWith("SendVideo(chatId, video)"))
    constructor(chatId: Any, video: File) : this(
        chatId = (chatId as? Number)?.toLong(),
        channelUsername = chatId as? String,
        videoFile = video
    ) {
        checkDeprecatedConstructorParameters()
    }

    @Deprecated("Use constructor with chatId or channelUsername instead", ReplaceWith("SendVideo(chatId, video)"))
    constructor(chatId: Any, video: ByteArray) : this(
        chatId = (chatId as? Number)?.toLong(),
        channelUsername = chatId as? String,
        videoBytes = video
    ) {
        checkDeprecatedConstructorParameters()
    }

    @Suppress("NOTHING_TO_INLINE")
    private inline fun checkDeprecatedConstructorParameters() {
        if (this.chatId == null && this.channelUsername == null) {
            throw IllegalArgumentException("chatId parameter must be either Long or String")
        }
    }

    var duration: Int? by optionalRequestParameter()
    var width: Int? by optionalRequestParameter()
    var height: Int? by optionalRequestParameter()

    var coverUrl: String? by optionalRequestParameter(customParameterName = "cover")
    var coverFile: File? by optionalRequestParameter(customParameterName = "cover")
    var coverBytes: ByteArray? by optionalRequestParameter(customParameterName = "cover")

    var startTimestamp: Int? by optionalRequestParameter()

    var caption: String? by optionalRequestParameter()
    var parseMode: ParseMode? by optionalRequestParameter()
    var captionEntities: List<MessageEntity>? by optionalRequestParameter()
    var showCaptionAboveMedia: Boolean? by optionalRequestParameter()

    var hasSpoiler: Boolean? by optionalRequestParameter()
    var supportsStreaming: Boolean? by optionalRequestParameter()

    fun duration(duration: Int) = applySelf { this.duration = duration }

    fun width(width: Int) = applySelf { this.width = width }

    fun height(height: Int) = applySelf { this.height = height }

    fun coverUrl(coverUrl: String) = applySelf { this.coverUrl = coverUrl }

    fun coverFile(coverFile: File) = applySelf { this.coverFile = coverFile }

    fun coverBytes(coverBytes: ByteArray) = applySelf { this.coverBytes = coverBytes }

    fun startTimestamp(startTimestamp: Int) = applySelf { this.startTimestamp = startTimestamp }

    fun caption(caption: String) = applySelf { this.caption = caption }

    fun parseMode(parseMode: ParseMode) = applySelf { this.parseMode = parseMode }

    fun captionEntities(captionEntities: List<MessageEntity>) = applySelf { this.captionEntities = captionEntities }

    fun captionEntities(vararg captionEntities: MessageEntity) = applySelf { this.captionEntities = captionEntities.toList() }

    fun showCaptionAboveMedia(showCaptionAboveMedia: Boolean) = applySelf { this.showCaptionAboveMedia = showCaptionAboveMedia }

    fun hasSpoiler(hasSpoiler: Boolean) = applySelf { this.hasSpoiler = hasSpoiler }

    fun supportsStreaming(supportsStreaming: Boolean) = applySelf { this.supportsStreaming = supportsStreaming }

}