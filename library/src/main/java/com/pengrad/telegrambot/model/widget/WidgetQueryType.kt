package com.pengrad.telegrambot.model.widget

import java.io.Serializable

interface WidgetQueryType : Serializable {
    val type: String

    companion object {
        const val DATA = "data"
        const val SIGN_DATA = "sign_data"
        const val SENT_TRANSACTION = "sent_transaction"
        const val UNKNOWN = "unknown"
    }
}
