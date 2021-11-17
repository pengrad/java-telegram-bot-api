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
    private Boolean creates_join_request;
    private Boolean is_primary;
    private Boolean is_revoked;
    private String name;
    private Integer expire_date;
    private Integer member_limit;    
    private Integer pending_join_request_count;
   

    public String inviteLink() {
        return invite_link;
    }

    public User creator() {
        return creator;
    }

    public Boolean createsJoinReqeust() {
        return creates_join_request;
    }

    public Boolean isPrimary() {
        return is_primary;
    }

    public Boolean isRevoked() {
        return is_revoked;
    }

    public String name() {
        return name;
    }

    public Integer expireDate() {
        return expire_date;
    }

    public Integer memberLimit() {
        return member_limit;
    }

    public Integer pendingJoinRequestCount() {
        return pending_join_request_count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ChatInviteLink that = (ChatInviteLink) o;
        return Objects.equals(invite_link, that.invite_link) &&
                Objects.equals(creator, that.creator) &&
                Objects.equals(creates_join_request, that.creates_join_request) &&
                Objects.equals(is_primary, that.is_primary) &&
                Objects.equals(is_revoked, that.is_revoked) &&
                Objects.equals(name, that.name) &&
                Objects.equals(expire_date, that.expire_date) &&
                Objects.equals(member_limit, that.member_limit) &&
                Objects.equals(pending_join_request_count, that.pending_join_request_count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invite_link, creator, creates_join_request, is_primary, is_revoked, name, expire_date, member_limit, pending_join_request_count);
    }

    @Override
    public String toString() {
        return "ChatInviteLink{" +
                "invite_link='" + invite_link + '\'' +
                ", creator=" + creator +
                ", creates_join_request=" + creates_join_request +
                ", is_primary=" + is_primary +
                ", is_revoked=" + is_revoked +
                ", name=" + name +
                ", expire_date=" + expire_date +
                ", member_limit=" + member_limit +                
                ", pending_join_request_count=" + pending_join_request_count +
                '}';
    }
}
