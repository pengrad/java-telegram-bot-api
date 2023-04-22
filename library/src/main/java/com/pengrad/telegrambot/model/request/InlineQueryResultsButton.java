package com.pengrad.telegrambot.model.request;

import java.io.Serializable;
import java.util.Objects;

import com.pengrad.telegrambot.model.WebAppInfo;

public class InlineQueryResultsButton implements Serializable {
    
    private final static long serialVersionUID = 0L;

    private String text;
    private WebAppInfo web_app;
    private String start_parameter;

    public InlineQueryResultsButton(String text, WebAppInfo webApp) {
        this.text = text;
        this.web_app = webApp;
    }

    public InlineQueryResultsButton(String text, String startParameter) {
        this.text = text;
        this.start_parameter = startParameter;
    }

    public String text() {
        return text;
    }

    public WebAppInfo webApp() {
        return web_app;
    }

    public String startParameter() {
        return start_parameter;
    }

}
