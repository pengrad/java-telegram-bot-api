package com.pengrad.telegrambot.model.richmessages.richtext

data class RichTextMathematicalExpression @JvmOverloads constructor(
    @get:JvmName("expression") val expression: String,
    override val type: String = RichTextType.MATHEMATICAL_EXPRESSION
) : RichText
