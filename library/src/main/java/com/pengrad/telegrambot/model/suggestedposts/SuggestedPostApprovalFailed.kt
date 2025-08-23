package com.pengrad.telegrambot.model.suggestedposts

import com.pengrad.telegrambot.model.Message

@Suppress("unused")
data class SuggestedPostApprovalFailed (
    @get:JvmName("suggestedPostMessage") val suggestedPostMessage: Message?,
    @get:JvmName("price") val price: SuggestedPostPrice
){
}