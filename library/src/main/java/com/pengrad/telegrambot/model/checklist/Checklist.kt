package com.pengrad.telegrambot.model.checklist

import com.pengrad.telegrambot.model.MessageEntity
import com.pengrad.telegrambot.model.User
import com.pengrad.telegrambot.model.gift.GiftInfo

data class Checklist(

    @get:JvmName("title") val title: String,
    @get:JvmName("titleEntities") val titleEntities: Array<MessageEntity>?,
    @get:JvmName("tasks") val tasks: Array<ChecklistTask>,
    @get:JvmName("othersCanAddTasks") val othersCanAddTasks: Boolean?,
    @get:JvmName("othersCanMarkTasksAsDone") val othersCanMarkTasksAsDone: Boolean?
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Checklist) return false

        return title == other.title &&
                titleEntities contentEquals other.titleEntities &&
                tasks contentEquals other.tasks &&
                othersCanAddTasks == other.othersCanAddTasks &&
                othersCanMarkTasksAsDone == other.othersCanMarkTasksAsDone
    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + (titleEntities?.contentHashCode() ?: 0)
        result = 31 * result + (tasks?.contentHashCode() ?: 0)
        result = 31 * result + (othersCanAddTasks?.hashCode() ?: 0)
        result = 31 * result + (othersCanMarkTasksAsDone?.hashCode() ?: 0)
        return result
    }

}