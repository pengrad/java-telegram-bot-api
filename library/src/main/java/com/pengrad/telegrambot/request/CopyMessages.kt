package com.pengrad.telegrambot.request

import com.pengrad.telegrambot.response.MessageIdsResponse

class CopyMessages(
        chatId: Any,
        fromChatId: Any,
        messageIds: IntArray
) : BaseRequest<CopyMessages, MessageIdsResponse>(MessageIdsResponse::class.java) {
    init {
        add("chat_id", chatId).add("from_chat_id", fromChatId).add("message_ids", messageIds)
    }

    fun messageThreadId(messageThreadId: Int?): CopyMessages {
        return add("message_thread_id", messageThreadId)
    }

    fun removeCaption(removeCaption: Boolean): CopyMessages {
        return add("remove_caption", removeCaption)
    }

    fun disableNotification(disableNotification: Boolean): CopyMessages {
        return add("disable_notification", disableNotification)
    }

    fun protectContent(protectContent: Boolean): CopyMessages {
        return add("protect_content", protectContent)
    }
}
