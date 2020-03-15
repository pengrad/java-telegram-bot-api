package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * Stas Parshin
 * 24 May 2017
 */
data class Invoice(
        @get:JvmName("title") val title: String? = null,
        @get:JvmName("description") val description: String? = null,
        @get:JvmName("startParameter") val start_parameter: String? = null,
        @get:JvmName("currency") val currency: String? = null,
        @get:JvmName("totalAmount") val total_amount: Int? = null
) : Serializable {
    companion object {
        private const val serialVersionUID = 0L
    }
}