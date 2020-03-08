package com.pengrad.telegrambot;

import com.pengrad.telegrambot.model.request.*;
import com.pengrad.telegrambot.passport.*;

import org.junit.*;
import org.reflections.*;
import org.reflections.scanners.*;

import java.lang.reflect.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

import nl.jqno.equalsverifier.*;

import static org.junit.Assert.*;

/**
 * Stas Parshin
 * 31 May 2017
 */
public class ModelTest {

    private Set<Class> classes;
    private HashMap<Class, Supplier<Object>> customInstance = new HashMap<>();

    @Before
    public void setClasses() {
        String passportPackage = Credentials.class.getPackage().getName();
        List<String> packages = Collections.singletonList(passportPackage);

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
    public void testEquals() throws IllegalAccessException, InstantiationException, NoSuchFieldException {
        for (Class c : classes) {
            EqualsVerifier.forClass(c)
                    .usingGetClass()
                    .suppress(Warning.STRICT_HASHCODE)
                    .suppress(Warning.NONFINAL_FIELDS)
                    .verify();
        }
    }

    @Test
    public void testToString() throws IllegalAccessException, InstantiationException {
        for (Class c : classes) {
            Object instance = customInstance.containsKey(c) ? customInstance.get(c).get() : c.newInstance();
            String toString = instance.toString();
            for (Field f : c.getDeclaredFields()) {
                if (Modifier.isStatic(f.getModifiers())) {
                    continue;
                }
                assertTrue(c.getSimpleName() + " toString doesn't contain " + f.getName(), toString.contains(f.getName()));
            }
        }
    }
}
