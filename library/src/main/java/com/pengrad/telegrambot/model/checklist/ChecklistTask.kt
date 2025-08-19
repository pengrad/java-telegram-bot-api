package com.pengrad.telegrambot.model.checklist

import com.pengrad.telegrambot.model.MessageEntity
import com.pengrad.telegrambot.model.User
import com.pengrad.telegrambot.model.gift.GiftInfo

data class ChecklistTask(

    @get:JvmName("id") val id: Int,
    @get:JvmName("text") val text: String,
    @get:JvmName("textEntities") var textEntities: Array<MessageEntity>?,
    @get:JvmName("completedByUser") val completedByUser: User?,
    @get:JvmName("completionDate") val completionDate: Int?

) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ChecklistTask) return false

        return id == other.id &&
                text == other.text &&
                textEntities contentEquals other.textEntities &&
                completedByUser == other.completedByUser &&
                completionDate == other.completionDate
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + (text?.hashCode() ?: 0)
        result = 31 * result + (textEntities?.contentHashCode() ?: 0)
        result = 31 * result + (completedByUser?.hashCode() ?: 0)
        result = 31 * result + (completionDate?.hashCode() ?: 0)
        return result
    }

}