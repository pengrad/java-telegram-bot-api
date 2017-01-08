package com.pengrad.telegrambot.sample.spark;

import com.pengrad.telegrambot.request.SetWebhook;
import spark.Request;
import spark.Response;
import spark.Route;

import static spark.Spark.*;

public class Main {
    public static void main(String[] args) throws Exception {

        ipAddress(args[0]);
        port(Integer.parseInt(args[1]));

        get("/hello", (req, res) -> "Hello World");
        post("/test", new Test());
        get("/test", new Test());

        get("/kurs", (request, response) -> new KursBot().getAllKurs());
        post("/kursBot", new KursBot());

        BotHandler botHandler = new AqivnBot();
        post("/" + botHandler.getToken(), botHandler);

        String appSite = System.getenv("OPENSHIFT_APP_DNS");
        botHandler.getBot().execute(new SetWebhook().url(appSite + "/" + botHandler.getToken()));
    }

    private static class Test implements Route {
        @Override
        public Object handle(Request request, Response response) throws Exception {
            return "ok, test";
        }
    }
}
