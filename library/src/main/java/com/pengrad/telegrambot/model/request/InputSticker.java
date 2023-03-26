package com.pengrad.telegrambot.model.request;

import java.io.Serializable;

import com.pengrad.telegrambot.model.MaskPosition;

public class InputSticker implements Serializable {

    private final static long serialVersionUID = 0L;
    
    private Object sticker;
    private String[] emoji_list;
    private MaskPosition mask_position;
    private String[] keywords;

    public InputSticker(Object sticker, String[] emojiList) {
        this.sticker = sticker;
        this.emoji_list = emojiList;
    }

    public InputSticker maskPosition(MaskPosition maskPosition) {
        mask_position = maskPosition;
        return this;
    }

    public InputSticker keywords(String[] keywords) {
        this.keywords = keywords;
        return this;
    }

}
