package com.pengrad.telegrambot.model.suggestedposts

import com.pengrad.telegrambot.model.Message

@Suppress("unused")
data class SuggestedPostDeclined (
    @get:JvmName("suggestedPostMessage") val suggestedPostMessage: Message?,
    @get:JvmName("comment") val comment: String?
){
}