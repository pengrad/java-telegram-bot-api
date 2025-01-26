package com.pengrad.telegrambot.request

import com.pengrad.telegrambot.response.BaseResponse
import kotlin.reflect.KClass

abstract class KBaseRequest<T : BaseRequest<T, R>, R : BaseResponse>(
    clazz: KClass<R>
) : BaseRequest<T, R>(clazz.java) {

    internal fun addParameter(name: String, value: Any?): T {
        return add(name, value)
    }

}