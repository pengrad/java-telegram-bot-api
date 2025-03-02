package com.pengrad.telegrambot.request

import com.pengrad.telegrambot.model.MessageEntity
import com.pengrad.telegrambot.model.request.ParseMode
import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter
import java.io.File

class SendAudio private constructor(
    chatId: Long? = null,
    channelUsername: String? = null,

    audioUrl: String? = null,
    audioFile: File? = null,
    audioBytes: ByteArray? = null
) : AbstractThumbnailedMultipartRequest<SendAudio>(
    chatId = chatId,
    channelUsername = channelUsername,

    contentParameterName = "audio",
    contentUrl = audioUrl,
    contentFile = audioFile,
    contentBytes = audioBytes,

    defaultFileName = ContentTypes.AUDIO_FILE_NAME,
    defaultContentType = ContentTypes.AUDIO_MIME_TYPE
) {

    constructor(chatId: Long, audioUrl: String) : this(
        chatId = chatId,
        channelUsername = null,
        audioUrl = audioUrl
    )

    constructor(channelUsername: String, audioUrl: String) : this(
        chatId = null,
        channelUsername = channelUsername,
        audioUrl = audioUrl
    )


    constructor(chatId: Long, audioFile: File) : this(
        chatId = chatId,
        channelUsername = null,
        audioFile = audioFile
    )

    constructor(channelUsername: String, audioFile: File) : this(
        chatId = null,
        channelUsername = channelUsername,
        audioFile = audioFile
    )


    constructor(chatId: Long, audioBytes: ByteArray) : this(
        chatId = chatId,
        channelUsername = null,
        audioBytes = audioBytes
    )

    constructor(channelUsername: String, audioBytes: ByteArray) : this(
        chatId = null,
        channelUsername = channelUsername,
        audioBytes = audioBytes
    )


    @Deprecated("Use constructor with chatId or channelUsername instead", ReplaceWith("SendAudio(chatId, audio)"))
    constructor(chatId: Any, audio: String) : this(
        chatId = (chatId as? Number)?.toLong(),
        channelUsername = chatId as? String,
        audioUrl = audio
    ) {
        checkDeprecatedConstructorParameters()
    }

    @Deprecated("Use constructor with chatId or channelUsername instead", ReplaceWith("SendAudio(chatId, audio)"))
    constructor(chatId: Any, audio: File) : this(
        chatId = (chatId as? Number)?.toLong(),
        channelUsername = chatId as? String,
        audioFile = audio
    ) {
        checkDeprecatedConstructorParameters()
    }

    @Deprecated("Use constructor with chatId or channelUsername instead", ReplaceWith("SendAudio(chatId, audio)"))
    constructor(chatId: Any, audio: ByteArray) : this(
        chatId = (chatId as? Number)?.toLong(),
        channelUsername = chatId as? String,
        audioBytes = audio
    ) {
        checkDeprecatedConstructorParameters()
    }

    @Suppress("NOTHING_TO_INLINE")
    private inline fun checkDeprecatedConstructorParameters() {
        if (this.chatId == null && this.channelUsername == null) {
            throw IllegalArgumentException("chatId parameter must be either Long or String")
        }
    }

    var caption: String? by optionalRequestParameter()
    var parseMode: ParseMode? by optionalRequestParameter()
    var captionEntities: List<MessageEntity>? by optionalRequestParameter()

    var duration: Int? by optionalRequestParameter()
    var performer: String? by optionalRequestParameter()
    var title: String? by optionalRequestParameter()

    fun caption(caption: String) = applySelf { this.caption = caption }

    fun parseMode(parseMode: ParseMode) = applySelf { this.parseMode = parseMode }

    fun captionEntities(captionEntities: List<MessageEntity>) = applySelf { this.captionEntities = captionEntities }

    fun captionEntities(vararg captionEntities: MessageEntity) = captionEntities(captionEntities.toList())

    fun duration(duration: Int) = applySelf { this.duration = duration }

    fun performer(performer: String) = applySelf { this.performer = performer }

    fun title(title: String) = applySelf { this.title = title }

}