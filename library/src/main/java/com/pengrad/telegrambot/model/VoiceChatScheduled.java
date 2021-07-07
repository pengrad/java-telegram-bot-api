package com.pengrad.telegrambot.model;

import java.io.Serializable;

public class VoiceChatScheduled implements Serializable {

    private final static long serialVersionUID = 0L;

    private Integer start_date;

    public Integer startDate() {
        return start_date;
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

    @Override
    public String toString() {
        return "VoiceChatScheduled{" +
                "start_date=" + start_date +
                '}';
    }
    
}
