package com.pengrad.telegrambot

import com.pengrad.telegrambot.model.chatsharetheme.ChatShareThemeEmoji
import com.pengrad.telegrambot.model.chatsharetheme.EmojiTypeCustomEmoji
import com.pengrad.telegrambot.model.chatsharetheme.EmojiTypeEmoji
import com.pengrad.telegrambot.model.ephemeral.EphemeralMessageParameters
import com.pengrad.telegrambot.model.request.ReplyParameters
import com.pengrad.telegrambot.model.richmessages.richtext.RichTextPlain
import com.pengrad.telegrambot.model.widget.WidgetQueryTypeData
import com.pengrad.telegrambot.model.widget.WidgetQueryTypeSentTransaction
import com.pengrad.telegrambot.model.widget.WidgetQueryTypeUnknown
import com.pengrad.telegrambot.request.SendMessage
import com.pengrad.telegrambot.request.widget.AnswerWidgetQuery
import com.pengrad.telegrambot.request.widget.EditMessageWidgetData
import com.pengrad.telegrambot.request.widget.EditSharedWidgetData
import com.pengrad.telegrambot.request.widget.SendWidget
import com.pengrad.telegrambot.utility.BotUtils
import org.junit.Assert.*
import org.junit.Test

class BotApi104Test {

    @Test
    fun widgetQueryUpdate() {
        val u = BotUtils.parseUpdate(
            """{"update_id":1,"widget_query":{"id":"q","from":{"id":5,"is_bot":false,"first_name":"A"},
            "chat_instance":"ci","type":{"type":"data"},"data":"go","widget_id":"w"},
            "shared_widget_query":{"id":"s","from":{"id":5,"is_bot":false,"first_name":"A"},
            "type":{"type":"sent_transaction","wallet":{"address":"a","amount":"1"},"msg_hash":"h"},"data":"d","widget_id":"w"}}"""
        )
        assertTrue(u.widgetQuery().type is WidgetQueryTypeData)
        assertEquals("go", u.widgetQuery().data)
        val t = u.sharedWidgetQuery().type as WidgetQueryTypeSentTransaction
        assertEquals("h", t.msgHash)
    }

    @Test
    fun unknownWidgetQueryType() {
        val u = BotUtils.parseUpdate(
            """{"update_id":1,"widget_query":{"id":"q","from":{"id":5,"is_bot":false,"first_name":"A"},
            "chat_instance":"ci","type":{"type":"future"},"data":"go"}}"""
        )
        assertTrue(u.widgetQuery().type is WidgetQueryTypeUnknown)
    }

    @Test
    fun messageFields() {
        val u = BotUtils.parseUpdate(
            """{"update_id":1,"message":{"message_id":1,"date":1,"chat":{"id":1,"type":"private"},
            "widget":{"html":"<b>x</b>","public_data":"p"},
            "ton_wallet_transfer":{"transaction_id":"t","peer_address":"a","amount":"-5"},
            "paid_messages_waived":{}}}"""
        )
        val m = u.message()
        assertEquals("<b>x</b>", m.widget().html)
        assertEquals("p", m.widget().publicData)
        assertEquals("-5", m.tonWalletTransfer().amount)
        assertNotNull(m.paidMessagesWaived())
    }

    @Test
    fun shareThemeAndTonCard() {
        val chat = BotUtils.fromJson(
            """{"id":1,"type":"private","ton_wallet_card":{"address":"a","amount":"1","stickers":[
            {"position":{"x_percentage":1.0,"y_percentage":2.0,"width_percentage":3.0,"height_percentage":4.0,
            "rotation_angle":5.0,"corner_radius_percentage":6.0},"nft":{"address":"n","index":"1","name":"nm","description":"d"}}]},
            "share_theme":{"type":"emoji","emojis":[{"type":"emoji","emoji":"x"},{"type":"custom_emoji","custom_emoji_id":"c"}],
            "background_backdrop_id":7}}""",
            com.pengrad.telegrambot.model.ChatFullInfo::class.java
        )
        assertEquals(1, chat.tonWalletCard().stickers.size)
        assertEquals(2.0, chat.tonWalletCard().stickers[0].position.yPercentage, 0.0)
        val theme = chat.shareTheme() as ChatShareThemeEmoji
        assertEquals(EmojiTypeEmoji("x"), theme.emojis[0])
        assertEquals(EmojiTypeCustomEmoji("c"), theme.emojis[1])
        assertEquals(7L, theme.backgroundBackdropId)
    }

    @Test
    fun quoteRichTexts() {
        val q = BotUtils.fromJson(
            """{"text":"","rich_texts":["a",{"type":"ton_address","text":"b","address":"UQ"}],"position":0}""",
            com.pengrad.telegrambot.model.TextQuote::class.java
        )
        assertEquals(2, q.richTexts().size)
        val json = BotUtils.toJson(ReplyParameters(1).quoteRichTexts(RichTextPlain("a")))
        assertTrue(json, json.contains("quote_rich_texts"))
    }

    @Test
    fun requestParameters() {
        val w = SendWidget(1L, "<p/>").width(300).isShared(true).allowQueries(true)
        assertEquals(1L, w.parameters["chat_id"])
        assertEquals("<p/>", w.parameters["html"])
        assertEquals(true, w.parameters["is_shared"])
        assertEquals("d", AnswerWidgetQuery("q").data("d").parameters["data"])
        assertEquals("i", EditMessageWidgetData("i").parameters["inline_message_id"])
        assertEquals(10, EditSharedWidgetData("w", "p").cacheTime(10).parameters["cache_time"])
    }

    @Test
    fun ephemeralReplyWithoutChat() {
        val r = SendMessage("hi").ephemeralMessageParameters(EphemeralMessageParameters.replyToCallbackQuery("cb"))
        assertFalse(r.parameters.containsKey("chat_id"))
        val p = r.parameters["ephemeral_message_parameters"] as EphemeralMessageParameters
        assertNull(p.receiverUserId)
        assertEquals("cb", p.callbackQueryId)
    }
}
