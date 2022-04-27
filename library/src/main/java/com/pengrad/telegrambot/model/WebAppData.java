package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Mirco Ianese
 * 20 Apr 2022
 */
public class WebAppData implements Serializable {
    
    private final static long serialVersionUID = 0L;

    private String data;

    private String button_text;

    public String data() {
        return data;
    }

    public String buttonText() {
        return button_text;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WebAppData that = (WebAppData) o;
        return Objects.equals(data, that.data) &&
                Objects.equals(button_text, that.button_text);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, button_text);
    }

    @Override
    public String toString() {
        return "WebAppData{" +
                "data=" + data +
                ", button_text=" + button_text +
                '}';
    }
    
}
