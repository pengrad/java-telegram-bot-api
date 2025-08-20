package com.pengrad.telegrambot.model.suggestedposts

import com.pengrad.telegrambot.model.Message

@Suppress("unused")
data class SuggestedPostApproved (
    @get:JvmName("suggestedPostMessage") val suggestedPostMessage: Message?,
    @get:JvmName("price") val price: SuggestedPostPrice?,
    @get:JvmName("sendDate") val sendDate: Int
){
}