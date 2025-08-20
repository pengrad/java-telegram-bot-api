package com.pengrad.telegrambot.model.suggestedposts

import com.pengrad.telegrambot.model.Message

@Suppress("unused")
data class SuggestedPostRefunded (
    @get:JvmName("suggestedPostMessage") val suggestedPostMessage: Message?,
    @get:JvmName("reason") val reason: String
){
}