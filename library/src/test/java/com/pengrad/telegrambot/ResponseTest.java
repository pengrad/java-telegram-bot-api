package com.pengrad.telegrambot;

import com.pengrad.telegrambot.response.*;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;

import static org.junit.Assert.assertTrue;

/**
 * Stas Parshin
 * 31 May 2017
 */
public class ResponseTest {

    private Class[] classes;

    @Before
    public void setClasses() {
        classes = new Class[]{
                BaseResponse.class,
                GetChatAdministratorsResponse.class,
                GetChatMemberResponse.class,
                GetChatMembersCountResponse.class,
                GetChatResponse.class,
                GetFileResponse.class,
                GetGameHighScoresResponse.class,
                GetMeResponse.class,
                GetUpdatesResponse.class,
                GetUserProfilePhotosResponse.class,
                GetWebhookInfoResponse.class,
                SendResponse.class,
                StringResponse.class
        };
    }

    @Test
    public void testToString() throws IllegalAccessException, InstantiationException, InvocationTargetException {
        for (Class c : classes) {
            Constructor constructor = c.getDeclaredConstructors()[0];
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
