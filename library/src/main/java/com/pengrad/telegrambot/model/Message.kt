package com.pengrad.telegrambot.model

import com.pengrad.telegrambot.impl.SerialName
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup
import com.pengrad.telegrambot.passport.PassportData
import java.io.Serializable

/**
 * stas
 * 8/4/15.
 */
data class Message(
        @get:JvmName("messageId") @SerialName("message_id") val messageId: Int? = null,
        @get:JvmName("from") val from: User? = null,
        @get:JvmName("date") val date: Int? = null,
        @get:JvmName("chat") val chat: Chat? = null,
        @get:JvmName("forwardFrom") @SerialName("forward_from") val forwardFrom: User? = null,
        @get:JvmName("forwardFromChat") @SerialName("forward_from_chat") val forwardFromChat: Chat? = null,
        @get:JvmName("forwardFromMessageId") @SerialName("forward_from_message_id") val forwardFromMessageId: Int? = null,
        @get:JvmName("forwardSignature") @SerialName("forward_signature") val forwardSignature: String? = null,
        @get:JvmName("forwardSenderName") @SerialName("forward_sender_name") val forwardSenderName: String? = null,
        @get:JvmName("forwardDate") @SerialName("forward_date") val forwardDate: Int? = null,
        @get:JvmName("replyToMessage") @SerialName("reply_to_message") val replyToMessage: Message? = null,
        @get:JvmName("editDate") @SerialName("edit_date") val editDate: Int? = null,
        @get:JvmName("mediaGroupId") @SerialName("media_group_id") val mediaGroupId: String? = null,
        @get:JvmName("authorSignature") @SerialName("author_signature") val authorSignature: String? = null,
        @get:JvmName("text") val text: String? = null,
        @get:JvmSynthetic val entities: List<MessageEntity>? = null,
        @get:JvmSynthetic @SerialName("caption_entities") val captionEntities: List<MessageEntity>? = null,
        @get:JvmName("audio") val audio: Audio? = null,
        @get:JvmName("document") val document: Document? = null,
        @get:JvmName("animation") val animation: Animation? = null,
        @get:JvmName("game") val game: Game? = null,
        @get:JvmSynthetic val photo: List<PhotoSize>? = null,
        @get:JvmName("sticker") val sticker: Sticker? = null,
        @get:JvmName("video") val video: Video? = null,
        @get:JvmName("voice") val voice: Voice? = null,
        @get:JvmName("videoNote") @SerialName("video_note") val videoNote: VideoNote? = null,
        @get:JvmName("caption") val caption: String? = null,
        @get:JvmName("contact") val contact: Contact? = null,
        @get:JvmName("location") val location: Location? = null,
        @get:JvmName("venue") val venue: Venue? = null,
        @get:JvmName("poll") val poll: Poll? = null,
        @get:JvmSynthetic @SerialName("new_chat_members") val newChatMembers: List<User>? = null,
        @get:JvmName("leftChatMember") @SerialName("left_chat_member") val leftChatMember: User? = null,
        @get:JvmName("newChatTitle") @SerialName("new_chat_title") val newChatTitle: String? = null,
        @get:JvmSynthetic @SerialName("new_chat_photo") val newChatPhoto: List<PhotoSize>? = null,
        @get:JvmName("deleteChatPhoto") @SerialName("delete_chat_photo") val deleteChatPhoto: Boolean? = null,
        @get:JvmName("groupChatCreated") @SerialName("group_chat_created") val groupChatCreated: Boolean? = null,
        @get:JvmName("supergroupChatCreated") @SerialName("supergroup_chat_created") val supergroupChatCreated: Boolean? = null,
        @get:JvmName("channelChatCreated") @SerialName("channel_chat_created") val channelChatCreated: Boolean? = null,
        @get:JvmName("migrateToChatId") @SerialName("migrate_to_chat_id") val migrateToChatId: Long? = null,
        @get:JvmName("migrateFromChatId") @SerialName("migrate_from_chat_id") val migrateFromChatId: Long? = null,
        @get:JvmName("pinnedMessage") @SerialName("pinned_message") val pinnedMessage: Message? = null,
        @get:JvmName("invoice") val invoice: Invoice? = null,
        @get:JvmName("successfulPayment") @SerialName("successful_payment") val successfulPayment: SuccessfulPayment? = null,
        @get:JvmName("connectedWebsite") @SerialName("connected_website") val connectedWebsite: String? = null,
        @get:JvmName("passportData") @SerialName("passport_data") val passportData: PassportData? = null,
        @get:JvmName("replyMarkup") @SerialName("reply_markup") val replyMarkup: InlineKeyboardMarkup? = null
) : Serializable {

    fun entities(): Array<MessageEntity>? = entities?.toTypedArray()
    fun captionEntities(): Array<MessageEntity>? = captionEntities?.toTypedArray()
    fun photo(): Array<PhotoSize>? = photo?.toTypedArray()
    fun newChatMembers(): Array<User>? = newChatMembers?.toTypedArray()
    fun newChatPhoto(): Array<PhotoSize>? = newChatPhoto?.toTypedArray()

    companion object {
        private const val serialVersionUID = 0L
    }
}