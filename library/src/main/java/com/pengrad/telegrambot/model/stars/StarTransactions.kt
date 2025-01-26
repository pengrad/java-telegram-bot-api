package com.pengrad.telegrambot.model.stars

data class StarTransactions(
    @get:JvmName("transactions") val transactions: Array<StarTransaction>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is StarTransactions) return false

        if (!transactions.contentEquals(other.transactions)) return false

        return true
    }

    override fun hashCode(): Int {
        return transactions.contentHashCode()
    }
}
