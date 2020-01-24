package com.pengrad.telegrambot.model

import com.google.gson.Gson

import java.io.Serializable

/**
 * Stas Parshin
 * 23 July 2017
 */
data class MaskPosition(
        private val point: String,
        private val x_shift: Float,
        private val y_shift: Float,
        private val scale: Float
) : Serializable {

    enum class Point {
        forehead, eyes, mouth, chin
    }

    constructor(point: Point, x_shift: Float, y_shift: Float, scale: Float) : this(point.name, x_shift, y_shift, scale)

    fun point(): String {
        return point
    }

    fun xShift(): Float {
        return x_shift
    }

    fun yShift(): Float {
        return y_shift
    }

    fun scale(): Float {
        return scale
    }

    companion object {
        private const val serialVersionUID = 0L
        private val gson = Gson()
    }
}
