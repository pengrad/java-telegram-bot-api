package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * stas
 * 8/4/15.
 */
public class User implements Serializable {
    private final static long serialVersionUID = 0L;

    private Long id;
    private Boolean is_bot;
    private String first_name;
    private String last_name;
    private String username;
    private String language_code;
    private Boolean is_premium;
    private Boolean added_to_attachment_menu;
    private Boolean can_join_groups;
    private Boolean can_read_all_group_messages;
    private Boolean supports_inline_queries;
    private Boolean can_connect_to_business;
    private Boolean has_main_web_app;

    private User() {
    }

    public User(Long id) {
        this.id = id;
    }

    public Long id() {
        return id;
    }

    public Boolean isBot() {
        return is_bot;
    }

    public String firstName() {
        return first_name;
    }

    public String lastName() {
        return last_name;
    }

    public String username() {
        return username;
    }

    public String languageCode() {
        return language_code;
    }

    public Boolean isPremium() {
        return is_premium != null && is_premium;
    }

    public Boolean addedToAttachmentMenu() {
        return added_to_attachment_menu != null && added_to_attachment_menu;
    }

    public Boolean canJoinGroups() {
        return can_join_groups != null && can_join_groups;
    }

    public Boolean canReadAllGroupMessages() {
        return can_read_all_group_messages != null && can_read_all_group_messages;
    }

    public Boolean supportsInlineQueries() {
        return supports_inline_queries != null && supports_inline_queries;
    }

    public Boolean canConnectToBusiness() {
        return can_connect_to_business != null && can_connect_to_business;
    }

    public Boolean hasMainWebApp() {
        return has_main_web_app;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(is_bot, user.is_bot) && Objects.equals(first_name, user.first_name) && Objects.equals(last_name, user.last_name) && Objects.equals(username, user.username) && Objects.equals(language_code, user.language_code) && Objects.equals(is_premium, user.is_premium) && Objects.equals(added_to_attachment_menu, user.added_to_attachment_menu) && Objects.equals(can_join_groups, user.can_join_groups) && Objects.equals(can_read_all_group_messages, user.can_read_all_group_messages) && Objects.equals(supports_inline_queries, user.supports_inline_queries) && Objects.equals(can_connect_to_business, user.can_connect_to_business) && Objects.equals(has_main_web_app, user.has_main_web_app);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", is_bot=" + is_bot +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", username='" + username + '\'' +
                ", language_code='" + language_code + '\'' +
                ", is_premium='" + is_premium + '\'' +
                ", added_to_attachment_menu='" + added_to_attachment_menu + '\'' +
                ", can_join_groups=" + can_join_groups +
                ", can_read_all_group_messages=" + can_read_all_group_messages +
                ", supports_inline_queries=" + supports_inline_queries +
                ", can_connect_to_business=" + can_connect_to_business +
                ", has_main_web_app=" + has_main_web_app +
                '}';
    }
}