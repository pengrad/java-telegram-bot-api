package com.pengrad.telegrambot.model

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

    override fun toString(): String {
        return "LocationAddress(countryCode='$countryCode', state=$state, city=$city, street=$street)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LocationAddress

        if (countryCode != other.countryCode) return false
        if (state != other.state) return false
        if (city != other.city) return false
        if (street != other.street) return false

        return true
    }

    override fun hashCode(): Int {
        var result = countryCode.hashCode()
        result = 31 * result + (state?.hashCode() ?: 0)
        result = 31 * result + (city?.hashCode() ?: 0)
        result = 31 * result + (street?.hashCode() ?: 0)
        return result
    }


}