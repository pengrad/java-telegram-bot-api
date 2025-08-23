package com.pengrad.telegrambot.model.checklist

import com.pengrad.telegrambot.model.Message

data class ChecklistTasksAdded (
    @get:JvmName("checklistMessage") val checklistMessage: Message?,
    @get:JvmName("tasks") val tasks: Array<ChecklistTask>?
){

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ChecklistTasksAdded) return false

        return checklistMessage == other.checklistMessage &&
                tasks contentEquals other.tasks
    }

    override fun hashCode(): Int {
        var result = checklistMessage.hashCode()
        result = 31 * result + (tasks?.hashCode() ?: 0)
        return result
    }

}