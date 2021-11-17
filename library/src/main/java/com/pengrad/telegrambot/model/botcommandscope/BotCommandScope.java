package com.pengrad.telegrambot.model.botcommandscope;

import java.io.Serializable;

public abstract class BotCommandScope implements Serializable {
    private final static long serialVersionUID = 0L;

    protected String type = "default";
    
}