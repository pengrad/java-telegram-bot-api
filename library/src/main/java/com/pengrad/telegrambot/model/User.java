package com.pengrad.telegrambot.model;

import java.io.Serializable;

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

        if (id != null ? !id.equals(user.id) : user.id != null) return false;
        if (is_bot != null ? !is_bot.equals(user.is_bot) : user.is_bot != null) return false;
        if (first_name != null ? !first_name.equals(user.first_name) : user.first_name != null) return false;
        if (last_name != null ? !last_name.equals(user.last_name) : user.last_name != null) return false;
        if (username != null ? !username.equals(user.username) : user.username != null) return false;
        if (language_code != null ? !language_code.equals(user.language_code) : user.language_code != null)
            return false;
        if (can_join_groups != null ? !can_join_groups.equals(user.can_join_groups) : user.can_join_groups != null)
            return false;
        if (can_read_all_group_messages != null ? !can_read_all_group_messages.equals(user.can_read_all_group_messages) : user.can_read_all_group_messages != null)
            return false;
        return supports_inline_queries != null ? supports_inline_queries.equals(user.supports_inline_queries) : user.supports_inline_queries == null;
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