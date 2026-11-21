package com.pengrad.telegrambot.model.widget

data class WidgetQueryTypeUnknown(
    override val type: String = WidgetQueryType.UNKNOWN
) : WidgetQueryType
