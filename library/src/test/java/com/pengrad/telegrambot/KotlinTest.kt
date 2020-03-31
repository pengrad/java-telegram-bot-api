package com.pengrad.telegrambot

import com.pengrad.telegrambot.TelegramBotTest.bot
import com.pengrad.telegrambot.checks.UpdateTest
import com.pengrad.telegrambot.model.Message
import com.pengrad.telegrambot.request.GetUpdates
import com.pengrad.telegrambot.request.KickChatMember
import okhttp3.OkHttpClient
import okhttp3.Request
import org.junit.Assert
import org.junit.Test

/**
 * Stas Parshin
 * 15 March 2020
 */
class KotlinTest {

    // test full jar compatibility (to make sure kotlin-stdlib included)
    // java -cp hamcrest-core-1.3.jar:junit-4.12.jar:build/libs/java-telegram-bot-api-full.jar:build/classes/java/test/ org.junit.runner.JUnitCore  com.pengrad.telegrambot.PaymentsTest


    @Test
    fun a() {
        val getUpdates = GetUpdates()
                .offset(874203684)
                .allowedUpdates("")
                .timeout(0)
                .limit(100)
        Assert.assertEquals(100, getUpdates.limit.toLong())
        val response = TelegramBotTest.bot.execute(getUpdates)
        UpdateTest.check(response.updates())
        val m: Message? = response.updates()[0].message()

        bot.execute(KickChatMember().untilDate())


        val ok = OkHttpClient()
        ok.newCall(Request.Builder().build()).execute().body()?.
    }

}

private operator fun <T> T?.invoke(): T? {

    TODO("Not yet implemented")
}
