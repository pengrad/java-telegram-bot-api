package com.pengrad.telegrambot;

import com.pengrad.telegrambot.response.BaseResponse;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.reflect.KClass;
import org.junit.Before;
import org.junit.Test;
import org.reflections.Reflections;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Optional;
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
            KClass<? extends BaseResponse> kclass = JvmClassMappingKt.getKotlinClass(c);

            if (kclass.isData()) {
                continue;
            }

            Optional<Constructor<?>> constructor = Arrays.stream(c.getDeclaredConstructors()).filter(dc -> dc.getParameterCount() == 0).findFirst();
            assertTrue("No default constructor in " + c.getSimpleName(), constructor.isPresent());
            constructor.get().setAccessible(true);
            String toString = constructor.get().newInstance().toString();
            for (Field f : c.getDeclaredFields()) {
                if (Modifier.isStatic(f.getModifiers())) {
                    continue;
                }
                assertTrue(c.getSimpleName() + " toString doesn't contain " + f.getName(), toString.contains(f.getName()));
            }
        }
    }
}
