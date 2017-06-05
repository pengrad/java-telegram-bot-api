package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Arrays;

/**
 * Stas Parshin
 * 03 October 2016
 */
public class WebhookInfo implements Serializable {
    private final static long serialVersionUID = 0L;

    private String url;
    private Boolean has_custom_certificate;
    private Integer pending_update_count;
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

        if (url != null ? !url.equals(that.url) : that.url != null) return false;
        if (has_custom_certificate != null ? !has_custom_certificate.equals(that.has_custom_certificate) : that.has_custom_certificate != null)
            return false;
        if (pending_update_count != null ? !pending_update_count.equals(that.pending_update_count) : that.pending_update_count != null)
            return false;
        if (last_error_date != null ? !last_error_date.equals(that.last_error_date) : that.last_error_date != null)
            return false;
        if (last_error_message != null ? !last_error_message.equals(that.last_error_message) : that.last_error_message != null)
            return false;
        if (max_connections != null ? !max_connections.equals(that.max_connections) : that.max_connections != null)
            return false;
        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(allowed_updates, that.allowed_updates);
    }

    @Override
    public int hashCode() {
        int result = url != null ? url.hashCode() : 0;
        result = 31 * result + (has_custom_certificate != null ? has_custom_certificate.hashCode() : 0);
        result = 31 * result + (pending_update_count != null ? pending_update_count.hashCode() : 0);
        result = 31 * result + (last_error_date != null ? last_error_date.hashCode() : 0);
        result = 31 * result + (last_error_message != null ? last_error_message.hashCode() : 0);
        result = 31 * result + (max_connections != null ? max_connections.hashCode() : 0);
        result = 31 * result + Arrays.hashCode(allowed_updates);
        return result;
    }

    @Override
    public String toString() {
        return "WebhookInfo{" +
                "url='" + url + '\'' +
                ", has_custom_certificate=" + has_custom_certificate +
                ", pending_update_count=" + pending_update_count +
                ", last_error_date=" + last_error_date +
                ", last_error_message='" + last_error_message + '\'' +
                ", max_connections=" + max_connections +
                ", allowed_updates=" + Arrays.toString(allowed_updates) +
                '}';
    }
}
