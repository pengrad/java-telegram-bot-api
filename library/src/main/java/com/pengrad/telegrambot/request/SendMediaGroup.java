package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.request.ReplyParameters;
import com.pengrad.telegrambot.model.request.InputMedia;
import com.pengrad.telegrambot.response.MessagesResponse;

import java.util.Map;

/**
 * Stas Parshin
 * 23 November 2017
 */
public class SendMediaGroup extends BaseRequest<SendMediaGroup, MessagesResponse> {

    private boolean isMultipart = false;

    public SendMediaGroup(Object chatId, InputMedia<?>... media) {
        super(MessagesResponse.class);
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

    public SendMediaGroup businessConnectionId(String businessConnectionId) {
        return add("business_connection_id", businessConnectionId);
    }

    public SendMediaGroup messageThreadId(Integer messageThreadId) {
        return add("message_thread_id", messageThreadId);
    }

    public SendMediaGroup replyParameters(ReplyParameters replyParameters) {
        return add("reply_parameters", replyParameters);
    }

    /*
     @deprecated Use replyParameters instead
    */
    public SendMediaGroup replyToMessageId(int replyToMessageId) {
        return add("reply_to_message_id", replyToMessageId);
    }

    /*
     @deprecated Use replyParameters instead
    */
    public SendMediaGroup allowSendingWithoutReply(boolean allowSendingWithoutReply) {
        return add("allow_sending_without_reply", allowSendingWithoutReply);
    }

    public SendMediaGroup disableNotification(boolean disableNotification) {
        return add("disable_notification", disableNotification);
    }
    public SendMediaGroup protectContent(boolean protectContent) {
        return add("protect_content", protectContent);
    }

    @Override
    public boolean isMultipart() {
        return isMultipart;
    }
}
