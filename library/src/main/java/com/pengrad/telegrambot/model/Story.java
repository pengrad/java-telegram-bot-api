package com.pengrad.telegrambot.model;

import java.io.Serializable;

/**
 * 
 * 18/08/2023.
 */

public class Story implements Serializable {    
    private final static long serialVersionUID = 0L;


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Story story = (Story) o;
        // todo: fix when fields are added
        return true;
    }

    @Override
    public int hashCode() {
        // todo: fix when fields are added
        return 0;
    }

    @Override
    public String toString() {
        // todo: fix when fields are added
        return "Story{" + '}';
    }

}
