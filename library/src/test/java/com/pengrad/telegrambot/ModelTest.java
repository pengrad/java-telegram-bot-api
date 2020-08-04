package com.pengrad.telegrambot;

import com.pengrad.telegrambot.model.Animation;
import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.InlineKeyboardButton;
import com.pengrad.telegrambot.model.request.InlineKeyboardMarkup;
import com.pengrad.telegrambot.passport.Credentials;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.Before;
import org.junit.Test;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

/**
 * Stas Parshin
 * 31 May 2017
 */
public class ModelTest {

    private Set<Class<?>> classes;
    private final Map<Class<?>, Supplier<Object>> customInstance = new HashMap<>();

    @Before
    public void setClasses() {
        String modelPackage = Animation.class.getPackage().getName();
        String passportPackage = Credentials.class.getPackage().getName();
        List<String> packages = Arrays.asList(modelPackage, passportPackage);

        classes = new Reflections(packages, new SubTypesScanner(false))
                .getSubTypesOf(Object.class)
                .stream()
                .filter(clazz -> packages.contains(clazz.getPackage().getName())
                        && !clazz.getSimpleName().startsWith("PassportElementError")
                        && !Modifier.isAbstract(clazz.getModifiers())
                ).collect(Collectors.toSet());

        // classes from model/request available in responses
        classes.add(InlineKeyboardMarkup.class);
        classes.add(InlineKeyboardButton.class);
        customInstance.put(InlineKeyboardMarkup.class, InlineKeyboardMarkup::new);
        customInstance.put(InlineKeyboardButton.class, () -> new InlineKeyboardButton(""));
    }

    @Test
    public void testEquals() throws ReflectiveOperationException {
        CallbackQuery callbackQuery = CallbackQuery.class.getDeclaredConstructor().newInstance();
        Field f = CallbackQuery.class.getDeclaredField("id");
        f.setAccessible(true);
        f.set(callbackQuery, "2");

        Message message = Message.class.getDeclaredConstructor().newInstance();
        f = Message.class.getDeclaredField("message_id");
        f.setAccessible(true);
        f.set(message, 11);

        Update update = Update.class.getDeclaredConstructor().newInstance();
        f = Update.class.getDeclaredField("update_id");
        f.setAccessible(true);
        f.set(update, 1);

        for (Class<?> c : classes) {
            EqualsVerifier.forClass(c)
                    .usingGetClass()
                    .withPrefabValues(Update.class, Update.class.getDeclaredConstructor().newInstance(), update)
                    .withPrefabValues(Message.class, Message.class.getDeclaredConstructor().newInstance(), message)
                    .withPrefabValues(CallbackQuery.class, CallbackQuery.class.getDeclaredConstructor().newInstance(), callbackQuery)
                    .suppress(Warning.STRICT_HASHCODE)
                    .suppress(Warning.NONFINAL_FIELDS)
                    .verify();
        }
    }

    @Test
    public void testToString() throws Exception {
        for (Class<?> c : classes) {
            Object instance = customInstance.containsKey(c) ? customInstance.get(c).get() : defaultInstance(c);
            String toString = instance.toString();
            for (Field f : c.getDeclaredFields()) {
                if (Modifier.isStatic(f.getModifiers())) {
                    continue;
                }
                assertTrue(c.getSimpleName() + " toString doesn't contain " + f.getName(), toString.contains(f.getName()));
            }
        }
    }

    private <R> R defaultInstance(Class<R> c) throws Exception {
        Constructor<R> constructor = c.getDeclaredConstructor();
        constructor.setAccessible(true);
        return constructor.newInstance();
    }
}
