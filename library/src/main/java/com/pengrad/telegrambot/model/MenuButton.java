package com.pengrad.telegrambot.model;

import java.io.Serializable;

/**
 * Mirco Ianese
 * 20 Apr 2022
 */
public class MenuButton<T extends MenuButton<T>> implements Serializable {
   
    private final static long serialVersionUID = 0L;
    
    private final String type;

    public MenuButton(String type) {
        this.type = type;
    }
}
