package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * stas
 * 1/12/16.
 */
class InlineQuery : Serializable {

    private val id: String? = null
    private val from: User? = null
    private val location: Location? = null
    private val query: String? = null
    private val offset: String? = null

    fun id(): String? {
        return id
    }

    fun from(): User? {
        return from
    }

    fun location(): Location? {
        return location
    }

    fun query(): String? {
        return query
    }

    fun offset(): String? {
        return offset
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val that = o as InlineQuery?

        if (if (id != null) id != that!!.id else that!!.id != null) return false
        if (if (from != null) from != that.from else that.from != null) return false
        if (if (location != null) location != that.location else that.location != null) return false
        if (if (query != null) query != that.query else that.query != null) return false
        return if (offset != null) offset == that.offset else that.offset == null

    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }

    override fun toString(): String {
        return "InlineQuery{" +
                "id='" + id + '\''.toString() +
                ", from=" + from +
                ", location=" + location +
                ", query='" + query + '\''.toString() +
                ", offset='" + offset + '\''.toString() +
                '}'.toString()
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}
