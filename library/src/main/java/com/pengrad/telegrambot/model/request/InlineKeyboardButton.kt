package com.pengrad.telegrambot.model.request

import com.pengrad.telegrambot.model.WebAppInfo

/**
 * Stas Parshin
 * 06 May 2016
 */
data class InlineKeyboardButton @JvmOverloads constructor(
    @get:JvmName("text") var text: String? = null,
    @get:JvmName("url") var url: String? = null,
    @get:JvmName("loginUrl") var loginUrl: LoginUrl? = null,
    @get:JvmName("callbackData") var callbackData: String? = null,
    @get:JvmName("switchInlineQuery") var switchInlineQuery: String? = null,
    @get:JvmName("switchInlineQueryCurrentChat") var switchInlineQueryCurrentChat: String? = null,
    @get:JvmName("switchInlineQueryChosenChat") var switchInlineQueryChosenChat: SwitchInlineQueryChosenChat? = null,
    @get:JvmName("callbackGame") var callbackGame: CallbackGame? = null,
    var pay: Boolean? = null,
    @get:JvmName("webApp") var webApp: WebAppInfo? = null,
    @get:JvmName("copyText") var copyText: CopyTextButton? = null,
) {

    fun url(url: String): InlineKeyboardButton {
        this.url = url
        return this
    }

    fun loginUrl(loginUrl: LoginUrl): InlineKeyboardButton {
        this.loginUrl = loginUrl
        return this
    }

    fun callbackData(callbackData: String): InlineKeyboardButton {
        this.callbackData = callbackData
        return this
    }

    fun switchInlineQuery(switchInlineQuery: String): InlineKeyboardButton {
        this.switchInlineQuery = switchInlineQuery
        return this
    }

    fun switchInlineQueryCurrentChat(switchInlineQueryCurrentChat: String): InlineKeyboardButton {
        this.switchInlineQueryCurrentChat = switchInlineQueryCurrentChat
        return this
    }

    fun switchInlineQueryChosenChat(switchInlineQueryChosenChat: SwitchInlineQueryChosenChat): InlineKeyboardButton {
        this.switchInlineQueryChosenChat = switchInlineQueryChosenChat
        return this
    }

    @Suppress("UNUSED_PARAMETER")
    fun callbackGame(callbackGame: String): InlineKeyboardButton {
        this.callbackGame = CallbackGame
        return this
    }

    fun pay(): InlineKeyboardButton {
        this.pay = true
        return this
    }

    fun webApp(webApp: WebAppInfo): InlineKeyboardButton {
        this.webApp = webApp
        return this
    }

    fun copyText(text: String): InlineKeyboardButton {
        return copyText(CopyTextButton(text))
    }

    fun copyText(copyText: CopyTextButton): InlineKeyboardButton {
        this.copyText = copyText
        return this
    }

    fun isPay(): Boolean {
        return pay ?: false
    }
}
