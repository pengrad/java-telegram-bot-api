package com.pengrad.telegrambot.request.business

import com.pengrad.telegrambot.model.MessageEntity
import com.pengrad.telegrambot.model.story.StoryArea
import com.pengrad.telegrambot.model.story.inputstory.InputStoryContent
import com.pengrad.telegrambot.request.KBaseRequest
import com.pengrad.telegrambot.response.PostStoryResponse
import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter
import com.pengrad.telegrambot.utility.kotlin.requestParameter

@Suppress("unused")
class PostStory private constructor(
    businessConnectionId: String,
    content: InputStoryContent,
    activePeriod: Int,
    caption: String?,
    parseMode: String?,
    captionEntities: Array<MessageEntity>?,
    areas: Array<StoryArea>?,
    postToChatPage: Boolean?,
    protectContent: Boolean?
): KBaseRequest<PostStory, PostStoryResponse>(PostStoryResponse::class) {

    constructor(businessConnectionId: String, content: InputStoryContent, activePeriod: Int) : this(
        businessConnectionId = businessConnectionId,
        content = content,
        activePeriod = activePeriod,
        caption = null,
        parseMode = null,
        captionEntities = null,
        areas = null,
        postToChatPage = null,
        protectContent = null
    )

    val businessConnectionId: String by requestParameter(businessConnectionId, customParameterName = "business_connection_id")
    val content: InputStoryContent by requestParameter(content, customParameterName = "content")
    val activePeriod: Int by requestParameter(activePeriod, customParameterName = "active_period")

    var caption: String? by optionalRequestParameter(caption, customParameterName = "caption")
    fun caption(caption: String) = applySelf { this.caption = caption }

    var parseMode: String? by optionalRequestParameter(parseMode, customParameterName = "parse_mode")
    fun parseMode(parseMode: String) = applySelf { this.parseMode = parseMode }

    var captionEntities: Array<MessageEntity>? by optionalRequestParameter(captionEntities, customParameterName = "caption_entities")
    fun captionEntities(captionEntities: Array<MessageEntity>) = applySelf { this.captionEntities = captionEntities }

    var areas: Array<StoryArea>? by optionalRequestParameter(areas, customParameterName = "areas")
    fun areas(areas: Array<StoryArea>) = applySelf { this.areas = areas }

    var postToChatPage: Boolean? by optionalRequestParameter(postToChatPage, customParameterName = "post_to_chat_page")
    fun postToChatPage(postToChatPage: Boolean) = applySelf { this.postToChatPage = postToChatPage }

    var protectContent: Boolean? by optionalRequestParameter(protectContent, customParameterName = "protect_content")
    fun protectContent(protectContent: Boolean) = applySelf { this.protectContent = protectContent }

}