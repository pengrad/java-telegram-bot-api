package com.pengrad.telegrambot;

import com.google.gson.Gson;
import com.pengrad.telegrambot.impl.FileApi;
import com.pengrad.telegrambot.impl.TelegramBotClient;
import com.pengrad.telegrambot.impl.UpdatesHandler;
import com.pengrad.telegrambot.model.File;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.response.BaseResponse;
import com.pengrad.telegrambot.utility.BotUtils;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.TimeUnit;

import static com.pengrad.telegrambot.RequestPreprocessorKt.getEmptyRequestPreprocessor;

/**
 * Stas Parshin
 * 16 October 2015
 */
public class TelegramBot implements TelegramAware {

    private final String token;
    private final TelegramBotClient api;
    private final FileApi fileApi;
    private final UpdatesHandler updatesHandler;
    private final RequestPreprocessor requestPreprocessor;

    public TelegramBot(String botToken) {
        this(new Builder(botToken));
    }

    TelegramBot(Builder builder) {
        this.token = builder.botToken;
        this.api = builder.api;
        this.fileApi = builder.fileApi;
        this.updatesHandler = builder.updatesHandler;
        this.requestPreprocessor = builder.requestPreprocessor;
    }

    @NotNull
    public <T extends BaseRequest<T, R>, R extends BaseResponse> R execute(@NotNull BaseRequest<T, R> request) {
        requestPreprocessor.process(request);
        return api.send(request);
    }

    public <T extends BaseRequest<T, R>, R extends BaseResponse> Cancellable execute(T request, Callback<T, R> callback) {
        requestPreprocessor.process(request);
        return api.send(request, callback);
    }

    public String getToken() {
        return token;
    }

    public String getFullFilePath(File file) {
        return fileApi.getFullFilePath(file.filePath());
    }

    public byte[] getFileContent(File file) throws IOException {
        String fileUrl = getFullFilePath(file);
        URLConnection connection = new URL(fileUrl).openConnection();
        try (InputStream is = connection.getInputStream()) {
            return BotUtils.getBytesFromInputStream(is);
        }
    }

    public void setUpdatesListener(UpdatesListener listener) {
        setUpdatesListener(listener, new GetUpdates());
    }

    public void setUpdatesListener(UpdatesListener listener, GetUpdates request) {
        setUpdatesListener(listener, null, request);
    }

    public void setUpdatesListener(UpdatesListener listener, ExceptionHandler exceptionHandler) {
        setUpdatesListener(listener, exceptionHandler, new GetUpdates());
    }

    public void setUpdatesListener(UpdatesListener listener, ExceptionHandler exceptionHandler, GetUpdates request) {
        updatesHandler.stop();
        updatesHandler.start(this, listener, exceptionHandler, request);
    }

    public void removeGetUpdatesListener() {
        updatesHandler.stop();
    }

    public void shutdown() {
        api.shutdown();
    }

    public static final class Builder {

        static final String API_URL = "https://api.telegram.org/bot";

        private final String botToken;
        private FileApi fileApi;
        private TelegramBotClient api;
        private UpdatesHandler updatesHandler;
        private RequestPreprocessor requestPreprocessor;

        private OkHttpClient okHttpClient;
        private String apiUrl;
        private String fileApiUrl;
        private boolean useTestServer = false;

        public Builder(String botToken) {
            this.botToken = botToken;
            api = new TelegramBotClient(client(null), gson(), apiUrl(API_URL, botToken, useTestServer));
            fileApi = new FileApi(botToken);
            updatesHandler = new UpdatesHandler(100);
            requestPreprocessor = getEmptyRequestPreprocessor();
        }

        public Builder debug() {
            okHttpClient = client(httpLoggingInterceptor());
            return this;
        }

        public Builder okHttpClient(OkHttpClient client) {
            okHttpClient = client;
            return this;
        }

        public Builder apiUrl(String apiUrl) {
            this.apiUrl = apiUrl;
            return this;
        }

        public Builder fileApiUrl(String fileApiUrl) {
            this.fileApiUrl = fileApiUrl;
            return this;
        }

        public Builder updateListenerSleep(long millis) {
            updatesHandler = new UpdatesHandler(millis);
            return this;
        }

        public Builder useTestServer(boolean useTestServer) {
            this.useTestServer = useTestServer;
            return this;
        }

        public Builder requestPreprocessor(RequestPreprocessor requestPreprocessor) {
            this.requestPreprocessor = requestPreprocessor;
            return this;
        }

        public TelegramBot build() {
            if (okHttpClient != null || apiUrl != null) {
                OkHttpClient client = okHttpClient != null ? okHttpClient : client(null);
                String baseUrl = apiUrl(apiUrl != null ? apiUrl : API_URL, botToken, useTestServer);
                api = new TelegramBotClient(client, gson(), baseUrl);
            }
            if (fileApiUrl != null) {
                fileApi = new FileApi(fileApiUrl, botToken);
            }
            return new TelegramBot(this);
        }

        private static OkHttpClient client(Interceptor interceptor) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder()
                    .connectTimeout(75, TimeUnit.SECONDS)
                    .writeTimeout(75, TimeUnit.SECONDS)
                    .readTimeout(75, TimeUnit.SECONDS);
            if (interceptor != null) builder.addInterceptor(interceptor);
            return builder.build();
        }

        private static Interceptor httpLoggingInterceptor() {
            return new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY);
        }

        private static Gson gson() {
            return BotUtils.GSON;
        }

        private static String apiUrl(String apiUrl, String botToken, boolean useTestServer) {
            return apiUrl + botToken + (useTestServer ? "/test/" : "/");
        }
    }
}
