package com.pengrad.telegrambot.model;

import java.io.Serializable;

public class WriteAccessAllowed implements Serializable {
    private final static long serialVersionUID = 0L;

    private String web_app_name;

    public String webAppName() {
        return web_app_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return o != null && getClass() == o.getClass();
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
