package com.pengrad.telegrambot.model.request;

import com.pengrad.telegrambot.AttachName;
import com.pengrad.telegrambot.model.MaskPosition;

import java.io.Serializable;

public class InputSticker implements Serializable {

    private final static long serialVersionUID = 0L;

    private String sticker;
    private String[] emoji_list;
    private MaskPosition mask_position;
    private String[] keywords;
    transient private String attachName;
    transient private Object attach;

    public InputSticker(Object sticker, String[] emojiList) {
        this.emoji_list = emojiList;
        if (sticker instanceof String) {
            this.sticker = (String) sticker;
        } else {
            attach = sticker;
            attachName = AttachName.next();
            this.sticker = "attach://" + attachName;
        }
    }

    public String getAttachName() {
        return attachName;
    }

    public Object getAttachment() {
        return attach;
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
