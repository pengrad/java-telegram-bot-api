package com.pengrad.telegrambot.sample.spark;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.ReplyKeyboardMarkup;
import com.pengrad.telegrambot.request.SendMessage;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import spark.Request;
import spark.Response;
import spark.Route;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * stas
 * 8/4/15.
 */
public class KursBot implements Route {

    private final TelegramBot bot;

    public final String BUTTON_CB = "ЦБ";
    public final String BUTTON_EXCHANGE = "Биржа";
    public final String BUTTON_OIL = "Нефть";

    public KursBot() throws IOException {
        Properties properties = new Properties();
        properties.load(new FileInputStream("local.properties"));
        String token = properties.getProperty("KURS_TOKEN");
        bot = new TelegramBot.Builder(token).debug().build();
    }

    @Override
    public Object handle(Request request, Response response) throws Exception {
        System.out.println("KursBot handle: " + request);

        Update update = new Gson().fromJson(request.body(), Update.class);
        Long chatId = update.message().chat().id();
        String text = update.message().text();
        if (text == null) return "empty message?";
        String message;
        switch (text) {
            case BUTTON_CB:
                message = cbkurses();
                break;
            case BUTTON_EXCHANGE:
                message = kurses();
                break;
            case BUTTON_OIL:
                message = getOil();
                break;
            default:
                message = getAllKurs();
        }
        bot.execute(new SendMessage(chatId, message).replyMarkup(new ReplyKeyboardMarkup(new String[]{BUTTON_CB}, new String[]{BUTTON_EXCHANGE})));
        return "ok";
    }


    public String getAllKurs() {
        return cbkurses() + "\n\n" + kurses();
    }

    public String getAllKursWithOil() {
        return cbkurses() + "\n\n" + kurses() + "\n\n" + getOil();
    }

    public String getOil() {
        String result = "Нефть";
        try {
            JsonObject jsonObject = new Gson().fromJson(readStringFromUrl("https://www.quandl.com/api/v1/datasets/CHRIS/ICE_B1.json"), JsonObject.class);
            float oil = jsonObject.getAsJsonArray("data").get(0).getAsJsonArray().get(4).getAsFloat();
            result += " " + oil;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private String kurses_old() {
        String url = "https://query.yahooapis.com/v1/public/yql?q=select+*+from+yahoo.finance.xchange+where+pair+=+%22USDRUB,EURRUB%22&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
        String result = "Биржа \n";
        try {
            JsonObject jsonObject = new Gson().fromJson(readStringFromUrl(url), JsonObject.class);
            JsonArray rates = jsonObject.getAsJsonObject("query").getAsJsonObject("results").getAsJsonArray("rate");
            for (JsonElement jsonElement : rates) {
                JsonObject jsRate = jsonElement.getAsJsonObject();
                String name = jsRate.getAsJsonPrimitive("Name").getAsString();
                String rate = jsRate.getAsJsonPrimitive("Rate").getAsString();
                result += name + " : " + rate + "\n";
            }
        } catch (IOException e) {
            e.printStackTrace();

        }
        return result;
    }

    private String kurses() {
        String url = "http://zenrus.ru/build/js/currents.js";
        String result = "";
        try {
            String res = readStringFromUrl(url);
            res = res.substring(res.indexOf('[') + 1, res.indexOf("]"));
            String[] values = res.split(",");
            result += "Доллар : " + values[0] + "\n";
            result += "Евро   : " + values[1] + "\n";
            result += "Нефть  : " + values[2] + "\n";
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(result);
        return result;
    }

    private String cbkurses() {
        String url = "http://www.cbr.ru/scripts/XML_daily.asp";
        String result = "ЦБ";
        try {
            String xml_str = readStringFromUrl(url);
            DocumentBuilder db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = db.parse(new InputSource(new StringReader(xml_str)));

            Element root = (Element) doc.getElementsByTagName("ValCurs").item(0);
            String date = root.getAttribute("Date");
            String usd = "", eur = "";
            ;
            NodeList valutes = root.getElementsByTagName("Valute");
            for (int i = 0; i < valutes.getLength(); i++) {
                Element valute = (Element) valutes.item(i);
                if (valute.getAttribute("ID").equals("R01235")) {
                    usd = valute.getElementsByTagName("Value").item(0).getFirstChild().getNodeValue();
                } else if (valute.getAttribute("ID").equals("R01239")) {
                    eur = valute.getElementsByTagName("Value").item(0).getFirstChild().getNodeValue();
                }
            }
            return result + " на " + date + "\nДоллар : " + usd + "\nЕвро : " + eur;

        } catch (IOException | ParserConfigurationException | SAXException e) {
            e.printStackTrace();
        }
        return result;
    }

    private String readStringFromUrl(String url) throws IOException {
        try (InputStream is = new URL(url).openStream()) {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            StringBuilder sb = new StringBuilder();
            int cp;
            while ((cp = rd.read()) != -1) {
                sb.append((char) cp);
            }
            return sb.toString();
        }
    }

    public static void main(String[] args) throws IOException {
        new KursBot().kurses();
    }
}
