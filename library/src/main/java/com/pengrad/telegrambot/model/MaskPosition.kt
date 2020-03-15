package com.pengrad.telegrambot.model

import java.io.Serializable

/**
 * Stas Parshin
 * 23 July 2017
 */
data class MaskPosition(
        @get:JvmName("point") var point: String? = null,
        @get:JvmName("xShift") var x_shift: Float? = null,
        @get:JvmName("yShift") var y_shift: Float? = null,
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