package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.model.request.InputMedia;
import com.pengrad.telegrambot.response.MessagesResponse;

import java.util.Map;

/**
 * Stas Parshin
 * 23 November 2017
 */
public class SendMediaGroup extends BaseRequest<SendMediaGroup, MessagesResponse> {

    private boolean isMultipart = false;

    public SendMediaGroup(TelegramBotClient api, Object chatId, InputMedia<?>... media) {
        super(api, MessagesResponse.class);
        add("chat_id", chatId).add("media", media);

        for (InputMedia<?> m : media) {
            Map<String, Object> attachments = m.getAttachments();
            if (attachments != null && attachments.size() > 0) {
                addAll(attachments);
                isMultipart = true;
            }
            if (m.inputFile() != null) {
                add(m.getInputFileId(), m.inputFile());
                isMultipart = true;
            }
        }
    }

    public SendMediaGroup messageThreadId(Integer messageThreadId) {
        return add("message_thread_id", messageThreadId);
    }

    public SendMediaGroup disableNotification(boolean disableNotification) {
        return add("disable_notification", disableNotification);
    }

    public SendMediaGroup replyToMessageId(int replyToMessageId) {
        return add("reply_to_message_id", replyToMessageId);
    }

    public SendMediaGroup allowSendingWithoutReply(boolean allowSendingWithoutReply) {
        return add("allow_sending_without_reply", allowSendingWithoutReply);
    }

    @Override
    public boolean isMultipart() {
        return isMultipart;
    }
}
