package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.LinkPreviewOptions;
import com.pengrad.telegrambot.model.MessageEntity;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.model.request.richmessages.InputRichMessage;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.SendResponse;
import com.pengrad.telegrambot.utility.richmessages.RichMessageAttachments;

import java.util.Map;

/**
 * Stas Parshin
 * 07 May 2016
 */
public class EditMessageText extends BaseRequest<EditMessageText, BaseResponse> {

    private InputRichMessage richMessage;
    private boolean attachmentsCollected = false;
    private boolean isMultipart = false;

    public EditMessageText(Object chatId, int messageId, String text) {
        super(SendResponse.class);
        add("chat_id", chatId).add("message_id", messageId).add("text", text);
    }

    public EditMessageText(String inlineMessageId, String text) {
        super(BaseResponse.class);
        add("inline_message_id", inlineMessageId).add("text", text);
    }

    public EditMessageText(Object chatId, int messageId, InputRichMessage richMessage) {
        super(SendResponse.class);
        this.richMessage = richMessage;
        add("chat_id", chatId).add("message_id", messageId).add("rich_message", richMessage);
    }

    public EditMessageText(String inlineMessageId, InputRichMessage richMessage) {
        super(BaseResponse.class);
        this.richMessage = richMessage;
        add("inline_message_id", inlineMessageId).add("rich_message", richMessage);
    }

    public EditMessageText parseMode(ParseMode parseMode) {
        return add("parse_mode", parseMode.name());
    }

    public EditMessageText entities(MessageEntity... entities) {
        return add("entities", entities);
    }

    public EditMessageText linkPreviewOptions(LinkPreviewOptions linkPreviewOptions) {
        return add("link_preview_options", linkPreviewOptions);
    }

    public EditMessageText replyMarkup(InlineKeyboardMarkup replyMarkup) {
        return add("reply_markup", replyMarkup);
    }

    public EditMessageText businessConnectionId(String businessConnectionId) {
        return add("business_connection_id", businessConnectionId);
    }

    public EditMessageText richMessage(InputRichMessage richMessage) {
        this.richMessage = richMessage;
        return add("rich_message", richMessage);
    }

    /**
     * Collected on send rather than on construction, so that a rich message populated after
     * the request was built is still uploaded.
     */
    private void collectAttachments() {
        if (attachmentsCollected) return;
        attachmentsCollected = true;
        Map<String, Object> attachments = RichMessageAttachments.collect(richMessage);
        addAll(attachments);
        isMultipart = !attachments.isEmpty();
    }

    @Override
    public boolean isMultipart() {
        collectAttachments();
        return isMultipart;
    }

    @Override
    public Map<String, Object> getParameters() {
        collectAttachments();
        return super.getParameters();
    }

}
