package com.pengrad.telegrambot.model

import com.google.gson.Gson
import com.pengrad.telegrambot.impl.SerialName
import java.io.Serializable

/**
 * Stas Parshin
 * 23 July 2017
 */
data class MaskPosition(
        @get:JvmName("point") var point: String? = null,
        @get:JvmName("xShift") @SerialName("x_shift") var xShift: Float? = null,
        @get:JvmName("yShift") @SerialName("y_shift") var yShift: Float? = null,
        @get:JvmName("scale") var scale: Float? = null
) : Serializable {

    enum class Point {
        forehead, eyes, mouth, chin
    }

    constructor(point: Point, xShift: Float?, yShift: Float?, scale: Float?) : this(point.name, xShift, yShift, scale)

    companion object {
        private const val serialVersionUID = 0L
    }
}