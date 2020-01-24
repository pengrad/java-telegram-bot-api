package com.pengrad.telegrambot.model

//import com.pengrad.telegrambot.passport.PassportData

import java.io.Serializable
import java.util.*

/**
 * stas
 * 8/4/15.
 */
class Message : Serializable {

    private val message_id: Int? = null
    private val from: User? = null
    private val date: Int? = null
    private val chat: Chat? = null
    private val forward_from: User? = null
    private val forward_from_chat: Chat? = null
    private val forward_from_message_id: Int? = null
    private val forward_signature: String? = null
    private val forward_sender_name: String? = null
    private val forward_date: Int? = null
    private val reply_to_message: Message? = null
    private val edit_date: Int? = null
    private val media_group_id: String? = null
    private val author_signature: String? = null
    private val text: String? = null
    private val entities: Array<MessageEntity>? = null
    private val caption_entities: Array<MessageEntity>? = null
    private val audio: Audio? = null
    private val document: Document? = null
    private val animation: Animation? = null
    private val game: Game? = null
    private val photo: Array<PhotoSize>? = null
    private val sticker: Sticker? = null
    private val video: Video? = null
    private val voice: Voice? = null
    private val video_note: VideoNote? = null
    private val caption: String? = null
    private val contact: Contact? = null
    private val location: Location? = null
    private val venue: Venue? = null
    private val poll: Poll? = null
    private val new_chat_member: User? = null
    private val new_chat_members: Array<User>? = null
    private val left_chat_member: User? = null
    private val new_chat_title: String? = null
    private val new_chat_photo: Array<PhotoSize>? = null
    private val delete_chat_photo: Boolean? = null
    private val group_chat_created: Boolean? = null
    private val supergroup_chat_created: Boolean? = null
    private val channel_chat_created: Boolean? = null
    private val migrate_to_chat_id: Long? = null
    private val migrate_from_chat_id: Long? = null
    private val pinned_message: Message? = null
    private val invoice: Invoice? = null
    private val successful_payment: SuccessfulPayment? = null
    private val connected_website: String? = null
    private val passport_data: Object? = null

    fun messageId(): Int? {
        return message_id
    }

    fun from(): User? {
        return from
    }

    fun date(): Int? {
        return date
    }

    fun chat(): Chat? {
        return chat
    }

    fun forwardFrom(): User? {
        return forward_from
    }

    fun forwardFromChat(): Chat? {
        return forward_from_chat
    }

    fun forwardFromMessageId(): Int? {
        return forward_from_message_id
    }

    fun forwardSignature(): String? {
        return forward_signature
    }

    fun forwardSenderName(): String? {
        return forward_sender_name
    }

    fun forwardDate(): Int? {
        return forward_date
    }

    fun replyToMessage(): Message? {
        return reply_to_message
    }

    fun editDate(): Int? {
        return edit_date
    }

    fun mediaGroupId(): String? {
        return media_group_id
    }

    fun authorSignature(): String? {
        return author_signature
    }

    fun text(): String? {
        return text
    }

    fun entities(): Array<MessageEntity>? {
        return entities
    }

    fun captionEntities(): Array<MessageEntity>? {
        return caption_entities
    }

    fun audio(): Audio? {
        return audio
    }

    fun document(): Document? {
        return document
    }

    fun animation(): Animation? {
        return animation
    }

    fun game(): Game? {
        return game
    }

    fun photo(): Array<PhotoSize>? {
        return photo
    }

    fun sticker(): Sticker? {
        return sticker
    }

    fun video(): Video? {
        return video
    }

    fun voice(): Voice? {
        return voice
    }

    fun videoNote(): VideoNote? {
        return video_note
    }

    fun caption(): String? {
        return caption
    }

    fun contact(): Contact? {
        return contact
    }

    fun location(): Location? {
        return location
    }

    fun venue(): Venue? {
        return venue
    }

    fun poll(): Poll? {
        return poll
    }


    @Deprecated("Replaced with new_chat_members")
    fun newChatMember(): User? {
        return new_chat_member
    }

    fun newChatMembers(): Array<User>? {
        return new_chat_members
    }

    fun leftChatMember(): User? {
        return left_chat_member
    }

    fun newChatTitle(): String? {
        return new_chat_title
    }

    fun newChatPhoto(): Array<PhotoSize>? {
        return new_chat_photo
    }

    fun deleteChatPhoto(): Boolean? {
        return delete_chat_photo
    }

    fun groupChatCreated(): Boolean? {
        return group_chat_created
    }

    fun supergroupChatCreated(): Boolean? {
        return supergroup_chat_created
    }

    fun channelChatCreated(): Boolean? {
        return channel_chat_created
    }

    fun migrateToChatId(): Long? {
        return migrate_to_chat_id
    }

    fun migrateFromChatId(): Long? {
        return migrate_from_chat_id
    }

    fun pinnedMessage(): Message? {
        return pinned_message
    }

    fun invoice(): Invoice? {
        return invoice
    }

    fun successfulPayment(): SuccessfulPayment? {
        return successful_payment
    }

    fun connectedWebsite(): String? {
        return connected_website
    }

    fun passportData(): Object? {
        return passport_data
    }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false

        val message = o as Message?

        if (if (message_id != null) message_id != message!!.message_id else message!!.message_id != null) return false
        if (if (from != null) from != message.from else message.from != null) return false
        if (if (date != null) date != message.date else message.date != null) return false
        if (if (chat != null) chat != message.chat else message.chat != null) return false
        if (if (forward_from != null) forward_from != message.forward_from else message.forward_from != null) return false
        if (if (forward_from_chat != null) forward_from_chat != message.forward_from_chat else message.forward_from_chat != null)
            return false
        if (if (forward_from_message_id != null) forward_from_message_id != message.forward_from_message_id else message.forward_from_message_id != null)
            return false
        if (if (forward_signature != null) forward_signature != message.forward_signature else message.forward_signature != null)
            return false
        if (if (forward_sender_name != null) forward_sender_name != message.forward_sender_name else message.forward_sender_name != null)
            return false
        if (if (forward_date != null) forward_date != message.forward_date else message.forward_date != null) return false
        if (if (reply_to_message != null) reply_to_message != message.reply_to_message else message.reply_to_message != null)
            return false
        if (if (edit_date != null) edit_date != message.edit_date else message.edit_date != null) return false
        if (if (media_group_id != null) media_group_id != message.media_group_id else message.media_group_id != null)
            return false
        if (if (author_signature != null) author_signature != message.author_signature else message.author_signature != null)
            return false
        if (if (text != null) text != message.text else message.text != null) return false
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(entities, message.entities)) return false
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(caption_entities, message.caption_entities)) return false
        if (if (audio != null) audio != message.audio else message.audio != null) return false
        if (if (document != null) document != message.document else message.document != null) return false
        if (if (animation != null) animation != message.animation else message.animation != null) return false
        if (if (game != null) game != message.game else message.game != null) return false
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(photo, message.photo)) return false
        if (if (sticker != null) sticker != message.sticker else message.sticker != null) return false
        if (if (video != null) video != message.video else message.video != null) return false
        if (if (voice != null) voice != message.voice else message.voice != null) return false
        if (if (video_note != null) video_note != message.video_note else message.video_note != null) return false
        if (if (caption != null) caption != message.caption else message.caption != null) return false
        if (if (contact != null) contact != message.contact else message.contact != null) return false
        if (if (location != null) location != message.location else message.location != null) return false
        if (if (venue != null) venue != message.venue else message.venue != null) return false
        if (if (poll != null) poll != message.poll else message.poll != null) return false
        if (if (new_chat_member != null) new_chat_member != message.new_chat_member else message.new_chat_member != null)
            return false
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(new_chat_members, message.new_chat_members)) return false
        if (if (left_chat_member != null) left_chat_member != message.left_chat_member else message.left_chat_member != null)
            return false
        if (if (new_chat_title != null) new_chat_title != message.new_chat_title else message.new_chat_title != null)
            return false
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        if (!Arrays.equals(new_chat_photo, message.new_chat_photo)) return false
        if (if (delete_chat_photo != null) delete_chat_photo != message.delete_chat_photo else message.delete_chat_photo != null)
            return false
        if (if (group_chat_created != null) group_chat_created != message.group_chat_created else message.group_chat_created != null)
            return false
        if (if (supergroup_chat_created != null) supergroup_chat_created != message.supergroup_chat_created else message.supergroup_chat_created != null)
            return false
        if (if (channel_chat_created != null) channel_chat_created != message.channel_chat_created else message.channel_chat_created != null)
            return false
        if (if (migrate_to_chat_id != null) migrate_to_chat_id != message.migrate_to_chat_id else message.migrate_to_chat_id != null)
            return false
        if (if (migrate_from_chat_id != null) migrate_from_chat_id != message.migrate_from_chat_id else message.migrate_from_chat_id != null)
            return false
        if (if (pinned_message != null) pinned_message != message.pinned_message else message.pinned_message != null)
            return false
        if (if (invoice != null) invoice != message.invoice else message.invoice != null) return false
        if (if (successful_payment != null) successful_payment != message.successful_payment else message.successful_payment != null)
            return false
        if (if (connected_website != null) connected_website != message.connected_website else message.connected_website != null)
            return false
        return if (passport_data != null) passport_data!!.equals(message.passport_data) else message.passport_data == null
    }

    override fun hashCode(): Int {
        return message_id?.hashCode() ?: 0
    }

    override fun toString(): String {
        return "Message{" +
                "message_id=" + message_id +
                ", from=" + from +
                ", date=" + date +
                ", chat=" + chat +
                ", forward_from=" + forward_from +
                ", forward_from_chat=" + forward_from_chat +
                ", forward_from_message_id=" + forward_from_message_id +
                ", forward_signature='" + forward_signature + '\''.toString() +
                ", forward_sender_name='" + forward_sender_name + '\''.toString() +
                ", forward_date=" + forward_date +
                ", reply_to_message=" + reply_to_message +
                ", edit_date=" + edit_date +
                ", media_group_id='" + media_group_id + '\''.toString() +
                ", author_signature='" + author_signature + '\''.toString() +
                ", text='" + text + '\''.toString() +
                ", entities=" + Arrays.toString(entities) +
                ", caption_entities=" + Arrays.toString(caption_entities) +
                ", audio=" + audio +
                ", document=" + document +
                ", animation=" + animation +
                ", game=" + game +
                ", photo=" + Arrays.toString(photo) +
                ", sticker=" + sticker +
                ", video=" + video +
                ", voice=" + voice +
                ", video_note=" + video_note +
                ", caption='" + caption + '\''.toString() +
                ", contact=" + contact +
                ", location=" + location +
                ", venue=" + venue +
                ", poll=" + poll +
                ", new_chat_member=" + new_chat_member +
                ", new_chat_members=" + Arrays.toString(new_chat_members) +
                ", left_chat_member=" + left_chat_member +
                ", new_chat_title='" + new_chat_title + '\''.toString() +
                ", new_chat_photo=" + Arrays.toString(new_chat_photo) +
                ", delete_chat_photo=" + delete_chat_photo +
                ", group_chat_created=" + group_chat_created +
                ", supergroup_chat_created=" + supergroup_chat_created +
                ", channel_chat_created=" + channel_chat_created +
                ", migrate_to_chat_id=" + migrate_to_chat_id +
                ", migrate_from_chat_id=" + migrate_from_chat_id +
                ", pinned_message=" + pinned_message +
                ", invoice=" + invoice +
                ", successful_payment=" + successful_payment +
                ", connected_website='" + connected_website + '\''.toString() +
                ", passport_data=" + passport_data +
                '}'.toString()
    }

    companion object {
        private const val serialVersionUID = 0L
    }
}
