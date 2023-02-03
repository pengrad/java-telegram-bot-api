package com.pengrad.telegrambot.model;

import java.io.Serializable;

public class GeneralForumTopicUnhidden implements Serializable {
    private final static long serialVersionUID = 0L;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        return o != null && getClass() == o.getClass();
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
