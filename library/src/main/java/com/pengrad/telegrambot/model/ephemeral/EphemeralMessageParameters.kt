package com.pengrad.telegrambot.model.ephemeral

class EphemeralMessageParameters private constructor(
    @get:JvmName("receiverUserId") val receiverUserId: Long,
    @get:JvmName("callbackQueryId") var callbackQueryId: String?,
    @get:JvmName("replaceCallbackQueryMessage") var replaceCallbackQueryMessage: Boolean?,
) {

    constructor(receiverUserId: Long) : this(
        receiverUserId = receiverUserId,
        callbackQueryId = null,
        replaceCallbackQueryMessage = null
    )

    fun callbackQueryId(callbackQueryId: String) = apply {
        this.callbackQueryId = callbackQueryId
    }

    fun replaceCallbackQueryMessage(replaceCallbackQueryMessage: Boolean) = apply {
        this.replaceCallbackQueryMessage = replaceCallbackQueryMessage
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as EphemeralMessageParameters
        return receiverUserId == other.receiverUserId &&
                callbackQueryId == other.callbackQueryId &&
                replaceCallbackQueryMessage == other.replaceCallbackQueryMessage
    }

    override fun hashCode(): Int {
        var result = receiverUserId.hashCode()
        result = 31 * result + (callbackQueryId?.hashCode() ?: 0)
        result = 31 * result + (replaceCallbackQueryMessage?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String =
        "EphemeralMessageParameters(receiverUserId=$receiverUserId, callbackQueryId=$callbackQueryId, replaceCallbackQueryMessage=$replaceCallbackQueryMessage)"
}
