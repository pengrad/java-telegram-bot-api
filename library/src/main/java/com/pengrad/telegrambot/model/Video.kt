package com.pengrad.telegrambot.model

data class Video(
    @get:JvmName("fileId") val fileId: String,
    @get:JvmName("fileUniqueId") val fileUniqueId: String,

    @JvmSynthetic val width: Int,
    @JvmSynthetic val height: Int,
    @JvmSynthetic val duration: Int,

    @get:JvmName("thumbnail") val thumbnail: PhotoSize? = null,
    @get:JvmName("cover") val cover: List<PhotoSize>? = null,

    @get:JvmName("start_timestamp") val startTimestamp: Int? = null,

    @get:JvmName("fileName") val fileName: String? = null,
    @get:JvmName("mimeType") val mimeType: String? = null,
    @get:JvmName("fileSize") val fileSize: Long? = null,

) {

    /**
     * Backwards compatability for Java code because of Kotlin optimization
     */
    @Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN")
    fun width() = width as Integer

    /**
     * Backwards compatability for Java code because of Kotlin optimization
     */
    @Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN")
    fun height() = height as Integer

    /**
     * Backwards compatability for Java code because of Kotlin optimization
     */
    @Suppress("PLATFORM_CLASS_MAPPED_TO_KOTLIN")
    fun duration() = duration as Integer

    @Deprecated("Use thumbnail instead", ReplaceWith("thumbnail"))
    fun thumb(): PhotoSize? = thumbnail

}