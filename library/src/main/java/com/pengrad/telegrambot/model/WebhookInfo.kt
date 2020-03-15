package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * Stas Parshin
 * 03 October 2016
 */
data class WebhookInfo(
        @get:JvmName("url") val url: String? = null,
        @get:JvmName("hasCustomCertificate") val has_custom_certificate: Boolean? = null,
        @get:JvmName("pendingUpdateCount") val pending_update_count: Int? = null,
        @get:JvmName("lastErrorDate") val last_error_date: Int? = null,
        @get:JvmName("lastErrorMessage") val last_error_message: String? = null,
        @get:JvmName("maxConnections") val max_connections: Int? = null,
        @get:JvmSynthetic val allowed_updates: List<String>? = null
) : Serializable {

    fun allowedUpdates(): Array<String>? = allowed_updates?.toTypedArray()

    companion object {
        private const val serialVersionUID = 0L
    }
}