package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * stas
 * 5/3/16.
 */
class Venue : Serializable {

    private val location: Location? = null
    private val title: String? = null
    private val address: String? = null
    private val foursquare_id: String? = null
    private val foursquare_type: String? = null

    fun location(): Location? {
        return location
    }

    fun title(): String? {
        return title
    }

    fun address(): String? {
        return address
    }

    fun foursquareId(): String? {
        return foursquare_id
    }

    fun foursquareType(): String? {
        return foursquare_type
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val venue = o as Venue?

        if (if (location != null) location != venue!!.location else venue!!.location != null) return false
        if (if (title != null) title != venue.title else venue.title != null) return false
        if (if (address != null) address != venue.address else venue.address != null) return false
        if (if (foursquare_id != null) foursquare_id != venue.foursquare_id else venue.foursquare_id != null) return false
        return if (foursquare_type != null) foursquare_type == venue.foursquare_type else venue.foursquare_type == null
    }

    override fun hashCode(): Int {
        var result = location?.hashCode() ?: 0
        result = 31 * result + (title?.hashCode() ?: 0)
        result = 31 * result + (address?.hashCode() ?: 0)
        result = 31 * result + (foursquare_id?.hashCode() ?: 0)
        result = 31 * result + (foursquare_type?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "Venue{" +
                "location=" + location +
                ", title='" + title + '\''.toString() +
                ", address='" + address + '\''.toString() +
                ", foursquare_id='" + foursquare_id + '\''.toString() +
                ", foursquare_type='" + foursquare_type + '\''.toString() +
                '}'.toString()
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}
