package com.pengrad.telegrambot;

import com.pengrad.telegrambot.response.BaseResponse;
import org.junit.Before;
import org.junit.Test;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Set;

import static org.junit.Assert.assertTrue;

/**
 * Stas Parshin
 * 31 May 2017
 */
public class ResponseTest {

    private Set<Class<? extends BaseResponse>> classes;

    @Before
    public void setClasses() {
        Reflections reflections = new Reflections(BaseResponse.class.getPackage().getName());
        classes = reflections.getSubTypesOf(BaseResponse.class);
        classes.add(BaseResponse.class);
    }

    @Test
    public void testToString() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        for (Class<? extends BaseResponse> c : classes) {
            Constructor<?> constructor = c.getDeclaredConstructors()[0];
            constructor.setAccessible(true);
            String toString = constructor.newInstance().toString();
            for (Field f : c.getDeclaredFields()) {
                if (Modifier.isStatic(f.getModifiers())) {
                    continue;
                }
                assertTrue(c.getSimpleName() + " toString doesn't contain " + f.getName(), toString.contains(f.getName()));
            }
        }
    }
}
