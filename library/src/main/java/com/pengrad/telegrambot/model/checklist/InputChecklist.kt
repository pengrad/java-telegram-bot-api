package com.pengrad.telegrambot.model.checklist

import com.pengrad.telegrambot.model.MessageEntity

@Suppress("unused")
class InputChecklist private constructor(
    @get:JvmName("title") val title: String,
    @get:JvmName("parseMode") var parseMode: String?,
    @get:JvmName("titleEntities") var titleEntities: Array<MessageEntity>?,
    @get:JvmName("tasks") val tasks: Array<InputChecklistTask>,
    @get:JvmName("othersCanAddTasks") var othersCanAddTasks: Boolean?,
    @get:JvmName("othersCanMarkTasksAsDone") var othersCanMarkTasksAsDone: Boolean?,
) {

    constructor(title: String, tasks: Array<InputChecklistTask>) : this(
        title = title,
        tasks = tasks,
        parseMode = null,
        titleEntities = null,
        othersCanAddTasks = null,
        othersCanMarkTasksAsDone = null
    )

    fun parseMode(parseMode: String) = apply {
        this.parseMode = parseMode
    }

    fun titleEntities(titleEntities: Array<MessageEntity>) = apply {
        this.titleEntities = titleEntities
    }

    fun othersCanAddTasks(othersCanAddTasks: Boolean) = apply {
        this.othersCanAddTasks = othersCanAddTasks
    }

    fun othersCanMarkTasksAsDone(othersCanMarkTasksAsDone: Boolean) = apply {
        this.othersCanMarkTasksAsDone = othersCanMarkTasksAsDone
    }

}