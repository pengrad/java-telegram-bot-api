package com.pengrad.telegrambot.model;

import java.io.Serializable;

/**
 * Mirco Ianese
 * 20 Apr 2022
 */
public class MenuButtonWebApp extends MenuButton<MenuButtonWebApp> implements Serializable {
    
    private final static long serialVersionUID = 0L;

    private String text;
    private WebAppInfo web_app_info;

    public MenuButtonWebApp(String text, WebAppInfo webAppInfo) {
        super("web_app");
        this.text = text;
        this.web_app_info = webAppInfo;
    }

}