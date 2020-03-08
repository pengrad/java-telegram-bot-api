package com.pengrad.telegrambot.model

import com.pengrad.telegrambot.impl.SerialName
import java.io.Serializable

/**
 * Stas Parshin
 * 24 May 2017
 */
data class Invoice(
        @get:JvmName("title") val title: String? = null,
        @get:JvmName("description") val description: String? = null,
        @get:JvmName("startParameter") @SerialName("start_parameter") val startParameter: String? = null,
        @get:JvmName("currency") val currency: String? = null,
        @get:JvmName("totalAmount") @SerialName("total_amount") val totalAmount: Int? = null
) : Serializable {
    companion object {
        private const val serialVersionUID = 0L
    }
}