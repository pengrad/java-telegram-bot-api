package com.pengrad.telegrambot.model;

import java.io.Serializable;

/**
 * Mirco Ianese
 * 20 Apr 2022
 */
public class WebAppInfo implements Serializable {

    private final static long serialVersionUID = 0L;

    private String url;

    public WebAppInfo(String url) {
        this.url = url;
    }

    public String url() {
        return url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WebAppInfo webAppInfo = (WebAppInfo) o;

        return url != null ? url.equals(webAppInfo.url) : webAppInfo.url == null;
    }

    @Override
    public int hashCode() {
        return url != null ? url.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "WebAppInfo{" +
                "url='" + url + '\'' +
                '}';
    }
    
}
