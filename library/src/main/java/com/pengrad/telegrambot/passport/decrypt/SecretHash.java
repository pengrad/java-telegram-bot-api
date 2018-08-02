package com.pengrad.telegrambot.passport.decrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Stas Parshin
 * 31 July 2018
 */
class SecretHash {

    private final byte[] secretHash;

    public SecretHash(byte[] secret, byte[] hash) throws Exception {
        secretHash = sha512(concat(secret, hash));
    }

    public byte[] key() {
        return Arrays.copyOfRange(secretHash, 0, 32);
    }

    public byte[] iv() {
        return Arrays.copyOfRange(secretHash, 32, 48);
    }

    private byte[] sha512(byte[] string) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        return md.digest(string);
    }

    private byte[] concat(byte[]... arrays) {
        int length = 0;
        for (byte[] array : arrays) {
            length += array.length;
        }
        byte[] result = new byte[length];
        int pos = 0;
        for (byte[] array : arrays) {
            for (byte element : array) {
                result[pos] = element;
                pos++;
            }
        }
        return result;
    }
}
