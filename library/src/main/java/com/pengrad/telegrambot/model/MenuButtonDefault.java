package com.pengrad.telegrambot.model;

import java.io.Serializable;

/**
 * Mirco Ianese
 * 20 Apr 2022
 */
public class MenuButtonDefault extends MenuButton implements Serializable {
 
    private final static long serialVersionUID = 0L;

    public MenuButtonDefault() {
        super("default");
    }
}
