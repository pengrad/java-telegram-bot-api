package com.pengrad.telegrambot.request

import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter
import java.io.File

class SendVideoNote private constructor(
    chatId: Long? = null,
    channelUsername: String? = null,

    videoNoteUrl: String? = null,
    videoNoteFile: File? = null,
    videoNoteBytes: ByteArray? = null
) : AbstractThumbnailedMultipartRequest<SendVideoNote>(
    chatId = chatId,
    channelUsername = channelUsername,

    contentParameterName = "video_note",
    contentUrl = videoNoteUrl,
    contentFile = videoNoteFile,
    contentBytes = videoNoteBytes,

    defaultFileName = ContentTypes.VIDEO_FILE_NAME,
    defaultContentType = ContentTypes.VIDEO_MIME_TYPE
) {

    constructor(chatId: Long, videoNoteUrl: String) : this(
        chatId = chatId,
        channelUsername = null,
        videoNoteUrl = videoNoteUrl
    )

    constructor(channelUsername: String, videoNoteUrl: String) : this(
        chatId = null,
        channelUsername = channelUsername,
        videoNoteUrl = videoNoteUrl
    )


    constructor(chatId: Long, videoNoteFile: File) : this(
        chatId = chatId,
        channelUsername = null,
        videoNoteFile = videoNoteFile
    )

    constructor(channelUsername: String, videoNoteFile: File) : this(
        chatId = null,
        channelUsername = channelUsername,
        videoNoteFile = videoNoteFile
    )


    constructor(chatId: Long, videoNoteBytes: ByteArray) : this(
        chatId = chatId,
        channelUsername = null,
        videoNoteBytes = videoNoteBytes
    )

    constructor(channelUsername: String, videoNoteBytes: ByteArray) : this(
        chatId = null,
        channelUsername = channelUsername,
        videoNoteBytes = videoNoteBytes
    )


    @Deprecated("Use constructor with chatId or channelUsername instead", ReplaceWith("SendVideoNote(chatId, videoNote)"))
    constructor(chatId: Any, videoNote: String) : this(
        chatId = (chatId as? Number)?.toLong(),
        channelUsername = chatId as? String,
        videoNoteUrl = videoNote
    ) {
        checkDeprecatedConstructorParameters()
    }

    @Deprecated("Use constructor with chatId or channelUsername instead", ReplaceWith("SendVideoNote(chatId, videoNote)"))
    constructor(chatId: Any, videoNote: File) : this(
        chatId = (chatId as? Number)?.toLong(),
        channelUsername = chatId as? String,
        videoNoteFile = videoNote
    ) {
        checkDeprecatedConstructorParameters()
    }

    @Deprecated("Use constructor with chatId or channelUsername instead", ReplaceWith("SendVideoNote(chatId, videoNote)"))
    constructor(chatId: Any, videoNote: ByteArray) : this(
        chatId = (chatId as? Number)?.toLong(),
        channelUsername = chatId as? String,
        videoNoteBytes = videoNote
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
    var length: Int? by optionalRequestParameter()

    fun duration(duration: Int) = apply { this.duration = duration }

    fun length(length: Int) = apply { this.length = length }

}