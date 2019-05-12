package com.pengrad.telegrambot.model.request

import com.google.gson.Gson

import java.io.Serializable

/**
 * stas
 * 8/11/15
 */
abstract class Keyboard : Serializable {

    override fun toString(): String {
        return gson.toJson(this)
    }

    companion object {
        private const val serialVersionUID = 0L

        // todo remove gson
        private val gson = Gson()
    }

}
