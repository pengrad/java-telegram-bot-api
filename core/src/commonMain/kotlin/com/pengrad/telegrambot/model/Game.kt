package com.pengrad.telegrambot.model

import java.io.Serializable
import java.util.Arrays

/**
 * Stas Parshin
 * 03 October 2016
 */
class Game : Serializable {

    private val title: String? = null
    private val description: String? = null
    private val photo: Array<PhotoSize>? = null

    private val text: String? = null
    private val text_entities: Array<MessageEntity>? = null
    private val animation: Animation? = null

    fun title(): String? {
        return title
    }

    fun description(): String? {
        return description
    }

    fun photo(): Array<PhotoSize>? {
        return photo
    }

    fun text(): String? {
        return text
    }

    fun textEntities(): Array<MessageEntity>? {
        return text_entities
    }

    fun animation(): Animation? {
        return animation
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val game = o as Game?

        if (if (title != null) title != game!!.title else game!!.title != null) return false
        if (if (description != null) description != game.description else game.description != null) return false
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(photo, game.photo)) return false
        if (if (text != null) text != game.text else game.text != null) return false
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(text_entities, game.text_entities)) return false
        return if (animation != null) animation == game.animation else game.animation == null
    }

    override fun hashCode(): Int {
        var result = title?.hashCode() ?: 0
        result = 31 * result + (description?.hashCode() ?: 0)
        result = 31 * result + Arrays.hashCode(photo)
        result = 31 * result + (text?.hashCode() ?: 0)
        result = 31 * result + Arrays.hashCode(text_entities)
        result = 31 * result + (animation?.hashCode() ?: 0)
        return result
    }

    override fun toString(): String {
        return "Game{" +
                "title='" + title + '\''.toString() +
                ", description='" + description + '\''.toString() +
                ", photo=" + Arrays.toString(photo) +
                ", text='" + text + '\''.toString() +
                ", text_entities=" + Arrays.toString(text_entities) +
                ", animation=" + animation +
                '}'.toString()
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}
