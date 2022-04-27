package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Mirco Ianese
 * 20 Apr 2022
 */
public class MenuButtonWebApp extends MenuButton implements Serializable {

    private final static long serialVersionUID = 0L;

    private String text;
    private WebAppInfo web_app;

    public MenuButtonWebApp(String text, WebAppInfo webAppInfo) {
        super("web_app");
        this.text = text;
        this.web_app = webAppInfo;
    }

    MenuButtonWebApp() {}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        MenuButtonWebApp that = (MenuButtonWebApp) o;
        return Objects.equals(text, that.text) && Objects.equals(web_app, that.web_app);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), text, web_app);
    }

    @Override
    public String toString() {
        return "MenuButtonWebApp{" +
                "text='" + text + '\'' +
                ", web_app_info=" + web_app +
                '}';
    }
}