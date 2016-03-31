package com.pengrad.telegrambot;

import com.pengrad.telegrambot.impl.BotApi;
import com.pengrad.telegrambot.impl.FileApi;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * stas
 * 8/4/15.
 */
public class TelegramBotAdapter {

    public static final String API_URL = "https://api.telegram.org/bot";

    public static TelegramBot build(String botToken) {
        Retrofit retrofit = prepare(botToken).build();
        BotApi botApi = retrofit.create(BotApi.class);
        FileApi fileApi = new FileApi(botToken);
        return new TelegramBot(botApi, fileApi);
    }

    public static TelegramBot buildDebug(String botToken) {
        Retrofit retrofit = prepare(botToken)
                // interceptor
                .build();
        BotApi botApi = retrofit.create(BotApi.class);
        FileApi fileApi = new FileApi(botToken);
        return new TelegramBot(botApi, fileApi);
    }

    public static Retrofit.Builder prepare(String botToken) {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();


        return new Retrofit.Builder()
                .baseUrl(API_URL + botToken + "/")
                .client(client)
                .addCallAdapterFactory(new SynchronousCallAdapterFactory())
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create());

    }

    public static class SynchronousCallAdapterFactory extends CallAdapter.Factory {
        public static CallAdapter.Factory create() {
            return new SynchronousCallAdapterFactory();
        }

        @Override
        public CallAdapter<Object> get(final Type returnType, Annotation[] annotations, Retrofit retrofit) {
            // if returnType is retrofit2.Call, do nothing
            if (returnType.getTypeName().contains("retrofit2.Call")) {
                return null;
            }

            return new CallAdapter<Object>() {
                @Override
                public Type responseType() {
                    return returnType;
                }

                @Override
                public <R> Object adapt(Call<R> call) {
                    try {
                        return call.execute().body();
                    } catch (IOException e) {
                        throw new RuntimeException(); // do something better
                    }
                }
            };
        }
    }
}
