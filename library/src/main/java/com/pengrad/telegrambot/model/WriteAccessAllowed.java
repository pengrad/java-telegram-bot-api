package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

public class WriteAccessAllowed implements Serializable {
    private final static long serialVersionUID = 0L;

    private String web_app_name;

    public String webAppName() {
        return web_app_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WriteAccessAllowed that = (WriteAccessAllowed) o;
        return Objects.equals(web_app_name, that.web_app_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(web_app_name);
    }

    @Override
    public String toString() {
        return "WriteAccessAllowed{" + "web_app_name='" + web_app_name + '\'' + '}';
    }
}
