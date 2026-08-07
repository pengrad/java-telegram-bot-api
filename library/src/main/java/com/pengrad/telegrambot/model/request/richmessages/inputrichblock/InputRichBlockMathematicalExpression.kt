package com.pengrad.telegrambot.model.request.richmessages.inputrichblock

import com.pengrad.telegrambot.model.richmessages.richblock.RichBlockType

data class InputRichBlockMathematicalExpression(
    @get:JvmName("expression") val expression: String
) : InputRichBlock {
    override val type: String get() = RichBlockType.MATHEMATICAL_EXPRESSION
}
