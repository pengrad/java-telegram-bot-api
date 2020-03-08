package com.pengrad.telegrambot.model

import com.pengrad.telegrambot.impl.SerialName
import java.io.Serializable

/**
 * Stas Parshin
 * 03 October 2016
 */
data class WebhookInfo(
        @get:JvmName("url") val url: String? = null,
        @get:JvmName("hasCustomCertificate") @SerialName("has_custom_certificate") val hasCustomCertificate: Boolean? = null,
        @get:JvmName("pendingUpdateCount") @SerialName("pending_update_count") val pendingUpdateCount: Int? = null,
        @get:JvmName("lastErrorDate") @SerialName("last_error_date") val lastErrorDate: Int? = null,
        @get:JvmName("lastErrorMessage") @SerialName("last_error_message") val lastErrorMessage: String? = null,
        @get:JvmName("maxConnections") @SerialName("max_connections") val maxConnections: Int? = null,
        @get:JvmSynthetic @SerialName("allowed_updates") val allowedUpdates: List<String>? = null
) : Serializable {

    fun allowedUpdates(): Array<String>? = allowedUpdates?.toTypedArray()

    companion object {
        private const val serialVersionUID = 0L
    }
}