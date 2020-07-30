package com.pengrad.telegrambot.impl;

import com.google.gson.Gson;
import com.pengrad.telegrambot.BotUtils;
import com.pengrad.telegrambot.model.request.Keyboard;
import com.pengrad.telegrambot.model.request.KeyboardButton;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.model.request.ReplyKeyboardMarkup;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.SendPoll;
import com.pengrad.telegrambot.response.SendResponse;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okio.Buffer;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class TelegramBotClientTest {
    static final TelegramBotClient client = new TelegramBotClient(new OkHttpClient.Builder().build(), new Gson(),"SomeBaseUrl");

    @Test
    public void sendMessageBody() throws IOException {
        Keyboard oldKeyboard = new ReplyKeyboardMarkup(
                new String[]{"Button0.1","Button0.2"},
                new String[]{"Button1.1","Button1.2"})
                .oneTimeKeyboard(true)
                .resizeKeyboard(true);

        SendMessage oldRequest = new SendMessage("chatId","ChattieChat").parseMode(ParseMode.MarkdownV2).replyMarkup(oldKeyboard);

        RequestBody oldRequestBody = client.createRequestBody(oldRequest);
        Buffer oldBuffer = new Buffer();
        oldRequestBody.writeTo(oldBuffer);
        String oldBody = oldBuffer.readUtf8();

        String expected = String.join("&",
                "chat_id=chatId",
                "text=ChattieChat",
                "parse_mode=MarkdownV2",
                "reply_markup="+ URLEncoder.encode("{\"keyboard\":" +
                        "[" +
                            "[" +
                                "{\"text\":\"Button0.1\",\"request_contact\":false,\"request_location\":false}," +
                                "{\"text\":\"Button0.2\",\"request_contact\":false,\"request_location\":false}" +
                            "]," +
                            "[" +
                                "{\"text\":\"Button1.1\",\"request_contact\":false,\"request_location\":false}," +
                                "{\"text\":\"Button1.2\",\"request_contact\":false,\"request_location\":false}" +
                            "]" +
                        "]," +
                        "\"resize_keyboard\":true,\"one_time_keyboard\":true,\"selective\":false" +
                        "}",StandardCharsets.UTF_8.displayName()
                )
        );

        Assert.assertEquals(expected, oldBody);

        Keyboard newKeyboard = new ReplyKeyboardMarkup().addRow("Button0.1","Button0.2").addRow("Button1.1","Button1.2").oneTimeKeyboard(true).resizeKeyboard(true);
        SendMessage newRequest = new SendMessage("chatId","ChattieChat").parseMode(ParseMode.MarkdownV2).replyMarkup(newKeyboard);

        RequestBody newRequestBody = client.createRequestBody(newRequest);
        Buffer newBuffer = new Buffer();
        newRequestBody.writeTo(newBuffer);
        String newBody = newBuffer.readUtf8();
        Assert.assertEquals(oldBody,newBody);
    }

    @Test
    public void sendPollBody() throws IOException {
        SendPoll request = new SendPoll("chatId", "Huh", "Bird", "Bear", "Chicken");
        RequestBody requestBody = client.createRequestBody(request);
        Buffer sink = new Buffer();
        requestBody.writeTo(sink);
        Assert.assertEquals("chat_id=chatId&question=Huh&options=%5B%22Bird%22%2C%22Bear%22%2C%22Chicken%22%5D", sink.readUtf8());
    }

    @Test
    public void parseSendResponseBadRequest() {
        String responseFromTelegram = "{\"ok\":false,\"error_code\":400,\"description\":\"Bad Request: message can't be edited\"}";
        SendResponse response = BotUtils.fromJson(responseFromTelegram,SendResponse.class);
        Assert.assertNotNull(response);
        Assert.assertFalse(response.isOk());
    }

    @Test
    public void parseNull() {
        Assert.assertNull(BotUtils.fromJson(null,SendResponse.class));
        Assert.assertNull(BotUtils.fromJson("",SendResponse.class));
    }

    @Test
    public void toParamValue() {
        Assert.assertEquals("1",client.toParamValue(1));
        Assert.assertEquals("1.1",client.toParamValue(1.1F));
        Assert.assertEquals("Bird",client.toParamValue("Bird"));
        Assert.assertEquals("[\"Bird\",\"Bear\",\"Chicken\"]",client.toParamValue(new String[] {"Bird", "Bear", "Chicken"}));
        Assert.assertEquals("{\"text\":\"Bird\",\"request_contact\":false,\"request_location\":false}",client.toParamValue(new KeyboardButton("Bird")));
    }
}