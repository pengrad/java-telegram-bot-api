package com.pengrad.telegrambot.model.story.area.type

import com.pengrad.telegrambot.model.LocationAddress

class StoryAreaTypeLocation private constructor(
    @get:JvmName("latitude") val latitude: Double,
    @get:JvmName("longitude") val longitude: Double,
    @get:JvmName("address") var address: LocationAddress?
) : StoryAreaType(type = "location") {

    constructor(latitude: Double, longitude: Double) : this(
        latitude = latitude,
        longitude = longitude,
        address = null
    )

    fun address(address: LocationAddress) = apply {
        this.address = address
    }

    override fun toString(): String {
        return "StoryAreaTypeLocation(latitude=$latitude, longitude=$longitude, address=$address)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as StoryAreaTypeLocation

        if (latitude.compareTo(other.latitude) != 0) return false
        if (longitude.compareTo(other.longitude) != 0) return false
        if (address != other.address) return false

        return type == other.type
    }

    override fun hashCode(): Int {
        var result = latitude.hashCode()
        result = 31 * result + longitude.hashCode()
        result = 31 * result + (address?.hashCode() ?: 0)
        return result
    }


}