package com.pengrad.telegrambot.passport.decrypt;

import com.google.gson.Gson;
import com.pengrad.telegrambot.passport.Credentials;

import java.util.Arrays;

/**
 * Stas Parshin
 * 31 July 2018
 */

public class Decrypt {

    public static Credentials decryptCredentials(String privateKey, String data, String hash, String secret) throws Exception {
        byte[] s = base64(secret);
        byte[] encryptedSecret = RsaOaep.decrypt(privateKey, s);

        byte[] h = base64(hash);
        SecretHash secretHash = new SecretHash(encryptedSecret, h);

        byte[] d = base64(data);
        byte[] encryptedData = decryptAes256Cbc(secretHash.key(), secretHash.iv(), d);
        String credStr = new String(encryptedData);
        return new Gson().fromJson(credStr, Credentials.class);
    }

    public static String decryptData(String data, String dataHash, String secret) throws Exception {
        byte[] d = base64(data);
        byte[] encryptedData = decryptFile(d, dataHash, secret);
        return new String(encryptedData);
    }

    public static byte[] decryptFile(byte[] data, String fileHash, String secret) throws Exception {
        SecretHash secretHash = new SecretHash(base64(secret), base64(fileHash));
        return decryptAes256Cbc(secretHash.key(), secretHash.iv(), data);
    }

    private static byte[] decryptAes256Cbc(byte[] key, byte[] iv, byte[] data) throws Exception {
        byte[] encryptedData = new Aes256Cbc(key, iv).decrypt(data);
        int padding = encryptedData[0] & 0xFF;
        encryptedData = Arrays.copyOfRange(encryptedData, padding, encryptedData.length);
        return encryptedData;
    }

    private static byte[] base64(String str) {
        return Base64.decode(str, 0);
    }
}
