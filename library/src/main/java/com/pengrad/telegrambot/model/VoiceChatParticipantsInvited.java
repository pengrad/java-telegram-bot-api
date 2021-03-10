package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * Stas Parshin
 * 10 March 2021
 */
public class VoiceChatParticipantsInvited implements Serializable {
    private final static long serialVersionUID = 0L;

    private List<User> users;

    public List<User> users() {
        return users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VoiceChatParticipantsInvited that = (VoiceChatParticipantsInvited) o;
        return Objects.equals(users, that.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(users);
    }

    @Override
    public String toString() {
        return "VoiceChatParticipantsInvited{" +
                "users=" + users +
                '}';
    }
}
