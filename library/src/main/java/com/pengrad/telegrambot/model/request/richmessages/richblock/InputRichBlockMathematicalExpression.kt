package com.pengrad.telegrambot.model.request.richmessages.richblock

class InputRichBlockMathematicalExpression(
    @get:JvmName("expression") val expression: String
) : InputRichBlock {

    override val type: String = InputRichBlockType.MATHEMATICAL_EXPRESSION

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false
        other as InputRichBlockMathematicalExpression
        return type == other.type &&
                expression == other.expression
    }

    override fun hashCode(): Int {
        var result = type.hashCode()
        result = 31 * result + expression.hashCode()
        return result
    }

    override fun toString(): String =
        "InputRichBlockMathematicalExpression(type=$type, expression=$expression)"
}
