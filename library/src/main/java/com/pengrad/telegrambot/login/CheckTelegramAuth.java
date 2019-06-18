package com.pengrad.telegrambot.login;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Stas Parshin
 * 18 June 2019
 */
public class CheckTelegramAuth {

    private final String botToken, dataCheck, hash;
    private final long authDate;

    public CheckTelegramAuth(String botToken, String authParams) {
        String[] params = authParams.split("&");
        TreeSet<String> set = new TreeSet<String>();
        String hash = null;
        long authDate = 0;
        for (String p : params) {
            if (p.startsWith("hash=")) {
                hash = p.substring(5);
            } else {
                set.add(p);
            }
            if (p.startsWith("auth_date=")) {
                authDate = Long.parseLong(p.substring(10));
            }
        }
        this.hash = hash;
        this.authDate = authDate;
        this.dataCheck = join(set, "\n");
        this.botToken = botToken;
    }

    public Date authDate() {
        return new Date(authDate * 1000L);
    }

    public boolean isFromTelegram() throws Exception {
        String result = hmacSha256(sha256(botToken.getBytes()), dataCheck);
        return result.equals(hash);
    }

    private byte[] sha256(byte[] string) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        return md.digest(string);
    }

    private String hmacSha256(byte[] key, String data) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac hmacSha256 = Mac.getInstance("HmacSHA256");
        SecretKeySpec secret_key = new SecretKeySpec(key, "HmacSHA256");
        hmacSha256.init(secret_key);
        byte[] result = hmacSha256.doFinal(data.getBytes());
        return hex(result);
    }

    public static String hex(byte[] str) {
        return String.format("%040x", new BigInteger(1, str));
    }

    public static String join(Iterable<String> elements, CharSequence separator) {
        StringBuilder builder = new StringBuilder();
        Iterator<String> it = elements.iterator();
        if (it.hasNext()) {
            builder.append(it.next());
            while (it.hasNext()) {
                builder.append(separator).append(it.next());
            }
        }
        return builder.toString();
    }
}
