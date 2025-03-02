package com.pengrad.telegrambot.request

import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter
import java.io.File

class SendSticker private constructor(
    chatId: Long? = null,
    channelUsername: String? = null,

    stickerUrl: String? = null,
    stickerFile: File? = null,
    stickerBytes: ByteArray? = null
) : AbstractThumbnailedMultipartRequest<SendSticker>(
    chatId = chatId,
    channelUsername = channelUsername,

    contentParameterName = "sticker",
    contentUrl = stickerUrl,
    contentFile = stickerFile,
    contentBytes = stickerBytes,

    defaultFileName = ContentTypes.PHOTO_FILE_NAME,
    defaultContentType = ContentTypes.PHOTO_MIME_TYPE
) {

    constructor(chatId: Long, stickerUrl: String) : this(
        chatId = chatId,
        channelUsername = null,
        stickerUrl = stickerUrl
    )

    constructor(channelUsername: String, stickerUrl: String) : this(
        chatId = null,
        channelUsername = channelUsername,
        stickerUrl = stickerUrl
    )


    constructor(chatId: Long, stickerFile: File) : this(
        chatId = chatId,
        channelUsername = null,
        stickerFile = stickerFile
    )

    constructor(channelUsername: String, stickerFile: File) : this(
        chatId = null,
        channelUsername = channelUsername,
        stickerFile = stickerFile
    )


    constructor(chatId: Long, stickerBytes: ByteArray) : this(
        chatId = chatId,
        channelUsername = null,
        stickerBytes = stickerBytes
    )

    constructor(channelUsername: String, stickerBytes: ByteArray) : this(
        chatId = null,
        channelUsername = channelUsername,
        stickerBytes = stickerBytes
    )


    @Deprecated("Use constructor with chatId or channelUsername instead", ReplaceWith("SendSticker(chatId, sticker)"))
    constructor(chatId: Any, sticker: String) : this(
        chatId = (chatId as? Number)?.toLong(),
        channelUsername = chatId as? String,
        stickerUrl = sticker
    ) {
        checkDeprecatedConstructorParameters()
    }

    @Deprecated("Use constructor with chatId or channelUsername instead", ReplaceWith("SendSticker(chatId, sticker)"))
    constructor(chatId: Any, sticker: File) : this(
        chatId = (chatId as? Number)?.toLong(),
        channelUsername = chatId as? String,
        stickerFile = sticker
    ) {
        checkDeprecatedConstructorParameters()
    }

    @Deprecated("Use constructor with chatId or channelUsername instead", ReplaceWith("SendSticker(chatId, sticker)"))
    constructor(chatId: Any, sticker: ByteArray) : this(
        chatId = (chatId as? Number)?.toLong(),
        channelUsername = chatId as? String,
        stickerBytes = sticker
    ) {
        checkDeprecatedConstructorParameters()
    }

    @Suppress("NOTHING_TO_INLINE")
    private inline fun checkDeprecatedConstructorParameters() {
        if (this.chatId == null && this.channelUsername == null) {
            throw IllegalArgumentException("chatId parameter must be either Long or String")
        }
    }

    var emoji: String? by optionalRequestParameter()

    fun emoji(emoji: String) = applySelf { this.emoji = emoji }

}