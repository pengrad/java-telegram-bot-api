package com.pengrad.telegrambot.model;

import java.io.Serializable;

/**
 * Mirco Ianese
 * 20 Apr 2022
 */
public class MenuButtonCommands extends MenuButton<MenuButtonCommands> implements Serializable {
    
    private final static long serialVersionUID = 0L;

    public MenuButtonCommands() {
        super("commands");
    }
}
