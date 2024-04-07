package com.pengrad.telegrambot.model.request;

import com.pengrad.telegrambot.AttachName;
import com.pengrad.telegrambot.model.MaskPosition;
import com.pengrad.telegrambot.model.Sticker;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class InputSticker implements Serializable {

    private final static long serialVersionUID = 0L;

    private String sticker;
    private String[] emoji_list;
    private MaskPosition mask_position;
    private String[] keywords;
    private Sticker.Format format;
    transient private String attachName;
    transient private Object attach;

    public InputSticker(Object sticker, Sticker.Format format, String[] emojiList) {
        this.format = format;
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

    public InputSticker format(Sticker.Format format) {
        this.format = format;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof InputSticker)) return false;
        InputSticker that = (InputSticker) o;
        return Objects.equals(sticker, that.sticker)
            && Arrays.equals(emoji_list, that.emoji_list)
            && Objects.equals(mask_position, that.mask_position)
            && Arrays.equals(keywords, that.keywords)
            && Objects.equals(format, that.format)
            && Objects.equals(attachName, that.attachName)
            && Objects.equals(attach, that.attach);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(sticker, mask_position, format, attachName, attach);
        result = 31 * result + Arrays.hashCode(emoji_list);
        result = 31 * result + Arrays.hashCode(keywords);
        return result;
    }

    @Override
    public String toString() {
        return "InputSticker{" +
            "sticker='" + sticker + '\'' +
            ", emoji_list=" + Arrays.toString(emoji_list) +
            ", mask_position=" + mask_position +
            ", keywords=" + Arrays.toString(keywords) +
            ", format=" + format +
            ", attachName='" + attachName + '\'' +
            ", attach=" + attach +
            '}';
    }
}
