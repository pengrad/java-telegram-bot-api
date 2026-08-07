package com.pengrad.telegrambot.utility.kotlin.extension.request

import com.pengrad.telegrambot.TelegramAware
import com.pengrad.telegrambot.model.request.richmessages.InputRichMessage
import com.pengrad.telegrambot.request.richmessages.SendRichMessageDraft
import com.pengrad.telegrambot.utility.kotlin.extension.execute

inline fun TelegramAware.sendRichMessageDraft(
    chatId: Long,
    draftId: Int,
    richMessage: InputRichMessage,
    modifier: SendRichMessageDraft.() -> Unit = {}
) = this.execute(SendRichMessageDraft(
    chatId = chatId,
    draftId = draftId,
    richMessage = richMessage
), modifier)
