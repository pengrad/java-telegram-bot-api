package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

public class WriteAccessAllowed implements Serializable {
    private final static long serialVersionUID = 0L;

    private Boolean from_request;
    private String web_app_name;
    private Boolean from_attachment_menu;

    public Boolean fromRequest() {
        return from_request != null && from_request;
    }

    public String webAppName() {
        return web_app_name;
    }

    public Boolean fromAttachmentMenu() {
        return from_attachment_menu != null && from_attachment_menu;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WriteAccessAllowed that = (WriteAccessAllowed) o;
        return Objects.equals(from_request, that.from_request) &&
                Objects.equals(web_app_name, that.web_app_name) &&
                Objects.equals(from_attachment_menu, that.from_attachment_menu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(from_request,
                web_app_name,
                from_attachment_menu);
    }

    @Override
    public String toString() {
        return "WriteAccessAllowed{" +
                "from_request=" + from_request +
                ", web_app_name='" + web_app_name + '\'' +
                ", from_attachment_menu=" + from_attachment_menu +
                '}';
    }
}
