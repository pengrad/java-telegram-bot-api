package com.pengrad.telegrambot.model

import java.io.Serializable

class PaidMessagesWaived : Serializable {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        return other != null && javaClass == other.javaClass
    }

    override fun hashCode(): Int = 1
}
