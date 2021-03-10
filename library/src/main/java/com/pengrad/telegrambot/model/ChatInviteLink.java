package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Stas Parshin
 * 10 March 2021
 */
public class ChatInviteLink implements Serializable {
    private final static long serialVersionUID = 0L;

    private String invite_link;
    private User creator;
    private Boolean is_primary;
    private Boolean is_revoked;
    private Integer expire_date;
    private Integer member_limit;

    public String inviteLink() {
        return invite_link;
    }

    public User creator() {
        return creator;
    }

    public Boolean isPrimary() {
        return is_primary;
    }

    public Boolean isRevoked() {
        return is_revoked;
    }

    public Integer expireDate() {
        return expire_date;
    }

    public Integer memberLimit() {
        return member_limit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatInviteLink that = (ChatInviteLink) o;
        return Objects.equals(invite_link, that.invite_link) &&
                Objects.equals(creator, that.creator) &&
                Objects.equals(is_primary, that.is_primary) &&
                Objects.equals(is_revoked, that.is_revoked) &&
                Objects.equals(expire_date, that.expire_date) &&
                Objects.equals(member_limit, that.member_limit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invite_link, creator, is_primary, is_revoked, expire_date, member_limit);
    }

    @Override
    public String toString() {
        return "ChatInviteLink{" +
                "invite_link='" + invite_link + '\'' +
                ", creator=" + creator +
                ", is_primary=" + is_primary +
                ", is_revoked=" + is_revoked +
                ", expire_date=" + expire_date +
                ", member_limit=" + member_limit +
                '}';
    }
}
