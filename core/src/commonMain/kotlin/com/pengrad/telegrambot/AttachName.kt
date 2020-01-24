package com.pengrad.telegrambot

import java.util.concurrent.atomic.AtomicInteger

/**
 * Stas Parshin
 * 29 July 2018
 */
object AttachName {

    private val counter = AtomicInteger()

    operator fun next(): String {
        return "attach" + counter.incrementAndGet()
    }

}
