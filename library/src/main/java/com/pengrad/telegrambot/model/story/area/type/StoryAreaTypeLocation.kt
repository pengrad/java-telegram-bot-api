package com.pengrad.telegrambot.model.story.area.type

import com.pengrad.telegrambot.model.LocationAddress

@Suppress("unused")
class StoryAreaTypeLocation private constructor(
    @get:JvmName("latitude") val latitude: Double,
    @get:JvmName("longitude") val longitude: Double,
    @get:JvmName("address") var address: LocationAddress?
): StoryAreaType(type = "location") {

    constructor(latitude: Double, longitude: Double) : this(
        latitude = latitude,
        longitude = longitude,
        address = null
    )

    fun address(address: LocationAddress) = apply {
        this.address = address
    }

}