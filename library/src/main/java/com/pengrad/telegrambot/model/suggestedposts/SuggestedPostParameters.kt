package com.pengrad.telegrambot.model.suggestedposts

@Suppress("unused")
data class SuggestedPostParameters (
    @get:JvmName("price") val price: SuggestedPostPrice?,
    @get:JvmName("sendDate") val sendDate: Long?
){

}