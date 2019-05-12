package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * Stas Parshin
 * 04 October 2016
 */
class GameHighScore : Serializable {

    private val position: Int? = null
    private val user: User? = null
    private val score: Int? = null

    fun position(): Int? {
        return position
    }

    fun user(): User? {
        return user
    }

    fun score(): Int? {
        return score
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val that = o as GameHighScore?

        if (if (position != null) position != that!!.position else that!!.position != null) return false
        if (if (user != null) user != that.user else that.user != null) return false
        return if (score != null) score == that.score else that.score == null
    }

    override fun hashCode(): Int {
        var result = position?.hashCode() ?: 0
        result = 31 * result + (user?.hashCode() ?: 0)
        result = 31 * result + (score?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "GameHighScore{" +
                "position=" + position +
                ", user=" + user +
                ", score=" + score +
                '}'.toString()
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}
