package com.pengrad.telegrambot.model

import com.pengrad.telegrambot.utility.kotlin.JavaInteger

data class Video(
    @get:JvmName("fileId") val fileId: String,
    @get:JvmName("fileUniqueId") val fileUniqueId: String,

    @get:JvmSynthetic val width: Int,
    @get:JvmSynthetic val height: Int,
    @get:JvmSynthetic val duration: Int,

    @get:JvmName("thumbnail") val thumbnail: PhotoSize? = null,
    @get:JvmName("cover") val cover: List<PhotoSize>? = null,

    @get:JvmName("startTimestamp") val startTimestamp: Int? = null,

    @get:JvmName("fileName") val fileName: String? = null,
    @get:JvmName("mimeType") val mimeType: String? = null,
    @get:JvmName("fileSize") val fileSize: Long? = null
) {

    /**
     * Backwards compatability for Java code because of Kotlin optimization
     */
    fun width() = width as JavaInteger

    /**
     * Backwards compatability for Java code because of Kotlin optimization
     */
    fun height() = height as JavaInteger

    /**
     * Backwards compatability for Java code because of Kotlin optimization
     */
    fun duration() = duration as JavaInteger

}