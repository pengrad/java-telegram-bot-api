package com.pengrad.telegrambot.model

@Suppress("unused")
class LocationAddress private constructor(
    @get:JvmName("countryCode") val countryCode: String,
    @get:JvmName("state") var state: String?,
    @get:JvmName("city") var city: String?,
    @get:JvmName("street") var street: String?
) {

    constructor(countryCode: String) : this(
        countryCode = countryCode,
        state = null,
        city = null,
        street = null
    )

    fun state(state: String) = apply {
        this.state = state
    }

    fun city(city: String) = apply {
        this.city = city
    }

    fun street(street: String) = apply {
        this.street = street
    }

}