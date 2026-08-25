package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.LinkPreviewOptions;
import com.pengrad.telegrambot.model.MessageEntity;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.model.request.InputMedia;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.model.request.richmessages.InputRichMessage;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.response.SendResponse;

import java.util.Map;

/**
 * Stas Parshin
 * 07 May 2016
 */
public class EditMessageText extends BaseRequest<EditMessageText, BaseResponse> {

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
        add("chat_id", chatId).add("message_id", messageId).add("rich_message", richMessage);
        addAttachments(richMessage);
    }

    public EditMessageText(String inlineMessageId, InputRichMessage richMessage) {
        super(BaseResponse.class);
        add("inline_message_id", inlineMessageId).add("rich_message", richMessage);
        addAttachments(richMessage);
    }

    private void addAttachments(InputRichMessage richMessage) {
        for (InputMedia<?> m : richMessage.inputMedia()) {
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

    @Override
    public boolean isMultipart() {
        return isMultipart;
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
        return add("rich_message", richMessage);
    }

}
