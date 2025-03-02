package com.pengrad.telegrambot.request

import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter
import java.io.File

abstract class AbstractThumbnailedMultipartRequest<REQ : AbstractThumbnailedMultipartRequest<REQ>>(
    chatId: Long?,
    channelUsername: String?,

    contentParameterName: String,
    contentUrl: String?,
    contentFile: File?,
    contentBytes: ByteArray?,

    defaultFileName: String,
    defaultContentType: String
) : KAbstractMultipartRequest<REQ>(
    chatId = chatId,
    channelUsername = channelUsername,

    contentParameterName = contentParameterName,
    contentUrl = contentUrl,
    contentFile = contentFile,
    contentBytes = contentBytes,

    defaultFileName = defaultFileName,
    defaultContentType = defaultContentType
) {

    var thumbnailFile: File? by optionalRequestParameter(customParameterName = "thumbnail")
    var thumbnailBytes: ByteArray? by optionalRequestParameter(customParameterName = "thumbnail")

    override val isMultipartRequest: Boolean
        get() = super.isMultipartRequest
                || thumbnailFile != null || thumbnailBytes != null

    fun thumbnail(thumbnail: File) = applySelf { this.thumbnailFile = thumbnail }

    fun thumbnail(thumbnail: ByteArray) = applySelf { this.thumbnailBytes = thumbnail }

}