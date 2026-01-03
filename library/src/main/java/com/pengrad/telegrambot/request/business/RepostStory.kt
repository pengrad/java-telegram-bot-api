package com.pengrad.telegrambot.request.business

import com.pengrad.telegrambot.request.KBaseRequest
import com.pengrad.telegrambot.response.RepostStoryResponse
import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter
import com.pengrad.telegrambot.utility.kotlin.requestParameter

@Suppress("unused")
class RepostStory private constructor(
    businessConnectionId: String,
    fromChatId: Long,
    fromStoryId: Int,
    activePeriod: Int,
    postToChatPage: Boolean?,
    protectContent: Boolean?
): KBaseRequest<RepostStory, RepostStoryResponse>(RepostStoryResponse::class) {

    constructor(businessConnectionId: String, fromChatId: Long, fromStoryId: Int, activePeriod: Int) : this(
        businessConnectionId = businessConnectionId,
        fromChatId = fromChatId,
        fromStoryId = fromStoryId,
        activePeriod = activePeriod,
        postToChatPage = null,
        protectContent = null
    )

    val businessConnectionId: String by requestParameter(businessConnectionId, customParameterName = "business_connection_id")
    val fromChatId: Long by requestParameter(fromChatId, customParameterName = "from_chat_id")
    val fromStoryId: Int by requestParameter(fromStoryId, customParameterName = "from_story_id")
    val activePeriod: Int by requestParameter(activePeriod, customParameterName = "active_period")

    var postToChatPage: Boolean? by optionalRequestParameter(postToChatPage, customParameterName = "post_to_chat_page")
    fun postToChatPage(postToChatPage: Boolean) = applySelf { this.postToChatPage = postToChatPage }

    var protectContent: Boolean? by optionalRequestParameter(protectContent, customParameterName = "protect_content")
    fun protectContent(protectContent: Boolean) = applySelf { this.protectContent = protectContent }

}
