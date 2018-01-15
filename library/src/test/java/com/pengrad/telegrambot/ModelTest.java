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
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

/**
 * Stas Parshin
 * 31 May 2017
 */
public class ModelTest {

    private Set<Class> classes;

    private Random random = new Random();

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
    private Object getRandomValueForField(Field field) throws IllegalAccessException, InstantiationException {
        Class<?> type = field.getType();

        if (type.isEnum()) {
            Object[] enumValues = type.getEnumConstants();
            return enumValues[random.nextInt(enumValues.length)];
        } else if (type.equals(Integer.TYPE) || type.equals(Integer.class)) {
            return random.nextInt();
        } else if (type.equals(Long.TYPE) || type.equals(Long.class)) {
            return random.nextLong();
        } else if (type.equals(Double.TYPE) || type.equals(Double.class)) {
            return random.nextDouble();
        } else if (type.equals(Float.TYPE) || type.equals(Float.class)) {
            return random.nextFloat();
        } else if (type.equals(Boolean.class)) {
            return random.nextBoolean();
        }
        return type.newInstance();
    }

    @Test
    public void testToString() throws IllegalAccessException, InstantiationException {
        for (Class c : classes) {
            Object instance = c.newInstance();
            String toString = instance.toString();
            for (Field f : c.getDeclaredFields()) {
                if (Modifier.isStatic(f.getModifiers())) {
                    continue;
                }
                if (classes.contains(f.getType()) || f.getType().isArray()) {
                    continue;
                }
                f.setAccessible(true);
                if (f.get(instance) == null) {
                    f.set(instance, getRandomValueForField(f));
                }
                assertTrue(c.getSimpleName() + " toString doesn't contain " + f.getName(), toString.contains(f.getName()));
            }
        }
    }
}
