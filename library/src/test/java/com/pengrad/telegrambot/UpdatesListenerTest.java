package com.pengrad.telegrambot;

import com.pengrad.telegrambot.model.Update;
import okhttp3.*;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import java.util.logging.ConsoleHandler;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import static org.junit.Assert.*;

/**
 * Stas Parshin
 * 17 June 2019
 */
public class UpdatesListenerTest {

    public static String token() {
        String token;
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("local.properties"));
            token = properties.getProperty("TEST_TOKEN");
        } catch (Exception e) {
            token = System.getenv("TEST_TOKEN");
        }
        return token;
    }

    private TelegramBot bot;

    @Before
    public void initBot() {
        bot = new TelegramBot.Builder(token()).debug().build();
    }

    @Test
    public void receiveUpdates() throws InterruptedException {
        withLatch(1, latch -> {
            AtomicInteger i = new AtomicInteger(1);
            bot = new TelegramBot.Builder(token())
                    .okHttpClient(new OkHttpClient.Builder()
                            .addInterceptor(chain -> {
                                Response response = new Response.Builder()
                                        .request(chain.request())
                                        .protocol(Protocol.HTTP_2)
                                        .code(1)
                                        .message("")
                                        .build();
                                response = response.newBuilder().body(ResponseBody
                                        .create(MediaType.parse("application/json"),
                                                "{\"ok\":true,\"result\":[{\"update_id\":" + i.getAndIncrement() + "}]}"
                                        )).build();
                                return response;
                            })
                            .build())
                    .build();
            bot.setUpdatesListener(updates -> {
                Update u = updates.get(0);
                switch (u.updateId()) {
                    case 1:
                        return UpdatesListener.CONFIRMED_UPDATES_NONE;
                    case 2:
                        return UpdatesListener.CONFIRMED_UPDATES_ALL;
                    case 3:
                        return 3;
                    default: {
                        latch.countDown();
                        return 0;
                    }
                }
            });
        });
        bot.removeGetUpdatesListener();
    }

    @Test
    public void telegramError() throws InterruptedException {
        withLatch(3, latch -> {
            bot = new TelegramBot("12312312:token");
            bot.setUpdatesListener(updates -> 0, e -> {
                assertFalse(e.response().isOk());
                assertEquals(401, e.response().errorCode());
                assertNull(e.getCause());
                latch.countDown();
            });
        });
    }

    @Test
    public void telegramErrorLogging() throws InterruptedException {
        withLatch(3, latch -> {
            bot = new TelegramBot("12312312:token");
            bot.setUpdatesListener(updates -> 0);
            Logger logger = Logger.getLogger(OkHttpClient.class.getName());
            logger.addHandler(new OneShotHandler(() -> {
                System.out.println("get log");
                latch.countDown();
            }));
        });
    }


    @Test
    public void ioError() throws InterruptedException {
        withLatch(1, (latch) -> {
            bot = new TelegramBot.Builder(token())
                    .okHttpClient(new OkHttpClient.Builder().callTimeout(Duration.ofMillis(1)).build())
                    .build();
            bot.setUpdatesListener(updates -> 0, e -> {
                assertNull(e.response());
                latch.countDown();
            });
        });
    }

    @Test
    public void ioErrorLogging() throws Exception {
        withLatch(1, (latch) -> {
            bot = new TelegramBot.Builder(token())
                    .okHttpClient(new OkHttpClient.Builder().callTimeout(Duration.ofMillis(1)).build())
                    .build();
            bot.setUpdatesListener(updates -> 0);
            Logger logger = Logger.getLogger(OkHttpClient.class.getName());
            logger.addHandler(new OneShotHandler(() -> {
                System.out.println("get log");
                latch.countDown();
            }));
        });
    }

    private void withLatch(int secTimeout, Consumer<CountDownLatch> body) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1);
        body.accept(latch);
        assertTrue(latch.await(secTimeout, TimeUnit.SECONDS));
    }

    private static class OneShotHandler extends ConsoleHandler {
        Runnable runnable;

        public OneShotHandler(Runnable runnable) {
            this.runnable = runnable;
        }

        @Override
        public void publish(LogRecord record) {
            if (runnable != null) runnable.run();
            runnable = null;
        }
    }
}
