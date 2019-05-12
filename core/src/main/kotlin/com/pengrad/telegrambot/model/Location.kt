package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * stas
 * 8/5/15.
 */
class Location : Serializable {

    private val longitude: Float? = null
    private val latitude: Float? = null

    fun longitude(): Float? {
        return longitude
    }

    fun latitude(): Float? {
        return latitude
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val location = o as Location?

        if (if (longitude != null) longitude != location!!.longitude else location!!.longitude != null) return false
        return if (latitude != null) latitude == location.latitude else location.latitude == null
    }

    override fun hashCode(): Int {
        var result = longitude?.hashCode() ?: 0
        result = 31 * result + (latitude?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "Location{" +
                "longitude=" + longitude +
                ", latitude=" + latitude +
                '}'.toString()
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}
