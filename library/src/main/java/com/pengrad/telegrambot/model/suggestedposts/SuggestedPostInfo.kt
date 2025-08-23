package com.pengrad.telegrambot.model.suggestedposts

@Suppress("unused")
data class SuggestedPostInfo (
    @get:JvmName("state") val state: String,
    @get:JvmName("price") val price: SuggestedPostPrice?,
    @get:JvmName("sendDate") val sendDate: Long?
){
}