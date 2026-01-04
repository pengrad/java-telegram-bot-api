package com.pengrad.telegrambot.model.checklist

import com.pengrad.telegrambot.model.MessageEntity

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

    override fun toString(): String {
        return "InputChecklist(title='$title', parseMode=$parseMode, titleEntities=${titleEntities?.contentToString()}, tasks=${tasks.contentToString()}, othersCanAddTasks=$othersCanAddTasks, othersCanMarkTasksAsDone=$othersCanMarkTasksAsDone)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as InputChecklist

        if (title != other.title) return false
        if (parseMode != other.parseMode) return false
        if (titleEntities != null) {
            if (other.titleEntities == null) return false
            if (!titleEntities.contentEquals(other.titleEntities)) return false
        } else if (other.titleEntities != null) return false
        if (!tasks.contentEquals(other.tasks)) return false
        if (othersCanAddTasks != other.othersCanAddTasks) return false
        if (othersCanMarkTasksAsDone != other.othersCanMarkTasksAsDone) return false

        return true
    }

    override fun hashCode(): Int {
        var result = title.hashCode()
        result = 31 * result + (parseMode?.hashCode() ?: 0)
        result = 31 * result + (titleEntities?.contentHashCode() ?: 0)
        result = 31 * result + tasks.contentHashCode()
        result = 31 * result + (othersCanAddTasks?.hashCode() ?: 0)
        result = 31 * result + (othersCanMarkTasksAsDone?.hashCode() ?: 0)
        return result
    }


}