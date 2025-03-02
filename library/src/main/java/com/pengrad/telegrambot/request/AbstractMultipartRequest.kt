package com.pengrad.telegrambot.request

import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter
import java.io.File

abstract class AbstractMultipartRequest<REQ : AbstractMultipartRequest<REQ>>(
    chatId: Long?,
    channelUsername: String?,

    contentParameterName: String,
    contentUrl: String?,
    contentFile: File?,
    contentBytes: ByteArray?,

    defaultFileName: String,
    defaultContentType: String
) : KAbstractSendRequest<REQ>(
    chatId = chatId,
    channelUsername = channelUsername
) {

    val contentUrl by optionalRequestParameter(contentUrl, customParameterName = contentParameterName)
    val contentFile by optionalRequestParameter(contentFile, customParameterName = contentParameterName)
    val contentBytes by optionalRequestParameter(contentBytes, customParameterName = contentParameterName)

    open val isMultipartRequest: Boolean
        get() = contentFile != null || contentBytes != null

    @get:JvmName("getContentFileName")
    var fileName: String = contentFile?.name ?: defaultFileName

    @get:JvmName("getContentMimeType")
    var contentType: String = defaultContentType

    fun fileName(fileName: String) = applySelf { this.fileName = fileName }

    fun contentType(contentType: String) = applySelf { this.contentType = contentType }

    override fun isMultipart() = isMultipartRequest

    override fun getFileName() = fileName

    override fun getContentType() = contentType

}