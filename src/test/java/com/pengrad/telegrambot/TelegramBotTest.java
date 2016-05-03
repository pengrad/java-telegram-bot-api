package com.pengrad.telegrambot;

import com.pengrad.telegrambot.request.GetMe;
import com.pengrad.telegrambot.request.KickChatMember;
import com.pengrad.telegrambot.response.BaseResponse;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * stas
 * 5/2/16.
 */
public class TelegramBotTest {

    TelegramBot bot;
    Integer chatId, forwardMessageId;
    String channelName = "@bottest";
    Long channelId = -1001002720332L;
    String stickerId;
    String imagefile = getClass().getClassLoader().getResource("image.png").getFile();
    String audioFile = getClass().getClassLoader().getResource("beep.mp3").getFile();
    String docFile = getClass().getClassLoader().getResource("doc.txt").getFile();
    String videoFile = getClass().getClassLoader().getResource("tabs.mp4").getFile();

    public TelegramBotTest() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("local.properties"));
        bot = TelegramBotAdapter.buildDebug(properties.getProperty("TEST_TOKEN"));
        chatId = Integer.parseInt(properties.getProperty("CHAT_ID"));
        forwardMessageId = Integer.parseInt(properties.getProperty("FORWARD_MESSAGE"));
        stickerId = properties.getProperty("STICKER_FILE_ID");
    }

    @Test
    public void getMe() {
        bot.execute(new GetMe());
    }

    @Test
    public void kickChatMember() {
        BaseResponse response = bot.execute(new KickChatMember(channelName, chatId));
        System.out.println(response);
    }

}
