package com.pengrad.telegrambot;

import com.google.gson.*;
import com.pengrad.telegrambot.model.*;
import com.pengrad.telegrambot.request.*;

import org.junit.*;

import java.util.concurrent.*;
import java.util.function.*;

import okhttp3.*;

import static org.junit.Assert.*;

/**
 * Stas Parshin
 * 26 January 2020
 */
public class TelegramBotBuilderTest {

    Consumer<Interceptor.Chain> interceptorBlock = null;

    final String token = "Token";
    final TelegramBot.Builder builder = new TelegramBot.Builder(token)
            .okHttpClient(new OkHttpClient.Builder()
                    .addInterceptor(chain -> {
                        if (interceptorBlock != null) interceptorBlock.accept(chain);
                        return chain.proceed(chain.request());
                    })
                    .build()
            );

    @Test
    public void apiUrl() throws InterruptedException {
        String apiUrl = "http://google.com/bot";
        TelegramBot bot = builder.apiUrl(apiUrl).build();

        CountDownLatch latch = new CountDownLatch(1);
        interceptorBlock = (chain) -> {
            assertEquals(chain.request().url().toString(), apiUrl + token + "/getMe");
            latch.countDown();
        };
        try {
            bot.execute(new GetMe());
        } catch (Exception ignored) {}

        assertTrue(latch.await(5, TimeUnit.SECONDS));
    }

    @Test
    public void fileApiUrl() {
        String fileApiUrl = "fileApiUrl";
        File file = new Gson().fromJson("{file_path:\"path\"}", File.class);

        TelegramBot bot = builder.fileApiUrl(fileApiUrl).build();
        String path = bot.getFullFilePath(file);

        assertEquals(path, fileApiUrl + token + "/path");
    }

    @Test
    public void updateListenerSleep() throws InterruptedException {
        int sleepTime = 500;
        TelegramBot bot = builder.updateListenerSleep(sleepTime).build();
        CountDownLatch latch = new CountDownLatch(1);
        bot.setUpdatesListener(updates -> 0, new ExceptionHandler() {
            Long firstErrorTime;

            @Override
            public void onException(TelegramException e) {
                if (firstErrorTime == null) {
                    firstErrorTime = System.currentTimeMillis();
                } else {
                    long diff = System.currentTimeMillis() - firstErrorTime;
                    assertTrue(diff >= sleepTime);
                    latch.countDown();
                }
            }
        });

        assertTrue(latch.await(5, TimeUnit.SECONDS));
    }

}