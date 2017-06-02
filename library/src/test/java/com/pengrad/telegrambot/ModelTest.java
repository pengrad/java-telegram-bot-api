package com.pengrad.telegrambot;

import com.pengrad.telegrambot.model.*;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import static org.junit.Assert.assertTrue;

/**
 * Stas Parshin
 * 31 May 2017
 */
public class ModelTest {

    private Class[] classes;

    @Before
    public void setClasses() {
        classes = new Class[]{
                Animation.class,
                Audio.class,
                CallbackQuery.class,
                Chat.class,
                ChatMember.class,
                ChosenInlineResult.class,
                Contact.class,
                Document.class,
                File.class,
                Game.class,
                GameHighScore.class,
                InlineQuery.class,
                Invoice.class,
                Location.class,
                Message.class,
                MessageEntity.class,
                OrderInfo.class,
                PhotoSize.class,
                PreCheckoutQuery.class,
                ResponseParameters.class,
                ShippingAddress.class,
                ShippingQuery.class,
                Sticker.class,
                SuccessfulPayment.class,
                Update.class,
                User.class,
                UserProfilePhotos.class,
                Venue.class,
                Video.class,
                VideoNote.class,
                Voice.class,
                WebhookInfo.class
        };
    }

    @Test
    public void testEquals() throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        Object callbackQuery = CallbackQuery.class.newInstance();
        Field f = CallbackQuery.class.getDeclaredField("id");
        f.setAccessible(true);
        f.set(callbackQuery, "2");

        Object message = Message.class.newInstance();
        f = Message.class.getDeclaredField("message_id");
        f.setAccessible(true);
        f.set(message, 11);

        Object update = Update.class.newInstance();
        f = Update.class.getDeclaredField("update_id");
        f.setAccessible(true);
        f.set(update, 1);

        for (Class c : classes) {
            EqualsVerifier.forClass(c)
                    .usingGetClass()
                    .withPrefabValues(Update.class, Update.class.newInstance(), update)
                    .withPrefabValues(Message.class, Message.class.newInstance(), message)
                    .withPrefabValues(CallbackQuery.class, CallbackQuery.class.newInstance(), callbackQuery)
                    .suppress(Warning.STRICT_HASHCODE)
                    .suppress(Warning.NONFINAL_FIELDS)
                    .verify();
        }
    }

    @Test
    public void testToString() throws IllegalAccessException, InstantiationException {
        for (Class c : classes) {
            String toString = c.newInstance().toString();
            for (Field f : c.getDeclaredFields()) {
                if (Modifier.isStatic(f.getModifiers())) {
                    continue;
                }
                assertTrue(c.getSimpleName() + " toString doesn't contain " + f.getName(), toString.contains(f.getName()));
            }
        }
    }
}
