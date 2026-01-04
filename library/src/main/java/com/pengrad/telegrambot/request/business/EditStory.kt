package com.pengrad.telegrambot.request.business

import com.pengrad.telegrambot.model.MessageEntity
import com.pengrad.telegrambot.model.story.StoryArea
import com.pengrad.telegrambot.model.story.inputstory.InputStoryContent
import com.pengrad.telegrambot.request.KBaseRequest
import com.pengrad.telegrambot.response.EditStoryResponse
import com.pengrad.telegrambot.utility.kotlin.optionalRequestParameter
import com.pengrad.telegrambot.utility.kotlin.requestParameter

@Suppress("unused")
class EditStory private constructor(
    businessConnectionId: String,
    storyId: Long,
    content: InputStoryContent,
    caption: String?,
    parseMode: String?,
    captionEntities: Array<MessageEntity>?,
    areas: Array<StoryArea>?
): KBaseRequest<EditStory, EditStoryResponse>(EditStoryResponse::class) {

    constructor(businessConnectionId: String, storyId: Long, content: InputStoryContent) : this(
        businessConnectionId = businessConnectionId,
        storyId = storyId,
        content = content,
        caption = null,
        parseMode = null,
        captionEntities = null,
        areas = null
    )

    val businessConnectionId: String by requestParameter(businessConnectionId, customParameterName = "business_connection_id")
    val storyId: Long by requestParameter(storyId, customParameterName = "story_id")
    val content: InputStoryContent by requestParameter(content, customParameterName = "content")

    var caption: String? by optionalRequestParameter(caption, customParameterName = "caption")
    fun caption(caption: String) = applySelf { this.caption = caption }

    var parseMode: String? by optionalRequestParameter(parseMode, customParameterName = "parse_mode")
    fun parseMode(parseMode: String) = applySelf { this.parseMode = parseMode }

    var captionEntities: Array<MessageEntity>? by optionalRequestParameter(captionEntities, customParameterName = "caption_entities")
    fun captionEntities(captionEntities: Array<MessageEntity>) = applySelf { this.captionEntities = captionEntities }

    var areas: Array<StoryArea>? by optionalRequestParameter(areas, customParameterName = "areas")
    fun areas(areas: Array<StoryArea>) = applySelf { this.areas = areas }

}