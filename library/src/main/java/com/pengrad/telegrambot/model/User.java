package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * stas
 * 8/4/15.
 */
public class User implements Serializable {
    private final static long serialVersionUID = 0L;

    private Integer id;
    private Boolean is_bot;
    private String first_name;
    private String last_name;
    private String username;
    private String language_code;
    private Boolean can_join_groups;
    private Boolean can_read_all_group_messages;
    private Boolean supports_inline_queries;

    public Integer id() {
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

    public Boolean canJoinGroups() {
        return can_join_groups;
    }

    public Boolean canReadAllGroupMessages() {
        return can_read_all_group_messages;
    }

    public Boolean supportsInlineQueries() {
        return supports_inline_queries;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!Objects.equals(id, user.id)) return false;
        if (!Objects.equals(is_bot, user.is_bot)) return false;
        if (!Objects.equals(first_name, user.first_name)) return false;
        if (!Objects.equals(last_name, user.last_name)) return false;
        if (!Objects.equals(username, user.username)) return false;
        if (!Objects.equals(language_code, user.language_code))
            return false;
        if (!Objects.equals(can_join_groups, user.can_join_groups))
            return false;
        if (!Objects.equals(can_read_all_group_messages, user.can_read_all_group_messages))
            return false;
        return Objects.equals(supports_inline_queries, user.supports_inline_queries);
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
                ", can_join_groups=" + can_join_groups +
                ", can_read_all_group_messages=" + can_read_all_group_messages +
                ", supports_inline_queries=" + supports_inline_queries +
                '}';
    }
}