package com.pengrad.telegrambot.sample.spark;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.Keyboard;
import com.pengrad.telegrambot.model.request.ReplyKeyboardMarkup;
import com.pengrad.telegrambot.request.SendMessage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import rx.Observable;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * stas
 * 4/5/16.
 */
public class AqivnBot extends BotHandler {

    private String[] icons = new String[]{"\uD83D\uDE3B", "\uD83D\uDC4C", "\uD83D\uDE11", "\uD83D\uDE3E", "\uD83D\uDE37", "\uD83D\uDC80"};
    private final String token;
    private final TelegramBot bot;

    public AqivnBot() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("local.properties"));
        token = properties.getProperty("AQIVN_TOKEN");
        bot = new TelegramBot.Builder(token).debug().build();
    }

    @Override
    String getToken() {
        return token;
    }

    @Override
    TelegramBot getBot() {
        return bot;
    }

    @Override
    void onWebhookUpdate(Update update) {
        bot.execute(new SendMessage(update.message().chat().id(), getAqi()).replyMarkup(simpleKeyboard()));
    }

    private String getAqi() {
        return getWebPage("http://www.aqivn.org/en/")
                .map(this::documentToAqiString)
                .toBlocking().first();
    }

    private Keyboard simpleKeyboard() {
        return new ReplyKeyboardMarkup(new String[]{"Get!"});
    }

    private String documentToAqiString(Document document) {
        String text = document.select("div.well-sm > h2").get(0).text();
        int index = text.lastIndexOf(':');
        try {
            String strValue = text.substring(index + 2, text.length() - 1).trim();
            int aqi = Integer.parseInt(strValue);
            return icons[categoryByAqi(aqi)] + " " + text;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return text;
    }

    private int categoryByAqi(int aqi) {
        if (aqi < 50) return 0;
        else if (aqi < 100) return 1;
        else if (aqi < 150) return 2;
        else if (aqi < 200) return 3;
        else if (aqi < 300) return 4;
        else return 5;
    }

    private Observable<Document> getWebPage(String url) {
        return Observable.<Document>create(subscriber -> {
            try {
                Document document = Jsoup.connect(url).get();
                subscriber.onNext(document);
                subscriber.onCompleted();
            } catch (IOException e) {
                subscriber.onError(e);
            }
        }).retry(2);
    }

    public static void main(String[] args) throws IOException {
        AqivnBot bot = new AqivnBot();
        bot.getWebPage("http://www.aqivn.org/en/")
                .map(bot::documentToAqiString)
                .subscribe(str -> {
                    System.out.println(str);
                    bot.bot.execute(new SendMessage(51314083, str));
                });


    }
}
