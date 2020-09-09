package com.pengrad.telegrambot.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * Stas Parshin
 * 31 March 2020
 */
public class BotCommand implements Serializable {
    private final static long serialVersionUID = 0L;

    public BotCommand(String command, String description) {
        this.command = command;
        this.description = description;
    }

    BotCommand() {}

    private String command;
    private String description;

    public String command() {
        return command;
    }

    public String description() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BotCommand that = (BotCommand) o;

        if (!Objects.equals(command, that.command)) return false;
        return Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        int result = command != null ? command.hashCode() : 0;
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BotCommand{" +
                "command='" + command + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
