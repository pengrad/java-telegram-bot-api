package com.pengrad.telegrambot.model.checklist

import com.pengrad.telegrambot.model.Message

data class ChecklistTasksDone (

    @get:JvmName("checklistMessage") val checklistMessage: Message?,
    @get:JvmName("markedAsDoneTaskIds") val markedAsDoneTaskIds: Array<Int>?,
    @get:JvmName("markedAsNotDoneTaskIds") val markedAsNotDoneTaskIds: Array<Int>?

){

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ChecklistTasksDone) return false

        return checklistMessage == other.checklistMessage &&
                markedAsDoneTaskIds contentEquals other.markedAsDoneTaskIds &&
                markedAsNotDoneTaskIds contentEquals other.markedAsNotDoneTaskIds
    }

    override fun hashCode(): Int {
        var result = checklistMessage.hashCode()
        result = 31 * result + (markedAsDoneTaskIds.contentHashCode())
        result = 31 * result + (markedAsNotDoneTaskIds.contentHashCode())
        return result
    }

}