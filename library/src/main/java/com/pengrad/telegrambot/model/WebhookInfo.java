package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 * Stas Parshin
 * 03 October 2016
 */
public class WebhookInfo implements Serializable {
    private final static long serialVersionUID = 0L;

    private String url;
    private Boolean has_custom_certificate;
    private Integer pending_update_count;
    private String ip_address;
    private Integer last_error_date;
    private String last_error_message;
    private Integer max_connections;
    private String[] allowed_updates;

    public String url() {
        return url;
    }

    public Boolean hasCustomCertificate() {
        return has_custom_certificate;
    }

    public Integer pendingUpdateCount() {
        return pending_update_count;
    }

    public String ipAddress() {
        return ip_address;
    }

    public Integer lastErrorDate() {
        return last_error_date;
    }

    public String lastErrorMessage() {
        return last_error_message;
    }

    public Integer maxConnections() {
        return max_connections;
    }

    public String[] allowedUpdates() {
        return allowed_updates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WebhookInfo that = (WebhookInfo) o;
        return Objects.equals(url, that.url) &&
                Objects.equals(has_custom_certificate, that.has_custom_certificate) &&
                Objects.equals(pending_update_count, that.pending_update_count) &&
                Objects.equals(ip_address, that.ip_address) &&
                Objects.equals(last_error_date, that.last_error_date) &&
                Objects.equals(last_error_message, that.last_error_message) &&
                Objects.equals(max_connections, that.max_connections) &&
                Arrays.equals(allowed_updates, that.allowed_updates);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(url, has_custom_certificate, pending_update_count, ip_address, last_error_date, last_error_message, max_connections);
        result = 31 * result + Arrays.hashCode(allowed_updates);
        return result;
    }

    @Override
    public String toString() {
        return "WebhookInfo{" +
                "url='" + url + '\'' +
                ", has_custom_certificate=" + has_custom_certificate +
                ", pending_update_count=" + pending_update_count +
                ", ip_address='" + ip_address + '\'' +
                ", last_error_date=" + last_error_date +
                ", last_error_message='" + last_error_message + '\'' +
                ", max_connections=" + max_connections +
                ", allowed_updates=" + Arrays.toString(allowed_updates) +
                '}';
    }
}
