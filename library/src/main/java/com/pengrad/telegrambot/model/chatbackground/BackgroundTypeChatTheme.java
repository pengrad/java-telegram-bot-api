package com.pengrad.telegrambot.model.chatbackground;

import java.util.Objects;

public class BackgroundTypeChatTheme extends BackgroundType {

    public static final String TYPE = "chat_theme";

    private String theme_name;

    public BackgroundTypeChatTheme(String themeName) {
        super(TYPE);
        this.theme_name = themeName;
    }

    public String themeName() {
        return theme_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BackgroundTypeChatTheme that = (BackgroundTypeChatTheme) o;
        return Objects.equals(theme_name, that.theme_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), theme_name);
    }

    @Override
    public String toString() {
        return "BackgroundTypeChatTheme{" +
                "type='" + type() + '\'' +
                ", theme_name=" + theme_name +
                '}';
    }
}
