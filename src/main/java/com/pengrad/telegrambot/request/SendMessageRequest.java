package com.pengrad.telegrambot.request;

import com.pengrad.telegrambot.model.ReplyKeyboardMarkup;

/**
 * stas
 * 8/4/15.
 */
public class SendMessageRequest {
    public final Integer chat_id;
    public final String text;
    public final boolean disable_web_page_preview;
    public final Integer reply_to_message_id;
    public final ReplyKeyboardMarkup reply_markup;

    public SendMessageRequest(Integer chat_id, String text) {
        this(chat_id, text, false, null, null);
    }

    private SendMessageRequest(Integer chat_id, String text, boolean disable_web_page_preview, Integer reply_to_message_id, ReplyKeyboardMarkup reply_markup) {
        this.chat_id = chat_id;
        this.text = text;
        this.disable_web_page_preview = disable_web_page_preview;
        this.reply_to_message_id = reply_to_message_id;
        this.reply_markup = reply_markup;
    }

    public static final class Builder {
        private Integer chat_id;
        private String text;
        private boolean disable_web_page_preview = false;
        private Integer reply_to_message_id = null;
        private ReplyKeyboardMarkup reply_markup = null;

        public Builder message(Integer chat_id, String text) {
            this.chat_id = chat_id;
            this.text = text;
            return this;
        }

        public Builder setDisableWebPagePreview(boolean disable_web_page_preview) {
            this.disable_web_page_preview = disable_web_page_preview;
            return this;
        }

        public Builder setReplyToMessageId(Integer reply_to_message_id) {
            this.reply_to_message_id = reply_to_message_id;
            return this;
        }

        public Builder setReplyMarkup(ReplyKeyboardMarkup reply_markup) {
            this.reply_markup = reply_markup;
            return this;
        }

        public SendMessageRequest build() {
            if (chat_id == null) {
                throw new IllegalStateException("Text required");
            }
            if (text == null) {
                throw new IllegalStateException("Chat_id required");
            }
            return new SendMessageRequest(chat_id, text, disable_web_page_preview, reply_to_message_id, reply_markup);
        }
    }
}
