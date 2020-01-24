package com.pengrad.telegrambot.model

import java.io.Serializable
import java.util.Arrays

/**
 * Stas Parshin
 * 03 October 2016
 */
class WebhookInfo : Serializable {

    private val url: String? = null
    private val has_custom_certificate: Boolean? = null
    private val pending_update_count: Int? = null
    private val last_error_date: Int? = null
    private val last_error_message: String? = null
    private val max_connections: Int? = null
    private val allowed_updates: Array<String>? = null

    fun url(): String? {
        return url
    }

    fun hasCustomCertificate(): Boolean? {
        return has_custom_certificate
    }

    fun pendingUpdateCount(): Int? {
        return pending_update_count
    }

    fun lastErrorDate(): Int? {
        return last_error_date
    }

    fun lastErrorMessage(): String? {
        return last_error_message
    }

    fun maxConnections(): Int? {
        return max_connections
    }

    fun allowedUpdates(): Array<String>? {
        return allowed_updates
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val that = o as WebhookInfo?

        if (if (url != null) url != that!!.url else that!!.url != null) return false
        if (if (has_custom_certificate != null) has_custom_certificate != that.has_custom_certificate else that.has_custom_certificate != null)
            return false
        if (if (pending_update_count != null) pending_update_count != that.pending_update_count else that.pending_update_count != null)
            return false
        if (if (last_error_date != null) last_error_date != that.last_error_date else that.last_error_date != null)
            return false
        if (if (last_error_message != null) last_error_message != that.last_error_message else that.last_error_message != null)
            return false
        return if (if (max_connections != null) max_connections != that.max_connections else that.max_connections != null) false else Arrays.equals(allowed_updates, that.allowed_updates)
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
    }

    override fun hashCode(): Int {
        var result = url?.hashCode() ?: 0
        result = 31 * result + (has_custom_certificate?.hashCode() ?: 0)
        result = 31 * result + (pending_update_count?.hashCode() ?: 0)
        result = 31 * result + (last_error_date?.hashCode() ?: 0)
        result = 31 * result + (last_error_message?.hashCode() ?: 0)
        result = 31 * result + (max_connections?.hashCode() ?: 0)
        result = 31 * result + Arrays.hashCode(allowed_updates)
        return result
    }

    override fun toString(): String {
        return "WebhookInfo{" +
                "url='" + url + '\''.toString() +
                ", has_custom_certificate=" + has_custom_certificate +
                ", pending_update_count=" + pending_update_count +
                ", last_error_date=" + last_error_date +
                ", last_error_message='" + last_error_message + '\''.toString() +
                ", max_connections=" + max_connections +
                ", allowed_updates=" + Arrays.toString(allowed_updates) +
                '}'.toString()
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}
