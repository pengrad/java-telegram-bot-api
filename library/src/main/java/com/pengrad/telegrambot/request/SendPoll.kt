package com.pengrad.telegrambot.request

import com.pengrad.telegrambot.model.MessageEntity
import com.pengrad.telegrambot.model.Poll
import com.pengrad.telegrambot.model.request.InputPollOption
import com.pengrad.telegrambot.model.request.ParseMode
import com.pengrad.telegrambot.utility.kotlin.checkDeprecatedConstructorParameters
import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter
import com.pengrad.telegrambot.utility.kotlin.requestParameter

class SendPoll private constructor(
    chatId: Long? = null,
    channelUsername: String? = null,

    question: String,
    options: List<InputPollOption>
) : AbstractSendRequest<SendPoll>(
    chatId = chatId,
    channelUsername = channelUsername,
) {

    constructor(
        chatId: Long,
        question: String,
        options: List<InputPollOption>
    ) : this(
        chatId = chatId,
        channelUsername = null,
        question = question,
        options = options
    )

    constructor(
        channelUsername: String,
        question: String,
        options: List<InputPollOption>
    ) : this(
        chatId = null,
        channelUsername = channelUsername,
        question = question,
        options = options
    )

    @Deprecated("Use constructor with chatId or channelUsername instead", ReplaceWith("SendPoll(chatId, question, options)"))
    constructor(
        chatId: Any,
        question: String,
        vararg options: InputPollOption
    ) : this(
        chatId = (chatId as? Number)?.toLong(),
        channelUsername = chatId as? String,
        question = question,
        options = options.toList()
    ) {
        checkDeprecatedConstructorParameters()
    }

    val question: String by requestParameter(question)
    val options: List<InputPollOption> by requestParameter(options)

    var type: Poll.Type? by optionalRequestParameter()
    var typeRaw: String? by optionalRequestParameter(customParameterName = "type")

    var isAnonymous: Boolean? by optionalRequestParameter()
    var allowsMultipleAnswers: Boolean? by optionalRequestParameter()
    var correctOptionId: Int? by optionalRequestParameter()

    var questionParseMode: ParseMode? by optionalRequestParameter()
    var questionEntities: List<MessageEntity>? by optionalRequestParameter()

    var explanation: String? by optionalRequestParameter()
    var explanationParseMode: ParseMode? by optionalRequestParameter()
    var explanationEntities: List<MessageEntity>? by optionalRequestParameter()

    var openPeriod: Int? by optionalRequestParameter()
    var closeDate: Long? by optionalRequestParameter()
    var isClosed: Boolean? by optionalRequestParameter()

    fun type(type: Poll.Type) = applySelf { this.type = type }

    fun type(typeRaw: String) = applySelf { this.typeRaw = typeRaw }

    fun isAnonymous(isAnonymous: Boolean) = applySelf { this.isAnonymous = isAnonymous }

    fun allowsMultipleAnswers(allowMultipleAnswers: Boolean) = applySelf { this.allowsMultipleAnswers = allowMultipleAnswers }

    fun correctOptionId(correctOptionId: Int) = applySelf { this.correctOptionId = correctOptionId }

    fun questionParseMode(questionParseMode: ParseMode) = applySelf { this.questionParseMode = questionParseMode }

    fun questionEntities(questionEntities: List<MessageEntity>) = applySelf { this.questionEntities = questionEntities }

    fun questionEntities(vararg questionEntities: MessageEntity) = questionEntities(questionEntities.toList())

    fun explanation(explanation: String) = applySelf { this.explanation = explanation }

    fun explanationParseMode(explanationParseMode: ParseMode) = applySelf { this.explanationParseMode = explanationParseMode }

    fun explanationEntities(explanationEntities: List<MessageEntity>) = applySelf { this.explanationEntities = explanationEntities }

    fun explanationEntities(vararg explanationEntities: MessageEntity) = explanationEntities(explanationEntities.toList())

    fun openPeriod(openPeriod: Int) = applySelf { this.openPeriod = openPeriod }

    fun closeDate(closeDate: Long) = applySelf { this.closeDate = closeDate }

    fun isClosed(isClosed: Boolean) = applySelf { this.isClosed = isClosed }

}