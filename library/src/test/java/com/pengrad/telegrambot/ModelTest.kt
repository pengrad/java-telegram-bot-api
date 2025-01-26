package com.pengrad.telegrambot

import com.pengrad.telegrambot.model.*
import com.pengrad.telegrambot.model.botcommandscope.BotCommandScope
import com.pengrad.telegrambot.model.chatbackground.BackgroundTypeWallpaper
import com.pengrad.telegrambot.model.message.MaybeInaccessibleMessage
import com.pengrad.telegrambot.model.request.InlineKeyboardButton
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup
import com.pengrad.telegrambot.model.request.ParseMode
import com.pengrad.telegrambot.passport.Credentials
import com.pengrad.telegrambot.passport.decrypt.Decrypt
import nl.jqno.equalsverifier.EqualsVerifier
import nl.jqno.equalsverifier.Warning
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.reflections.Reflections
import org.reflections.scanners.SubTypesScanner
import sun.misc.Unsafe
import java.lang.reflect.Modifier
import java.util.*

/**
 * Stas Parshin
 * 31 May 2017
 */
class ModelTest {

    private var classes = mutableSetOf<Class<*>>()
    private val customInstance = mutableMapOf<Class<*>, () -> Any>()

    @Before
    fun setClasses() {
        val modelPackage = Animation::class.java.getPackage().name
        val passportPackage = Credentials::class.java.getPackage().name
        val packages = listOf(modelPackage, passportPackage)
        val excludedPackages = listOf(
            ParseMode::class,
            BotCommandScope::class,
            Decrypt::class
        ).map { it.java.`package`.name }

        classes.addAll(Reflections(packages, SubTypesScanner(false))
            .getSubTypesOf(Any::class.java)
            .filter {
                !excludedPackages.contains(it.getPackage().name)
                        && !it.simpleName.startsWith("PassportElementError")
                        && !Modifier.isAbstract(it.modifiers)
                        && it.kotlin.objectInstance == null
            })

        // classes from model/request available in responses
        classes.add(InlineKeyboardMarkup::class.java)
        classes.add(InlineKeyboardButton::class.java)

        customInstance[BackgroundTypeWallpaper::class.java] = { BackgroundTypeWallpaper(Document(), 1) }
    }

    @Test
    @Throws(ReflectiveOperationException::class)
    fun testEquals() {
        val prefabs = listOf<Any>(
            CallbackQuery().apply {
                javaClass.getDeclaredField("id").apply { isAccessible = true }.set(this, "2")
            },
            Message().apply {
                MaybeInaccessibleMessage::class.java.getDeclaredField("message_id").apply { isAccessible = true }
                    .set(this, 11)
            },
            Update().apply {
                javaClass.getDeclaredField("update_id").apply { isAccessible = true }.set(this, 1)
            },
            Chat().apply {
                javaClass.getDeclaredField("id").apply { isAccessible = true }.set(this, 1L)
            }
        )

        for (c in classes) {
            val verifierApi = EqualsVerifier.forClass(c)
                .usingGetClass()
                .suppress(Warning.STRICT_HASHCODE)
                .suppress(Warning.NONFINAL_FIELDS)

            prefabs.forEach {
                verifierApi.withPrefabValues(it.javaClass, it.javaClass.getDeclaredConstructor().newInstance(), it)
            }

            if (c == Message::class.java) {
                verifierApi.withIgnoredFields("video_chat_started")
                verifierApi.withIgnoredFields("forum_topic_closed")
                verifierApi.withIgnoredFields("forum_topic_reopened")
                verifierApi.withIgnoredFields("general_forum_topic_hidden")
                verifierApi.withIgnoredFields("general_forum_topic_unhidden")
            }

            verifierApi.verify()
        }
    }

    @Test
    @Throws(Exception::class)
    fun testToString() {
        for (c in classes) {
            val instance = customInstance[c]?.invoke() ?: defaultInstance(c)
            val toString = instance.toString()
            for (f in c.declaredFields) {
                if (Modifier.isStatic(f.modifiers)) {
                    continue
                }
                Assert.assertTrue(c.simpleName + " toString doesn't contain " + f.name, toString.contains(f.name))
            }
        }
    }

    private fun <R> defaultInstance(c: Class<R>): R {
        try {
            return c.getDeclaredConstructor().apply { isAccessible = true }.newInstance()
        } catch (e: Exception) {
            val unsafeClass = Class.forName("sun.misc.Unsafe")
            val unsafe = unsafeClass.getDeclaredField("theUnsafe").apply { isAccessible = true }.get(null) as Unsafe
            @Suppress("UNCHECKED_CAST")
            return unsafe.allocateInstance(c) as R
        }
    }
}
