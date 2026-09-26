package com.pengrad.telegrambot.request

import com.pengrad.telegrambot.model.MessageEntity
import com.pengrad.telegrambot.model.ephemeral.EphemeralMessageParameters
import com.pengrad.telegrambot.model.request.ParseMode
import com.pengrad.telegrambot.utility.kotlin.checkDeprecatedConstructorParameters
import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter
import java.io.File

class SendLivePhoto private constructor(
    chatId: Long? = null,
    channelUsername: String? = null,

    livePhotoId: String? = null,
    livePhotoFile: File? = null,
    livePhotoBytes: ByteArray? = null,

    photoId: String? = null,
    photoFile: File? = null,
    photoBytes: ByteArray? = null,
) : AbstractMultipartRequest<SendLivePhoto>(
    chatId = chatId,
    channelUsername = channelUsername,

    contentParameterName = "live_photo",
    contentUrl = livePhotoId,
    contentFile = livePhotoFile,
    contentBytes = livePhotoBytes,

    defaultFileName = ContentTypes.VIDEO_FILE_NAME,
    defaultContentType = ContentTypes.VIDEO_MIME_TYPE,
) {

    constructor(chatId: Long, livePhotoId: String, photoId: String) : this(
        chatId = chatId,
        channelUsername = null,
        livePhotoId = livePhotoId,
        photoId = photoId,
    )

    constructor(channelUsername: String, livePhotoId: String, photoId: String) : this(
        chatId = null,
        channelUsername = channelUsername,
        livePhotoId = livePhotoId,
        photoId = photoId,
    )

    constructor(chatId: Long, livePhotoId: String, photoFile: File) : this(
        chatId = chatId,
        channelUsername = null,
        livePhotoId = livePhotoId,
        photoFile = photoFile,
    )

    constructor(channelUsername: String, livePhotoId: String, photoFile: File) : this(
        chatId = null,
        channelUsername = channelUsername,
        livePhotoId = livePhotoId,
        photoFile = photoFile,
    )

    constructor(chatId: Long, livePhotoId: String, photoBytes: ByteArray) : this(
        chatId = chatId,
        channelUsername = null,
        livePhotoId = livePhotoId,
        photoBytes = photoBytes,
    )

    constructor(channelUsername: String, livePhotoId: String, photoBytes: ByteArray) : this(
        chatId = null,
        channelUsername = channelUsername,
        livePhotoId = livePhotoId,
        photoBytes = photoBytes,
    )

    constructor(chatId: Long, livePhotoFile: File, photoId: String) : this(
        chatId = chatId,
        channelUsername = null,
        livePhotoFile = livePhotoFile,
        photoId = photoId,
    )

    constructor(channelUsername: String, livePhotoFile: File, photoId: String) : this(
        chatId = null,
        channelUsername = channelUsername,
        livePhotoFile = livePhotoFile,
        photoId = photoId,
    )

    constructor(chatId: Long, livePhotoFile: File, photoFile: File) : this(
        chatId = chatId,
        channelUsername = null,
        livePhotoFile = livePhotoFile,
        photoFile = photoFile,
    )

    constructor(channelUsername: String, livePhotoFile: File, photoFile: File) : this(
        chatId = null,
        channelUsername = channelUsername,
        livePhotoFile = livePhotoFile,
        photoFile = photoFile,
    )

    constructor(chatId: Long, livePhotoFile: File, photoBytes: ByteArray) : this(
        chatId = chatId,
        channelUsername = null,
        livePhotoFile = livePhotoFile,
        photoBytes = photoBytes,
    )

    constructor(channelUsername: String, livePhotoFile: File, photoBytes: ByteArray) : this(
        chatId = null,
        channelUsername = channelUsername,
        livePhotoFile = livePhotoFile,
        photoBytes = photoBytes,
    )

    constructor(chatId: Long, livePhotoBytes: ByteArray, photoId: String) : this(
        chatId = chatId,
        channelUsername = null,
        livePhotoBytes = livePhotoBytes,
        photoId = photoId,
    )

    constructor(channelUsername: String, livePhotoBytes: ByteArray, photoId: String) : this(
        chatId = null,
        channelUsername = channelUsername,
        livePhotoBytes = livePhotoBytes,
        photoId = photoId,
    )

    constructor(chatId: Long, livePhotoBytes: ByteArray, photoFile: File) : this(
        chatId = chatId,
        channelUsername = null,
        livePhotoBytes = livePhotoBytes,
        photoFile = photoFile,
    )

    constructor(channelUsername: String, livePhotoBytes: ByteArray, photoFile: File) : this(
        chatId = null,
        channelUsername = channelUsername,
        livePhotoBytes = livePhotoBytes,
        photoFile = photoFile,
    )

    constructor(chatId: Long, livePhotoBytes: ByteArray, photoBytes: ByteArray) : this(
        chatId = chatId,
        channelUsername = null,
        livePhotoBytes = livePhotoBytes,
        photoBytes = photoBytes,
    )

    constructor(channelUsername: String, livePhotoBytes: ByteArray, photoBytes: ByteArray) : this(
        chatId = null,
        channelUsername = channelUsername,
        livePhotoBytes = livePhotoBytes,
        photoBytes = photoBytes,
    )

    @Deprecated("Use constructor with chatId or channelUsername instead", ReplaceWith("SendLivePhoto(chatId, livePhoto, photo)"))
    constructor(chatId: Any, livePhoto: File, photo: File) : this(
        chatId = (chatId as? Number)?.toLong(),
        channelUsername = chatId as? String,
        livePhotoFile = livePhoto,
        photoFile = photo,
    ) {
        checkDeprecatedConstructorParameters()
    }

    @Deprecated("Use constructor with chatId or channelUsername instead", ReplaceWith("SendLivePhoto(chatId, livePhoto, photo)"))
    constructor(chatId: Any, livePhoto: File, photo: ByteArray) : this(
        chatId = (chatId as? Number)?.toLong(),
        channelUsername = chatId as? String,
        livePhotoFile = livePhoto,
        photoBytes = photo,
    ) {
        checkDeprecatedConstructorParameters()
    }

    @Deprecated("Use constructor with chatId or channelUsername instead", ReplaceWith("SendLivePhoto(chatId, livePhoto, photo)"))
    constructor(chatId: Any, livePhoto: ByteArray, photo: File) : this(
        chatId = (chatId as? Number)?.toLong(),
        channelUsername = chatId as? String,
        livePhotoBytes = livePhoto,
        photoFile = photo,
    ) {
        checkDeprecatedConstructorParameters()
    }

    @Deprecated("Use constructor with chatId or channelUsername instead", ReplaceWith("SendLivePhoto(chatId, livePhoto, photo)"))
    constructor(chatId: Any, livePhoto: ByteArray, photo: ByteArray) : this(
        chatId = (chatId as? Number)?.toLong(),
        channelUsername = chatId as? String,
        livePhotoBytes = livePhoto,
        photoBytes = photo,
    ) {
        checkDeprecatedConstructorParameters()
    }

    val photoId: String? by optionalRequestParameter(photoId, customParameterName = "photo")
    val photoFile: File? by optionalRequestParameter(photoFile, customParameterName = "photo")
    val photoBytes: ByteArray? by optionalRequestParameter(photoBytes, customParameterName = "photo")

    override val isMultipartRequest: Boolean
        get() = super.isMultipartRequest || photoFile != null || photoBytes != null

    var caption: String? by optionalRequestParameter()
    var parseMode: ParseMode? by optionalRequestParameter()
    var captionEntities: List<MessageEntity>? by optionalRequestParameter()
    var showCaptionAboveMedia: Boolean? by optionalRequestParameter()
    var hasSpoiler: Boolean? by optionalRequestParameter()
    var ephemeralMessageParameters: EphemeralMessageParameters? by optionalRequestParameter()

    fun caption(caption: String) = applySelf { this.caption = caption }
    fun parseMode(parseMode: ParseMode) = applySelf { this.parseMode = parseMode }
    fun captionEntities(captionEntities: List<MessageEntity>) = applySelf { this.captionEntities = captionEntities }
    fun captionEntities(vararg captionEntities: MessageEntity) = applySelf { this.captionEntities = captionEntities.toList() }
    fun showCaptionAboveMedia(showCaptionAboveMedia: Boolean) = applySelf { this.showCaptionAboveMedia = showCaptionAboveMedia }
    fun hasSpoiler(hasSpoiler: Boolean) = applySelf { this.hasSpoiler = hasSpoiler }

    fun ephemeralMessageParameters(ephemeralMessageParameters: EphemeralMessageParameters) = applySelf { this.ephemeralMessageParameters = ephemeralMessageParameters }
}
