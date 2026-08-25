package com.pengrad.telegrambot.model.richmessages

import com.pengrad.telegrambot.model.WebAppInfo
import com.pengrad.telegrambot.model.request.CopyTextButton
import com.pengrad.telegrambot.model.request.DisabledButton
import com.pengrad.telegrambot.model.request.LoginUrl
import com.pengrad.telegrambot.model.request.SwitchInlineQueryChosenChat
import com.pengrad.telegrambot.model.richmessages.richtext.RichText

data class RichMessageButton @JvmOverloads constructor(
    @get:JvmName("text") val text: RichText,
    @get:JvmName("style") var style: String? = null,
    @get:JvmName("url") var url: String? = null,
    @get:JvmName("callbackData") var callbackData: String? = null,
    @get:JvmName("webApp") var webApp: WebAppInfo? = null,
    @get:JvmName("loginUrl") var loginUrl: LoginUrl? = null,
    @get:JvmName("switchInlineQuery") var switchInlineQuery: String? = null,
    @get:JvmName("switchInlineQueryCurrentChat") var switchInlineQueryCurrentChat: String? = null,
    @get:JvmName("switchInlineQueryChosenChat") var switchInlineQueryChosenChat: SwitchInlineQueryChosenChat? = null,
    @get:JvmName("copyText") var copyText: CopyTextButton? = null,
    @get:JvmName("disabled") var disabled: DisabledButton? = null
) {

    fun style(style: String): RichMessageButton {
        this.style = style
        return this
    }

    fun url(url: String): RichMessageButton {
        this.url = url
        return this
    }

    fun callbackData(callbackData: String): RichMessageButton {
        this.callbackData = callbackData
        return this
    }

    fun webApp(webApp: WebAppInfo): RichMessageButton {
        this.webApp = webApp
        return this
    }

    fun loginUrl(loginUrl: LoginUrl): RichMessageButton {
        this.loginUrl = loginUrl
        return this
    }

    fun switchInlineQuery(switchInlineQuery: String): RichMessageButton {
        this.switchInlineQuery = switchInlineQuery
        return this
    }

    fun switchInlineQueryCurrentChat(switchInlineQueryCurrentChat: String): RichMessageButton {
        this.switchInlineQueryCurrentChat = switchInlineQueryCurrentChat
        return this
    }

    fun switchInlineQueryChosenChat(switchInlineQueryChosenChat: SwitchInlineQueryChosenChat): RichMessageButton {
        this.switchInlineQueryChosenChat = switchInlineQueryChosenChat
        return this
    }

    fun copyText(text: String): RichMessageButton {
        return copyText(CopyTextButton(text))
    }

    fun copyText(copyText: CopyTextButton): RichMessageButton {
        this.copyText = copyText
        return this
    }

    fun disabled(): RichMessageButton {
        this.disabled = DisabledButton()
        return this
    }
}
