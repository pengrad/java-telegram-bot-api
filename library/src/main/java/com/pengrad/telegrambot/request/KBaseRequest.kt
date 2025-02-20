package com.pengrad.telegrambot.request

import com.pengrad.telegrambot.response.BaseResponse
import kotlin.reflect.KClass

abstract class KBaseRequest<T : BaseRequest<T, R>, R : BaseResponse>(
    clazz: KClass<R>
) : BaseRequest<T, R>(clazz.java) {

    @Suppress("UNCHECKED_CAST", "MemberVisibilityCanBePrivate")
    protected val self by lazy { this as T }

    internal fun addParameter(name: String, value: Any?): T {
        return add(name, value)
    }

    protected fun applySelf(block: T.() -> Unit): T =
        self.apply(block)

}