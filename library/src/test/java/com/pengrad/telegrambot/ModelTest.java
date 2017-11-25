package com.pengrad.telegrambot;

import com.pengrad.telegrambot.model.Animation;
import com.pengrad.telegrambot.model.CallbackQuery;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.junit.Before;
import org.junit.Test;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

/**
 * Stas Parshin
 * 31 May 2017
 */
public class ModelTest {

    private Set<Class> classes;

    @Before
    public void setClasses() {
        String modelPackage = Animation.class.getPackage().getName();
        Reflections reflections = new Reflections(modelPackage, new SubTypesScanner(false));
        Set<Class<?>> allSubPackageClasses = reflections.getSubTypesOf(Object.class);
        classes = allSubPackageClasses
                .stream()
                .filter(c -> c.getPackage().getName().equals(modelPackage))
                .collect(Collectors.toSet());
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
