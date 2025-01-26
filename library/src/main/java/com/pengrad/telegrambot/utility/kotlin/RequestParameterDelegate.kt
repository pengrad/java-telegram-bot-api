package com.pengrad.telegrambot.utility.kotlin

import com.pengrad.telegrambot.request.KBaseRequest
import kotlin.properties.PropertyDelegateProvider
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

typealias RequestParameterValueMapper<I, O> = (I) -> O

fun <T : KBaseRequest<*, *>, V : Any> requestParameter(
    initialValue: V,
    customParameterName: String? = null
) : RequestParameterDelegate<T, V> = RequestParameterDelegate(
    value = initialValue,
    customParameterName = customParameterName
)

fun <T : KBaseRequest<*, *>, V : Any?> optionalRequestParameter(
    initialValue: V? = null,
    customParameterName: String? = null,
    valueMapper: RequestParameterValueMapper<V?, Any?>? = null
) : RequestParameterDelegate<T, V?> = RequestParameterDelegate(
    value = initialValue,
    customParameterName = customParameterName,
    valueMapper = valueMapper
)

class RequestParameterDelegate<T : KBaseRequest<*, *>, V>(
    private var value: V,
    private val customParameterName: String? = null,
    private val valueMapper: RequestParameterValueMapper<V, Any?>? = null
) : ReadWriteProperty<T, V>, PropertyDelegateProvider<T, RequestParameterDelegate<T, V>> {

    override operator fun provideDelegate(thisRef: T, property: KProperty<*>): RequestParameterDelegate<T, V> {
        if (value != null) {
            updateRequestValue(thisRef, property, value)
        }
        return this
    }

    override operator fun getValue(thisRef: T, property: KProperty<*>): V {
        return value
    }

    override operator fun setValue(thisRef: T, property: KProperty<*>, value: V) {
        updateRequestValue(thisRef, property, value)
        this.value = value
    }

    private fun updateRequestValue(thisRef: T, property: KProperty<*>, value: V) {
        thisRef.addParameter(
            name = customParameterName ?: convertToSnakeCase(property.name),
            value = valueMapper?.invoke(value) ?: value
        )
    }

}

fun convertToSnakeCase(input: String): String {
    return input.replace(Regex("([a-z])([A-Z])")) {
        "${it.groupValues[1]}_${it.groupValues[2]}"
    }.lowercase()
}