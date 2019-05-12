package com.pengrad.telegrambot.model

import java.io.Serializable
import java.util.Arrays

/**
 * stas
 * 8/5/15.
 */
class UserProfilePhotos : Serializable {

    private val total_count: Int? = null
    private val photos: Array<Array<PhotoSize>>? = null

    fun totalCount(): Int? {
        return total_count
    }

    fun photos(): Array<Array<PhotoSize>>? {
        return photos
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val that = o as UserProfilePhotos?

        return if (if (total_count != null) total_count != that!!.total_count else that!!.total_count != null) false else Arrays.deepEquals(photos, that.photos)
    }

    override fun hashCode(): Int {
        var result = total_count?.hashCode() ?: 0
        result = 31 * result + Arrays.deepHashCode(photos)
        return result
    }

    override fun toString(): String {
        return "UserProfilePhotos{" +
                "total_count=" + total_count +
                ", photos=" + Arrays.deepToString(photos) +
                '}'.toString()
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}
