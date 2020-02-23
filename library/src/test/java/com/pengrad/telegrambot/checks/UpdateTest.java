package com.pengrad.telegrambot.checks;

import com.pengrad.telegrambot.model.Update;

import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * stas
 * 10/21/15.
 */
public class UpdateTest {

    public static void check(List<Update> updates) {
        for (Update update : updates) {
            assertTrue(update.updateId() > 0);
            if (update.message() != null) MessageTest.checkMessage(update.message());
            if (update.editedMessage() != null) MessageTest.checkMessage(update.editedMessage());
            if (update.inlineQuery() != null) InlineQueryTest.checkQuery(update.inlineQuery());
            if (update.chosenInlineResult() != null) ChosenInlineResultTest.check(update.chosenInlineResult());
            if (update.channelPost() != null) MessageTest.checkMessage(update.channelPost());
            if (update.editedChannelPost() != null) MessageTest.checkMessage(update.editedChannelPost());
            if (update.callbackQuery() != null) assertNotNull(update.callbackQuery().id());
            if (update.shippingQuery() != null) assertNotNull(update.shippingQuery().id());
            if (update.preCheckoutQuery() != null) assertNotNull(update.preCheckoutQuery().id());
            if (update.poll() != null) assertNotNull(update.poll().id());
            if (update.pollAnswer() != null) assertNotNull((update.pollAnswer().pollId()));
        }
    }

}
