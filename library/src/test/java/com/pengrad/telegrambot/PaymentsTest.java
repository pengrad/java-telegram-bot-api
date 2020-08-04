package com.pengrad.telegrambot;

import com.pengrad.telegrambot.checks.*;
import com.pengrad.telegrambot.model.*;
import com.pengrad.telegrambot.model.request.*;
import com.pengrad.telegrambot.request.*;
import com.pengrad.telegrambot.response.*;

import org.junit.*;

import static com.pengrad.telegrambot.TelegramBotTest.getProp;
import static org.junit.Assert.*;

/**
 * Stas Parshin
 * 23 February 2020
 */
public class PaymentsTest {

    static TelegramBot bot = TelegramBotTest.bot;
    static Integer chatId = TelegramBotTest.chatId;

    String testShippingQuery = getProp("TEST_SHIP_QUERY");
    String testPreCheckoutQuery = getProp("TEST_PRECHECKOUT_QUERY");

    @Test
    public void sendInvoice() {
        SendResponse response = bot.execute(new SendInvoice(chatId, "title", "desc", "my_payload",
                "284685063:TEST:NThlNWQ3NDk0ZDQ5", "my_start_param", "USD", new LabeledPrice("label", 200))
                .providerData("{\"foo\" : \"bar\"}")
                .photoUrl("https://telegram.org/img/t_logo.png").photoSize(100).photoHeight(100).photoWidth(100)
                .needPhoneNumber(true).needShippingAddress(true).needEmail(true).needName(true)
                .isFlexible(true)
                .replyMarkup(new InlineKeyboardMarkup(
                        new InlineKeyboardButton("just pay").pay(),
                        new InlineKeyboardButton("google it").url("www.google.com")))
        );
        Invoice invoice = response.message().invoice();
        InvoiceCheck.check(response.message().invoice());
        assertEquals("USD", invoice.currency());
        assertEquals(Integer.valueOf(200), invoice.totalAmount());

        InlineKeyboardButton payButton = response.message().replyMarkup().inlineKeyboard()[0][0];
        assertTrue(payButton.isPay());
        assertEquals("just pay", payButton.text());
    }

    @Test
    public void answerShippingQuery() {
        ShippingQuery shippingQuery = BotUtils.parseUpdate(testShippingQuery).shippingQuery();

        String shippingQueryId = shippingQuery.id();
        assertFalse(shippingQueryId.isEmpty());
        UserTest.checkUser(shippingQuery.from(), true);
        assertEquals(Integer.valueOf(12345), shippingQuery.from().id());
        assertEquals("my_payload", shippingQuery.invoicePayload());

        ShippingAddress address = shippingQuery.shippingAddress();
        checkTestShippingAddress(address);

        BaseResponse response = bot.execute(new AnswerShippingQuery(shippingQueryId,
                new ShippingOption("1", "VNPT", new LabeledPrice("delivery", 100), new LabeledPrice("tips", 50)),
                new ShippingOption("2", "FREE", new LabeledPrice("free delivery", 0))
        ));

        if (!response.isOk()) {
            assertEquals(400, response.errorCode());
            assertEquals("Bad Request: query is too old and response timeout expired or query ID is invalid", response.description());
        }
    }

    @Test
    public void answerShippingQueryError() {
        ShippingQuery shippingQuery = BotUtils.parseUpdate(testShippingQuery).shippingQuery();
        String shippingQueryId = shippingQuery.id();

        BaseResponse response = bot.execute(new AnswerShippingQuery(shippingQueryId, "cant delivery so far"));

        if (!response.isOk()) {
            assertEquals(400, response.errorCode());
            assertEquals("Bad Request: query is too old and response timeout expired or query ID is invalid", response.description());
        }
    }

    private void checkTestShippingAddress(ShippingAddress address) {
        assertNotNull(address);
        assertEquals("US", address.countryCode());
        assertEquals("Florida", address.state());
        assertEquals("Miami", address.city());
        assertEquals("Djs", address.streetLine1());
        assertEquals("Djdjdjd", address.streetLine2());
        assertEquals("25168", address.postCode());
    }

    @Test
    public void answerPreCheckoutQuery() {
        PreCheckoutQuery preCheckoutQuery = BotUtils.parseUpdate(testPreCheckoutQuery).preCheckoutQuery();

        String preCheckoutQueryId = preCheckoutQuery.id();
        assertEquals("112233", preCheckoutQueryId);
        UserTest.checkUser(preCheckoutQuery.from(), true);
        assertEquals(Integer.valueOf(12345), preCheckoutQuery.from().id());
        assertEquals("USD", preCheckoutQuery.currency());
        assertEquals(Integer.valueOf(200), preCheckoutQuery.totalAmount());
        assertEquals("my_payload", preCheckoutQuery.invoicePayload());
        assertEquals("2", preCheckoutQuery.shippingOptionId());

        OrderInfo orderInfo = preCheckoutQuery.orderInfo();
        assertEquals("uName", orderInfo.name());
        assertEquals("+123456789", orderInfo.phoneNumber());
        assertEquals("aaa@aaa.com", orderInfo.email());
        checkTestShippingAddress(orderInfo.shippingAddress());

        BaseResponse response = bot.execute(new AnswerPreCheckoutQuery(preCheckoutQueryId));

        if (!response.isOk()) {
            assertEquals(400, response.errorCode());
            assertEquals("Bad Request: query is too old and response timeout expired or query ID is invalid", response.description());
        }
    }

    @Test
    public void answerPreCheckoutQueryError() {
        PreCheckoutQuery preCheckoutQuery = BotUtils.parseUpdate(testPreCheckoutQuery).preCheckoutQuery();
        String preCheckoutQueryId = preCheckoutQuery.id();

        BaseResponse response = bot.execute(new AnswerPreCheckoutQuery(preCheckoutQueryId, "cant sell to you"));

        if (!response.isOk()) {
            assertEquals(400, response.errorCode());
            assertEquals("Bad Request: query is too old and response timeout expired or query ID is invalid", response.description());
        }
    }

    @Test
    public void testSuccessfulPayment() {
        String jsonPayment = "{\"update_id\":263104091,\"message\":{\"message_id\":14442,\"from\":{\"id\":12345,\"is_bot\":false,\"first_name\":\"fName\",\"last_name\":\"lName\",\"username\":\"uName\",\"language_code\":\"en-US\"},\"chat\":{\"id\":12345,\"first_name\":\"fName\",\"last_name\":\"lName\",\"username\":\"uName\",\"type\":\"private\"},\"date\":1535389477,\"successful_payment\":{\"currency\":\"USD\",\"total_amount\":200,\"invoice_payload\":\"my_payload\",\"shipping_option_id\":\"2\",\"order_info\":{\"name\":\"uName\",\"phone_number\":\"+123456789\",\"email\":\"aaa@aaa.com\",\"shipping_address\":{\"country_code\":\"US\",\"state\":\"Florida\",\"city\":\"Miami\",\"street_line1\":\"Djs\",\"street_line2\":\"Djdjdjd\",\"post_code\":\"25168\"}},\"telegram_payment_charge_id\":\"tcid\",\"provider_payment_charge_id\":\"pcid\"}}}";
        Message message = BotUtils.parseUpdate(jsonPayment).message();
        SuccessfulPayment payment = message.successfulPayment();

        assertEquals(Integer.valueOf(14442), message.messageId());
        UserTest.checkUser(message.from(), true);
        ChatTest.checkChat(message.chat());
        assertEquals(Integer.valueOf(12345), message.from().id());
        assertEquals(Long.valueOf(12345), message.chat().id());

        assertNotNull(payment);
        assertEquals("USD", payment.currency());
        assertEquals(Integer.valueOf(200), payment.totalAmount());
        assertEquals("my_payload", payment.invoicePayload());
        assertEquals("2", payment.shippingOptionId());
        assertEquals("tcid", payment.telegramPaymentChargeId());
        assertEquals("pcid", payment.providerPaymentChargeId());

        OrderInfo orderInfo = payment.orderInfo();
        assertEquals("uName", orderInfo.name());
        assertEquals("+123456789", orderInfo.phoneNumber());
        assertEquals("aaa@aaa.com", orderInfo.email());
        checkTestShippingAddress(orderInfo.shippingAddress());
    }

}
