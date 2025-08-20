package com.pengrad.telegrambot.model.suggestedposts

@Suppress("unused")
data class SuggestedPostPrice (
    @get:JvmName("currency") val currency: String,
    @get:JvmName("amount") val amount: Long
){
}