package com.pengrad.telegrambot.model

import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup
import com.pengrad.telegrambot.passport.PassportData
import java.io.Serializable

/**
 * stas
 * 8/4/15.
 */
data class Message(
        @get:JvmName("messageId") val message_id: Int? = null,
        @get:JvmName("from") val from: User? = null,
        @get:JvmName("date") val date: Int? = null,
        @get:JvmName("chat") val chat: Chat? = null,
        @get:JvmName("forwardFrom") val forward_from: User? = null,
        @get:JvmName("forwardFromChat") val forward_from_chat: Chat? = null,
        @get:JvmName("forwardFromMessageId") val forward_from_message_id: Int? = null,
        @get:JvmName("forwardSignature") val forward_signature: String? = null,
        @get:JvmName("forwardSenderName") val forward_sender_name: String? = null,
        @get:JvmName("forwardDate") val forward_date: Int? = null,
        @get:JvmName("replyToMessage") val reply_to_message: Message? = null,
        @get:JvmName("editDate") val edit_date: Int? = null,
        @get:JvmName("mediaGroupId") val media_group_id: String? = null,
        @get:JvmName("authorSignature") val author_signature: String? = null,
        @get:JvmName("text") val text: String? = null,
        @get:JvmSynthetic val entities: List<MessageEntity>? = null,
        @get:JvmSynthetic val caption_entities: List<MessageEntity>? = null,
        @get:JvmName("audio") val audio: Audio? = null,
        @get:JvmName("document") val document: Document? = null,
        @get:JvmName("animation") val animation: Animation? = null,
        @get:JvmName("game") val game: Game? = null,
        @get:JvmSynthetic val photo: List<PhotoSize>? = null,
        @get:JvmName("sticker") val sticker: Sticker? = null,
        @get:JvmName("video") val video: Video? = null,
        @get:JvmName("voice") val voice: Voice? = null,
        @get:JvmName("videoNote") val video_note: VideoNote? = null,
        @get:JvmName("caption") val caption: String? = null,
        @get:JvmName("contact") val contact: Contact? = null,
        @get:JvmName("location") val location: Location? = null,
        @get:JvmName("venue") val venue: Venue? = null,
        @get:JvmName("poll") val poll: Poll? = null,
        @get:JvmSynthetic val new_chat_members: List<User>? = null,
        @get:JvmName("leftChatMember") val left_chat_member: User? = null,
        @get:JvmName("newChatTitle") val new_chat_title: String? = null,
        @get:JvmSynthetic val new_chat_photo: List<PhotoSize>? = null,
        @get:JvmName("deleteChatPhoto") val delete_chat_photo: Boolean? = null,
        @get:JvmName("groupChatCreated") val group_chat_created: Boolean? = null,
        @get:JvmName("supergroupChatCreated") val supergroup_chat_created: Boolean? = null,
        @get:JvmName("channelChatCreated") val channel_chat_created: Boolean? = null,
        @get:JvmName("migrateToChatId") val migrate_to_chat_id: Long? = null,
        @get:JvmName("migrateFromChatId") val migrate_from_chat_id: Long? = null,
        @get:JvmName("pinnedMessage") val pinned_message: Message? = null,
        @get:JvmName("invoice") val invoice: Invoice? = null,
        @get:JvmName("successfulPayment") val successful_payment: SuccessfulPayment? = null,
        @get:JvmName("connectedWebsite") val connected_website: String? = null,
        @get:JvmName("passportData") val passport_data: PassportData? = null,
        @get:JvmName("replyMarkup") val reply_markup: InlineKeyboardMarkup? = null
) : Serializable {

    fun entities(): Array<MessageEntity>? = entities?.toTypedArray()
    fun captionEntities(): Array<MessageEntity>? = caption_entities?.toTypedArray()
    fun photo(): Array<PhotoSize>? = photo?.toTypedArray()
    fun newChatMembers(): Array<User>? = new_chat_members?.toTypedArray()
    fun newChatPhoto(): Array<PhotoSize>? = new_chat_photo?.toTypedArray()

    companion object {
        private const val serialVersionUID = 0L
    }
}