package com.pengrad.telegrambot;


import com.pengrad.telegrambot.request.GetFile;
import com.pengrad.telegrambot.response.GetFileResponse;
import com.sun.xml.internal.rngom.parse.host.Base;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

import javax.xml.bind.DatatypeConverter;

/**
 * Stas Parshin
 * 31 July 2018
 */
public class PassportTest {


    public static void main(String[] args) throws Exception {
//        OutputStream os = System.out;
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        os = baos;
//        Cbc cbc = new Cbc(new byte[]{-39, 76, -53, -16, -69, -49, 113, -30, -113, 10, 36, 48, 86, 111, 31, -90},
//                new byte[]{24, -70, -100, -77, 65, -40, 108, 36, -88, 98, 45, 104, 104, 88, -107, 91, -30, 81, -103, -64, -96, -25, 92, 28, -51, -87, 75, 121, 50, 54, 20, -106},
//                os);
//        byte[] encData = new byte[]{116, 25, 99, -30, 96, 104, 7, -72, -101, 50, 112, -126, 91, -115, -44, 72, 22, 92, 121, 38, 68, -37, 56, -95, -96, 19, 55, -37, -42, 26, -91, 61, -49, -2, 35, -114, -6, -124, 19, 119, -90, 127, 102, 122, 40, 72, -55, 12, 89, -39, -24, -15, -61, -42, -42, 38, 69, 99, -46, 35, 100, -25, -35, -1, 89, 56, 8, 114, -32, -107, 36, 60, 80, -6, -30, -70, 109, 64, -22, 31, 38, -86, 119, 14, -93, 119, -23, -26, -27, 95, -35, -69, -21, 25, 106, 3, -30, 101, -54, -76, -3, -8, -5, 50, 78, 2, 109, 8, 18, -50, 45, 75, -120, -12, -58, -80, -6, -52, -27, -96, -9, -1, 84, 82, -118, 90, -59, -30, -111, 76, 45, -124, -14, 11, -121, -24, 56, 119, -17, 30, 114, 91, -90, -34, 14, 50, -98, 101, 26, -92, 92, 8, -41, -82, -124, 35, 25, 12, -38, 105, 75, 22, 59, -41, 45, 116, -94, -122, -78, 51, -23, -92, 57, 106, -107, 58, -1, 0, -19, -36, -8, -74, -104, 43, 11, 92, -27, 8, 123, -109, 13, -122, 76, 8, 56, -113, 80, -27, -9, 71, 0, -112, -114, -64, -36, -90, 113, 57, 63, 4, -97, 102, 102, 41, 38, -58, -28, 43, -89, 101, 125, -45, -75, -75, 92, -37, 113, 49, -73, 67, -73, -116, -75, 19, -16, -41, -76, -37, -32, 29, 32, 3, -26, -121, -112, 54, 45, -37, -119, -42, 113, 20, -103, -62, -128, -60, -83, -56, 51, 3, -89, 20, 80, 19, 109, 93, -121, 125, 48, 89, 67, 81, 1, -2, 43, -116, -39, 7, -113, -5, 78, -26, 2, 64, 44, 101, -67, 51, 73, -50, 116, 60, 119, 43, -57, -52, 33, 74, -102, -114, 20, 52, -43, -93, -101, -57, 88, -116, 39, -5, -94, -109, -113, -20, -112, 9, 48, 68, 117, 61, 51, 37, 96, 67, 83, -64, -115, -63, 13, 108, -96, 16, -72, 11, 99, 123, -107, 37, -121, 82, -22, 18, 52, -36, -16, -52, 65, -66, 114, -123, 101, -124, -11, 15, -45, 0, -32, 73, 11, -44, -36, -28, 126, -104, 11, 82, 4, -81, 37, 25, 121, -78, -32, 18, -46, 17, 9, 70, -30, -56, -83, 116, 52, 119, 126, 7, -9, 53, 18, -105, -3, -1, 42, 89, -9, 127, 90, 101, -37, -12, 105, -55, -107, -39, 70, 80, -30, -16, 96, -43, -109, -35, -33, 9, -29, -67, -49, -75, -90, -123, -50, 114, -120, -32, -15, -127, 57, 101, 52, -44, 48, 97, 44, 37, 89, 80, -73, -112, -59, -128, -43, 83, 4, -98, -6, 77, 42, 39, -91, 58, -2, -8, 57, -57, 121, 116, -33, -29, 84, -89, 81, 27, -108, -95, -27, -102, -124, -8, 70, -72, 96, 21, -111, 15, -37, -6, 82, -110, 6, -84, 34, 108, 33, 39, 35, 58, -111, 27, -123, -76, 117, 28, 71, 21, 48, -108, -104, -31, 81, -120, 18, 6, -123, -69, -117, -121, -63, 78, 104, 54, 51, -40, 60, 7, -8, -114, -83, -109, 41, 31, 88, 46, 73, -110, -42, 30, 74, 108, -83, -101, -23, -56, -89, -92, 82, 34, -8, 69, -125, 14, -98, -103, 103, -74, -11, 2, 81, -116, 30, -68, 126, -25, 23, -19, 81, -79, 28, -45, -43, 84, 110, -41, -41, -4, 99, -2, 16, 16, -127, 42, -14, -19, 29, 84, -27, -128, 28, 105, 83, -25, 115, 52, 93, 28, 17, 59, 109, -23, -68, -77, -5, 77, -80, 84, -128, -49, 21, -36, -4, -103, -15, -84, 99, 5, 48, 89, -3, -58, -24, 93, 121, 117, 2, 104, -32, 20, -123, -21, -66, 37, 93, -45, 102, -53, -66, 75, 41, 48, 55, -23, -7, 9, 72, 7, 12, 111, 45, 107, -91, -126, 71, 54, -59, -60, 10, -30, -28, 7, 104, -91, -14, -123, -76, 70, -123, 23, 28, 28, -123, 31, 11, -72, 54, 105, -75, -128, 113, 45, 8, 110, -106, -100, 15, -98, 121, -120, 42, -91, -80, -100, 87, 33, -72, 118, -50, 21, -92, -27, 126, 33, 81, 25, 111, -38, -43, 77, 59, -111, 117, -6, 108, -123, 124, 27, 101, 11, 43, 53, -88, -53, -46, 45, -42, -4, 12, -25, -100, 76, 91, 101, -69, -59, 41, -56, 41, -93, -70, 116, -93, -88, -60, -77, -100, 116, 124, 70, 115, 52, 27, 53, -72, -82, -29, -55, -71, 38, -69, -13, -82, 63, -74, 112, 27, -120, 114, 82, -28, -80, 113, 42, -38, -75, -46, -120, -68, -48, -81, -102};
//        cbc.decrypt(encData);
////        cbc.finishDecryption();
//        byte[] data = baos.toByteArray();
//        byte[] shaData = sha256b(data);
////        System.out.println("Data Hash first " + shaData[0] + " last " + shaData[shaData.length - 1]);
//        int padding = data[0] & 0xFF;
//        data = Arrays.copyOfRange(data, padding, data.length);
//        System.out.println(new String(data));

//
        String encData = "K5Sru8OV+a5uatFgucFCNXTMOAd6JIyJt1MY1OcW7NQH2Va/zH0MIGLeip4NiB4OYrO5dljp6+NfowhEGBKMlRi1L2WJlNSHLJU6txol7GrcpJ5KdVw8s0PcFUIbjvMt5y0J9jkk5esRIHPtPB0T719caDHJ+PFXsAmtOwYllymICSec9qdduLUu+uGaLz6frRgVP8Hsc2hKR2lEZjHw4lcR8VeZwLwP1Yl8O7HaZ7lJqQinLcZ7Jt+Tag+Oe9Fpq8AJnPaH7j+6JYIKHgWzuQ==";
        String hash = "2fURfeow3nuU38w+CMQiAwr6azqrgn7CVTUpe1YxulU=";
        String secret = "HgIyv1N3j9dvuygPhDdUl3xTUWXFFW8GkX2Gg2qH398=";

        encData = "tUH64yPz+31a2sQvbgtaMd0ZWo5266k+SWwht42l1T9wSpBNVyhEO1Xr9Ld39/yshJrX43gQU/g/sG1lDlhGG7fLyqQpCKIfGaWnPj94maCEsAWFZbIareVkjXSyDxN0VMXq30F3Zhknsi6ZqOc+stzblo+AsClV2wVysbDwal1mmzXK+bOT/ydvRJq1UHX7Okz4Mhx0OrQPOdiCBtuZPNXDWEMpjWM60f5FMEZtOybWTbNF0bFLoSz9w4YbniKH";
        hash = "iFqWHCoXRAk+ka+NpUx1e+H06rhrp2NS03gWQ5fh5u0=";
        secret = "i6EtH1dhMtN7LOkvrHSvicNIjRc0u0EuFs4/8FcLZa8=";

        encData = "8i20v5STakTTngL/5FbqS0bhQvIWcv9dXAUZBroBUwwZx4PQJ/exJJjvSXpbCTihjB+BqJzCmjiuc7bN5+u2HRUfnXkHE2EAFLfVXUGLZf8W0uxQkBaN/uJ0l9oKBucm7MI/hbSfyHuqr73rj5YzeWGxcoVDFy2MSPrWzznWuWxyQ98u6x943OMQE0/XDqMhvbXqLZ1HL9nVxHtODpEOvutD21X0IglCiV1CZaKjNoxPRxF6Ns8HfVfUiJoDoh3tsVup1lHh22ouG1YzjhXscaVCJfxNlpaIBp5EeSh4zqFeHPX8fwxdOz/2rqm/dI/d046+6W6/Nmej5TF8GmWEfDcIaKotRjCduVDdTREfNFIgKfsHkMmPl2Dqakrxz46jXJYtG9wW/qAZ8giwWEBGvg==";
        hash = "ad6LfxLJGpCdhhRLF8PHD36uFXMCEFWwS+Wnc776wXY=";
        secret = "j6wqUo8Z3h04J6px0Nb4M6/AJzdQ0OFKpJyCm63fc8Y=";

        encData = "DgADAgADYQEAArelAAFLkpkNswABm39wAg";
        hash = "72uO0w2cUBKrZhkxFA7rk/p4u3+0l28IDRZdxgvnHes=";
        secret = "A59spfwXxTrLrFkEDEH9sDD9RBhw5AcveBSnExrk6BA=";

        String t = hash;
//        hash = secret;
//        secret = t;

        byte[] encAddBytes = Base64.getMimeDecoder().decode(encData);
        encAddBytes = Arrays.copyOf(encAddBytes, 32);
        byte[] hashBytes = Base64.getMimeDecoder().decode(hash);
        byte[] secretBytes = Base64.getMimeDecoder().decode(secret);
        byte[] secretHash = TelegramBotTest.sha512(TelegramBotTest.concat(secretBytes, hashBytes));
        byte[] k = Arrays.copyOfRange(secretHash, 0, 32);
        byte[] iv = Arrays.copyOfRange(secretHash, 32, 48);
//
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Cbc cbc = new Cbc(iv, k, baos);
        cbc.decrypt(encAddBytes);
        cbc.finishDecryption();
        System.out.println(baos.toByteArray()[0] & 0xFF);
        System.out.println(new String(baos.toByteArray()));
        System.out.println();


        TelegramBot bot = TelegramBotAdapter.buildDebug("124920712:AAFRx6H1mjHGbQ4r2mVVsZuRkuPJQiNPWSc");
        GetFileResponse response = bot.execute(new GetFile(Base64.getMimeEncoder().encodeToString(baos.toByteArray())));
        System.out.println(response);


        System.out.println("++++++++++++++++++++++++++++++");

//        String encAdddata = "DgADAgADYQEAArelAAFLkpkNswABm39wAg";
//        byte[] encAddB = Base64.getMimeDecoder().decode(encAdddata);
//        encAddB = Arrays.copyOf(encAddB, 32);
//        System.out.println(encAddB.length);
//        String addHash = "72uO0w2cUBKrZhkxFA7rk/p4u3+0l28IDRZdxgvnHes=";
//        String addSecr = "A59spfwXxTrLrFkEDEH9sDD9RBhw5AcveBSnExrk6BA=";
//        byte[] ahb = Base64.getMimeDecoder().decode(addHash);
//        byte[] asb = Base64.getMimeDecoder().decode(addSecr);
//        byte[] dsh = TelegramBotTest.sha512(TelegramBotTest.concat(asb, ahb));
//        byte[] k = Arrays.copyOfRange(dsh, 0, 32);
//        byte[] iv = Arrays.copyOfRange(dsh, 32, 48);
////
//        AES AES = new AES();
//        AES.roundKey = new Data[AES.ROUNDS + 1];
//        AES.key = new Data(k);
//        AES.IV = new Data(iv);
//        AES.CBC_MODE = true;
//        AES.iStream = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(encAddB)));
//        AES.decrypt();
//        System.out.println(new String(AES.baos.toByteArray()));
//        System.out.println("123123123123123123123123");


//        baos = new ByteArrayOutputStream();
//        cbc = new Cbc(iv, k, baos);
//        cbc.decrypt(encAddB);
//        cbc.finishDecryption();
//        System.out.println(baos.toByteArray().length);
//        System.out.println(new String(baos.toByteArray()));
//
//        if (true) return;
//        System.out.println("++++++++++++++++++++++++++++++");
//
//        String fileId = "DgADAgADYQEAArelAAFLkpkNswABm39wAg";
//        byte[] fidb = Base64.getMimeDecoder().decode(fileId);
//        String fHash = "72uO0w2cUBKrZhkxFA7rk/p4u3+0l28IDRZdxgvnHes=";
//        String fSecr = "A59spfwXxTrLrFkEDEH9sDD9RBhw5AcveBSnExrk6BA=";
//        ahb = Base64.getMimeDecoder().decode(fHash);
//        asb = Base64.getMimeDecoder().decode(fSecr);
//        dsh = TelegramBotTest.sha512(TelegramBotTest.concat(asb, ahb));
//        System.out.println(dsh.length);
//        k = Arrays.copyOfRange(dsh, 0, 32);
//        iv = Arrays.copyOfRange(dsh, 32, 48);
//
//        baos = new ByteArrayOutputStream();
//        cbc = new Cbc(iv, k, baos);
//        cbc.decrypt(fidb);
////        cbc.finishDecryption();
//        System.out.println(baos.toByteArray().length);
//        System.out.println(new String(baos.toByteArray()));
    }

    static byte[] sha256b(byte[] string) throws Exception {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        return digest.digest(string);
    }

    public static final class Aes256 {

        /**
         * Number of {@code byte}s needed for 32 bit words.
         */
        private static final int WORD_SIZE = 4;

        /**
         * Number of {@code byte}s for a data block. The size is identical to the size of the internal
         * state, that is needed in encryption or decryption.
         * <p>
         * The state can be viewed as a square matrix, modeled as a list of column vectors.
         * </p>
         */
        private static final int BLOCK_SIZE = 16;

        /**
         * key size in {@code byte}s
         */
        private static final int KEY_SIZE = 32;

        /**
         * number of rounds
         */
        private static final int ROUNDS = 14;

        /**
         * Size of the expanded key. For each round a {@code BLOCK_SIZE} block will be needed. Before
         * the first round another block will be needed.
         */
        private static final int EXPANDED_KEY_SIZE = (ROUNDS + 1) * BLOCK_SIZE;

        /**
         * expanded key
         */
        private final byte[] _expandedKey;

        /**
         * state needed between rounds in en- or decryption
         */
        private final byte[] _tmp;

        /**
         * Permutation of {@code byte}s. The s-box permutation was specified in the reference document.
         */
        private final byte[] _sBox = {(byte) 0x63, (byte) 0x7c, (byte) 0x77,
                (byte) 0x7b, (byte) 0xf2, (byte) 0x6b, (byte) 0x6f, (byte) 0xc5,
                (byte) 0x30, (byte) 0x01, (byte) 0x67, (byte) 0x2b, (byte) 0xfe,
                (byte) 0xd7, (byte) 0xab, (byte) 0x76, (byte) 0xca, (byte) 0x82,
                (byte) 0xc9, (byte) 0x7d, (byte) 0xfa, (byte) 0x59, (byte) 0x47,
                (byte) 0xf0, (byte) 0xad, (byte) 0xd4, (byte) 0xa2, (byte) 0xaf,
                (byte) 0x9c, (byte) 0xa4, (byte) 0x72, (byte) 0xc0, (byte) 0xb7,
                (byte) 0xfd, (byte) 0x93, (byte) 0x26, (byte) 0x36, (byte) 0x3f,
                (byte) 0xf7, (byte) 0xcc, (byte) 0x34, (byte) 0xa5, (byte) 0xe5,
                (byte) 0xf1, (byte) 0x71, (byte) 0xd8, (byte) 0x31, (byte) 0x15,
                (byte) 0x04, (byte) 0xc7, (byte) 0x23, (byte) 0xc3, (byte) 0x18,
                (byte) 0x96, (byte) 0x05, (byte) 0x9a, (byte) 0x07, (byte) 0x12,
                (byte) 0x80, (byte) 0xe2, (byte) 0xeb, (byte) 0x27, (byte) 0xb2,
                (byte) 0x75, (byte) 0x09, (byte) 0x83, (byte) 0x2c, (byte) 0x1a,
                (byte) 0x1b, (byte) 0x6e, (byte) 0x5a, (byte) 0xa0, (byte) 0x52,
                (byte) 0x3b, (byte) 0xd6, (byte) 0xb3, (byte) 0x29, (byte) 0xe3,
                (byte) 0x2f, (byte) 0x84, (byte) 0x53, (byte) 0xd1, (byte) 0x00,
                (byte) 0xed, (byte) 0x20, (byte) 0xfc, (byte) 0xb1, (byte) 0x5b,
                (byte) 0x6a, (byte) 0xcb, (byte) 0xbe, (byte) 0x39, (byte) 0x4a,
                (byte) 0x4c, (byte) 0x58, (byte) 0xcf, (byte) 0xd0, (byte) 0xef,
                (byte) 0xaa, (byte) 0xfb, (byte) 0x43, (byte) 0x4d, (byte) 0x33,
                (byte) 0x85, (byte) 0x45, (byte) 0xf9, (byte) 0x02, (byte) 0x7f,
                (byte) 0x50, (byte) 0x3c, (byte) 0x9f, (byte) 0xa8, (byte) 0x51,
                (byte) 0xa3, (byte) 0x40, (byte) 0x8f, (byte) 0x92, (byte) 0x9d,
                (byte) 0x38, (byte) 0xf5, (byte) 0xbc, (byte) 0xb6, (byte) 0xda,
                (byte) 0x21, (byte) 0x10, (byte) 0xff, (byte) 0xf3, (byte) 0xd2,
                (byte) 0xcd, (byte) 0x0c, (byte) 0x13, (byte) 0xec, (byte) 0x5f,
                (byte) 0x97, (byte) 0x44, (byte) 0x17, (byte) 0xc4, (byte) 0xa7,
                (byte) 0x7e, (byte) 0x3d, (byte) 0x64, (byte) 0x5d, (byte) 0x19,
                (byte) 0x73, (byte) 0x60, (byte) 0x81, (byte) 0x4f, (byte) 0xdc,
                (byte) 0x22, (byte) 0x2a, (byte) 0x90, (byte) 0x88, (byte) 0x46,
                (byte) 0xee, (byte) 0xb8, (byte) 0x14, (byte) 0xde, (byte) 0x5e,
                (byte) 0x0b, (byte) 0xdb, (byte) 0xe0, (byte) 0x32, (byte) 0x3a,
                (byte) 0x0a, (byte) 0x49, (byte) 0x06, (byte) 0x24, (byte) 0x5c,
                (byte) 0xc2, (byte) 0xd3, (byte) 0xac, (byte) 0x62, (byte) 0x91,
                (byte) 0x95, (byte) 0xe4, (byte) 0x79, (byte) 0xe7, (byte) 0xc8,
                (byte) 0x37, (byte) 0x6d, (byte) 0x8d, (byte) 0xd5, (byte) 0x4e,
                (byte) 0xa9, (byte) 0x6c, (byte) 0x56, (byte) 0xf4, (byte) 0xea,
                (byte) 0x65, (byte) 0x7a, (byte) 0xae, (byte) 0x08, (byte) 0xba,
                (byte) 0x78, (byte) 0x25, (byte) 0x2e, (byte) 0x1c, (byte) 0xa6,
                (byte) 0xb4, (byte) 0xc6, (byte) 0xe8, (byte) 0xdd, (byte) 0x74,
                (byte) 0x1f, (byte) 0x4b, (byte) 0xbd, (byte) 0x8b, (byte) 0x8a,
                (byte) 0x70, (byte) 0x3e, (byte) 0xb5, (byte) 0x66, (byte) 0x48,
                (byte) 0x03, (byte) 0xf6, (byte) 0x0e, (byte) 0x61, (byte) 0x35,
                (byte) 0x57, (byte) 0xb9, (byte) 0x86, (byte) 0xc1, (byte) 0x1d,
                (byte) 0x9e, (byte) 0xe1, (byte) 0xf8, (byte) 0x98, (byte) 0x11,
                (byte) 0x69, (byte) 0xd9, (byte) 0x8e, (byte) 0x94, (byte) 0x9b,
                (byte) 0x1e, (byte) 0x87, (byte) 0xe9, (byte) 0xce, (byte) 0x55,
                (byte) 0x28, (byte) 0xdf, (byte) 0x8c, (byte) 0xa1, (byte) 0x89,
                (byte) 0x0d, (byte) 0xbf, (byte) 0xe6, (byte) 0x42, (byte) 0x68,
                (byte) 0x41, (byte) 0x99, (byte) 0x2d, (byte) 0x0f, (byte) 0xb0,
                (byte) 0x54, (byte) 0xbb, (byte) 0x16};

        /**
         * Inverse of the s-box permutation.
         */
        private final byte[] _invSBox = {(byte) 0x52, (byte) 0x09, (byte) 0x6a,
                (byte) 0xd5, (byte) 0x30, (byte) 0x36, (byte) 0xa5, (byte) 0x38,
                (byte) 0xbf, (byte) 0x40, (byte) 0xa3, (byte) 0x9e, (byte) 0x81,
                (byte) 0xf3, (byte) 0xd7, (byte) 0xfb, (byte) 0x7c, (byte) 0xe3,
                (byte) 0x39, (byte) 0x82, (byte) 0x9b, (byte) 0x2f, (byte) 0xff,
                (byte) 0x87, (byte) 0x34, (byte) 0x8e, (byte) 0x43, (byte) 0x44,
                (byte) 0xc4, (byte) 0xde, (byte) 0xe9, (byte) 0xcb, (byte) 0x54,
                (byte) 0x7b, (byte) 0x94, (byte) 0x32, (byte) 0xa6, (byte) 0xc2,
                (byte) 0x23, (byte) 0x3d, (byte) 0xee, (byte) 0x4c, (byte) 0x95,
                (byte) 0x0b, (byte) 0x42, (byte) 0xfa, (byte) 0xc3, (byte) 0x4e,
                (byte) 0x08, (byte) 0x2e, (byte) 0xa1, (byte) 0x66, (byte) 0x28,
                (byte) 0xd9, (byte) 0x24, (byte) 0xb2, (byte) 0x76, (byte) 0x5b,
                (byte) 0xa2, (byte) 0x49, (byte) 0x6d, (byte) 0x8b, (byte) 0xd1,
                (byte) 0x25, (byte) 0x72, (byte) 0xf8, (byte) 0xf6, (byte) 0x64,
                (byte) 0x86, (byte) 0x68, (byte) 0x98, (byte) 0x16, (byte) 0xd4,
                (byte) 0xa4, (byte) 0x5c, (byte) 0xcc, (byte) 0x5d, (byte) 0x65,
                (byte) 0xb6, (byte) 0x92, (byte) 0x6c, (byte) 0x70, (byte) 0x48,
                (byte) 0x50, (byte) 0xfd, (byte) 0xed, (byte) 0xb9, (byte) 0xda,
                (byte) 0x5e, (byte) 0x15, (byte) 0x46, (byte) 0x57, (byte) 0xa7,
                (byte) 0x8d, (byte) 0x9d, (byte) 0x84, (byte) 0x90, (byte) 0xd8,
                (byte) 0xab, (byte) 0x00, (byte) 0x8c, (byte) 0xbc, (byte) 0xd3,
                (byte) 0x0a, (byte) 0xf7, (byte) 0xe4, (byte) 0x58, (byte) 0x05,
                (byte) 0xb8, (byte) 0xb3, (byte) 0x45, (byte) 0x06, (byte) 0xd0,
                (byte) 0x2c, (byte) 0x1e, (byte) 0x8f, (byte) 0xca, (byte) 0x3f,
                (byte) 0x0f, (byte) 0x02, (byte) 0xc1, (byte) 0xaf, (byte) 0xbd,
                (byte) 0x03, (byte) 0x01, (byte) 0x13, (byte) 0x8a, (byte) 0x6b,
                (byte) 0x3a, (byte) 0x91, (byte) 0x11, (byte) 0x41, (byte) 0x4f,
                (byte) 0x67, (byte) 0xdc, (byte) 0xea, (byte) 0x97, (byte) 0xf2,
                (byte) 0xcf, (byte) 0xce, (byte) 0xf0, (byte) 0xb4, (byte) 0xe6,
                (byte) 0x73, (byte) 0x96, (byte) 0xac, (byte) 0x74, (byte) 0x22,
                (byte) 0xe7, (byte) 0xad, (byte) 0x35, (byte) 0x85, (byte) 0xe2,
                (byte) 0xf9, (byte) 0x37, (byte) 0xe8, (byte) 0x1c, (byte) 0x75,
                (byte) 0xdf, (byte) 0x6e, (byte) 0x47, (byte) 0xf1, (byte) 0x1a,
                (byte) 0x71, (byte) 0x1d, (byte) 0x29, (byte) 0xc5, (byte) 0x89,
                (byte) 0x6f, (byte) 0xb7, (byte) 0x62, (byte) 0x0e, (byte) 0xaa,
                (byte) 0x18, (byte) 0xbe, (byte) 0x1b, (byte) 0xfc, (byte) 0x56,
                (byte) 0x3e, (byte) 0x4b, (byte) 0xc6, (byte) 0xd2, (byte) 0x79,
                (byte) 0x20, (byte) 0x9a, (byte) 0xdb, (byte) 0xc0, (byte) 0xfe,
                (byte) 0x78, (byte) 0xcd, (byte) 0x5a, (byte) 0xf4, (byte) 0x1f,
                (byte) 0xdd, (byte) 0xa8, (byte) 0x33, (byte) 0x88, (byte) 0x07,
                (byte) 0xc7, (byte) 0x31, (byte) 0xb1, (byte) 0x12, (byte) 0x10,
                (byte) 0x59, (byte) 0x27, (byte) 0x80, (byte) 0xec, (byte) 0x5f,
                (byte) 0x60, (byte) 0x51, (byte) 0x7f, (byte) 0xa9, (byte) 0x19,
                (byte) 0xb5, (byte) 0x4a, (byte) 0x0d, (byte) 0x2d, (byte) 0xe5,
                (byte) 0x7a, (byte) 0x9f, (byte) 0x93, (byte) 0xc9, (byte) 0x9c,
                (byte) 0xef, (byte) 0xa0, (byte) 0xe0, (byte) 0x3b, (byte) 0x4d,
                (byte) 0xae, (byte) 0x2a, (byte) 0xf5, (byte) 0xb0, (byte) 0xc8,
                (byte) 0xeb, (byte) 0xbb, (byte) 0x3c, (byte) 0x83, (byte) 0x53,
                (byte) 0x99, (byte) 0x61, (byte) 0x17, (byte) 0x2b, (byte) 0x04,
                (byte) 0x7e, (byte) 0xba, (byte) 0x77, (byte) 0xd6, (byte) 0x26,
                (byte) 0xe1, (byte) 0x69, (byte) 0x14, (byte) 0x63, (byte) 0x55,
                (byte) 0x21, (byte) 0x0c, (byte) 0x7d};

        /**
         * Substitutes all {@code byte}s in a word. The word array will be changed.
         *
         * @param value array in which the first {@code WORD_SIZE} {@code byte}s will be substituted.
         *              This array will be modified.
         * @return returns the modified {@code value}
         */
        private byte[] substituteWord(byte[] value) {
            for (int i = 0; i < WORD_SIZE; ++i) {
                value[i] = this._sBox[value[i] & 0xff];
            }
            return value;
        }

        /**
         * Rotate the {@code byte}'s in a word. The {@code byte}'s will be cycled left by one
         * {@code byte}. The modification will be in place, so the original argument is changed after
         * the method invocation.
         *
         * @param value Array in which the first {@code WORD_SIZE} {@code byte}'s will be changed due to
         *              the rotation. The contents of this array is changed by this invocation.
         */
        private byte[] rotate(byte[] value) {
            byte tmp = value[0];
            for (int i = 1; i < WORD_SIZE; ++i) {
                value[i - 1] = value[i];
            }
            value[WORD_SIZE - 1] = tmp;
            return value;
        }

        /**
         * Expands the key. The incoming key is {@code KEY_SIZE} {@code byte}s long. It will be expanded
         * to a length of {@code EXPANDED_KEY_SIZE} {@code byte}s. The expanded key will be stored in
         * {@link Aes256#_expandedKey}.
         * <p>
         * The encryption and decryption will use the expanded key.
         * </p>
         *
         * @param key key for the AES algorithm
         */
        public Aes256(byte[] key) {
            this._expandedKey = new byte[EXPANDED_KEY_SIZE];
            this._tmp = new byte[BLOCK_SIZE];

            System.arraycopy(key, 0, this._expandedKey, 0, KEY_SIZE);

            for (int i = KEY_SIZE; i < EXPANDED_KEY_SIZE; i += WORD_SIZE) {
                System.arraycopy(this._expandedKey, i - WORD_SIZE, this._tmp, 0, WORD_SIZE);

                if (i % KEY_SIZE == 0) {
                    substituteWord(rotate(this._tmp));
                    this._tmp[0] ^= 1 << (i / KEY_SIZE - 1);
                } else if (i % KEY_SIZE == BLOCK_SIZE) {
                    substituteWord(this._tmp);
                }

                for (int j = 0; j < WORD_SIZE; ++j) {
                    this._expandedKey[i + j] = (byte) (this._expandedKey[i - KEY_SIZE + j] ^ this._tmp[j]);
                }
            }
        }

        /**
         * Combines the state with the expanded key. The {@code byte}s will be combined by {@code XOR}.
         *
         * @param index start of the part of the expanded key, that will be used for the combination
         */
        private void addRoundKey(int index) {
            for (int i = 0; i < BLOCK_SIZE; ++i) {
                this._tmp[i] = (byte) (this._tmp[i] ^ this._expandedKey[index + i]);
            }
        }

        /**
         * The polynomial represented by {@code b} will be multiplied by its free variable. This
         * multiplication takes place in a finite field. The resulting polynomial can still be represented
         * in one {@code byte}.
         * <p>
         * The bits {@code 0} to {@code 7} are the coefficients of the powers {@code x} to {@code x**8}.
         * </p>
         *
         * @param b origin polynomial
         * @return multiplied polynomial
         */
        private int times2(int b) {
            int result = b << 1;
            if ((b & 0x80) != 0) {
                result ^= 0x1b;
            }
            return result & 0xff;
        }

        /**
         * Two polynomial will be multiplied with each other. The representation of the polynomial is
         * described in {@link Aes256#times2}.
         * <p>
         * The multiplication will be performed by successive invocations of {@link Aes256#times2}.
         * </p>
         *
         * @param a first polynomial
         * @param b second polynomial
         * @return result of the multiplication
         */
        private byte mul(int a, byte b) {
            int result = 0;
            int first = a;
            int current = b & 0xff;
            while (first != 0) {
                if ((first & 0x01) != 0) {
                    result ^= current;
                }
                first >>= 1;
                current = times2(current);
            }
            return (byte) (result & 0xff);
        }

        /**
         * Changes all {@code byte}s in the state by the s-box.
         */
        private void substituteState() {
            for (int i = 0; i < BLOCK_SIZE; ++i) {
                this._tmp[i] = this._sBox[this._tmp[i] & 0xff];
            }
        }

        /**
         * Rotates the last three rows of the state.
         */
        private void shiftRows() {
            byte tmp = this._tmp[1];
            this._tmp[1] = this._tmp[5];
            this._tmp[5] = this._tmp[9];
            this._tmp[9] = this._tmp[13];
            this._tmp[13] = tmp;

            tmp = this._tmp[2];
            this._tmp[2] = this._tmp[10];
            this._tmp[10] = tmp;
            tmp = this._tmp[6];
            this._tmp[6] = this._tmp[14];
            this._tmp[14] = tmp;

            tmp = this._tmp[3];
            this._tmp[3] = this._tmp[15];
            this._tmp[15] = this._tmp[11];
            this._tmp[11] = this._tmp[7];
            this._tmp[7] = tmp;
        }

        /**
         * Mixes one column of the state.
         *
         * @param index position of the first element of the column
         */
        private void mixColumn(int index) {
            int s0 = mul(2, this._tmp[index]) ^ mul(3, this._tmp[index + 1])
                    ^ (this._tmp[index + 2] & 0xff) ^ (this._tmp[index + 3] & 0xff);
            int s1 = (this._tmp[index] & 0xff) ^ mul(2, this._tmp[index + 1])
                    ^ mul(3, this._tmp[index + 2]) ^ (this._tmp[index + 3] & 0xff);
            int s2 = (this._tmp[index] & 0xff) ^ (this._tmp[index + 1] & 0xff)
                    ^ mul(2, this._tmp[index + 2]) ^ mul(3, this._tmp[index + 3]);
            int s3 = mul(3, this._tmp[index]) ^ (this._tmp[index + 1] & 0xff)
                    ^ (this._tmp[index + 2] & 0xff) ^ mul(2, this._tmp[index + 3]);
            this._tmp[index] = (byte) (s0 & 0xff);
            this._tmp[index + 1] = (byte) (s1 & 0xff);
            this._tmp[index + 2] = (byte) (s2 & 0xff);
            this._tmp[index + 3] = (byte) (s3 & 0xff);
        }

        /**
         * Mixes all columns of the state.
         */
        private void mixColumns() {
            mixColumn(0);
            mixColumn(4);
            mixColumn(8);
            mixColumn(12);
        }

        /**
         * Encrypts one block. The input block lies in {@code inBlock} starting at the position
         * {@code inIndex}. The {@code inBlock} won't be modified by this method. The encrypted block
         * will be stored in {@code outBlock} starting at position {@code outIndex}.
         *
         * @param inBlock  array containing the input block
         * @param inIndex  starting of the input block in {@code inBlock}
         * @param outBlock array to store the encrypted block
         * @param outIndex starting of the encrypted block in {@code outBlock}
         */
        public void encrypt(byte[] inBlock, int inIndex, byte[] outBlock,
                            int outIndex) {
            System.arraycopy(inBlock, inIndex, this._tmp, 0, BLOCK_SIZE);

            addRoundKey(0);
            for (int round = 1; round < ROUNDS; ++round) {
                substituteState();
                shiftRows();
                mixColumns();
                addRoundKey(round * BLOCK_SIZE);
            }

            substituteState();
            shiftRows();
            addRoundKey(ROUNDS * BLOCK_SIZE);

            System.arraycopy(this._tmp, 0, outBlock, outIndex, BLOCK_SIZE);
        }

        /**
         * Rotates the last three rows of the state. This method inverses {@link Aes256#shiftRows}.
         */
        private void invShiftRows() {
            byte tmp = this._tmp[13];
            this._tmp[13] = this._tmp[9];
            this._tmp[9] = this._tmp[5];
            this._tmp[5] = this._tmp[1];
            this._tmp[1] = tmp;

            tmp = this._tmp[2];
            this._tmp[2] = this._tmp[10];
            this._tmp[10] = tmp;
            tmp = this._tmp[6];
            this._tmp[6] = this._tmp[14];
            this._tmp[14] = tmp;

            tmp = this._tmp[3];
            this._tmp[3] = this._tmp[7];
            this._tmp[7] = this._tmp[11];
            this._tmp[11] = this._tmp[15];
            this._tmp[15] = tmp;
        }

        /**
         * Changes all {@code byte}s of the state. This method is the inverse of
         * {@link Aes256#shiftRows}.
         */
        private void invSubstituteState() {
            for (int i = 0; i < BLOCK_SIZE; ++i) {
                this._tmp[i] = this._invSBox[this._tmp[i] & 0xff];
            }
        }

        /**
         * Mixes a column of the state. This method inverses {@link Aes256#mixColumn}.
         *
         * @param index position of the first entry of the row
         */
        private void invMixColumn(int index) {
            int s0 = mul(0x0e, this._tmp[index]) ^ mul(0x0b, this._tmp[index + 1])
                    ^ mul(0x0d, this._tmp[index + 2]) ^ mul(0x09, this._tmp[index + 3]);
            int s1 = mul(0x09, this._tmp[index]) ^ mul(0x0e, this._tmp[index + 1])
                    ^ mul(0x0b, this._tmp[index + 2]) ^ mul(0x0d, this._tmp[index + 3]);
            int s2 = mul(0x0d, this._tmp[index]) ^ mul(0x09, this._tmp[index + 1])
                    ^ mul(0x0e, this._tmp[index + 2]) ^ mul(0x0b, this._tmp[index + 3]);
            int s3 = mul(0x0b, this._tmp[index]) ^ mul(0x0d, this._tmp[index + 1])
                    ^ mul(0x09, this._tmp[index + 2]) ^ mul(0x0e, this._tmp[index + 3]);
            this._tmp[index] = (byte) (s0 & 0xff);
            this._tmp[index + 1] = (byte) (s1 & 0xff);
            this._tmp[index + 2] = (byte) (s2 & 0xff);
            this._tmp[index + 3] = (byte) (s3 & 0xff);
        }

        /**
         * Mixes all columns of the state. This method inverses {@link Aes256#mixColumns}.
         */
        private void invMixColumns() {
            invMixColumn(0);
            invMixColumn(4);
            invMixColumn(8);
            invMixColumn(12);
        }

        /**
         * Decrypts a block. The encrypted block starts at {@code inIndex} in {@code inBlock}.
         * {@code inBlock} won't be modified by this method. The decrypted block will be stored at
         * {@code outIndex} in {@code outBlock}.
         *
         * @param inBlock  array containing the encrypted block
         * @param inIndex  starting point of the encrypted block
         * @param outBlock array to store the decrypted block
         * @param outIndex position of the decrypted block
         */
        public void decrypt(byte[] inBlock, int inIndex, byte[] outBlock,
                            int outIndex) {
            System.arraycopy(inBlock, inIndex, this._tmp, 0, BLOCK_SIZE);

            addRoundKey(ROUNDS * BLOCK_SIZE);
            for (int round = ROUNDS - 1; round > 0; --round) {
                invShiftRows();
                invSubstituteState();
                addRoundKey(round * BLOCK_SIZE);
                invMixColumns();
            }
            invShiftRows();
            invSubstituteState();
            addRoundKey(0);

            System.arraycopy(this._tmp, 0, outBlock, outIndex, BLOCK_SIZE);
        }
    }

    public static class Cbc {

        /**
         * size of a block in {@code byte}s
         */
        private static final int BLOCK_SIZE = 16;

        /**
         * cipher
         */
        private final Aes256 _cipher;

        /**
         * last calculated block
         */
        private final byte[] _current;

        /**
         * temporary block. It will only be used for decryption.
         */
        private byte[] _buffer = null;

        /**
         * temporary block.
         */
        private final byte[] _tmp;

        /**
         * buffer of the last output block. It will only be used for decryption.
         */
        private byte[] _outBuffer = null;

        /**
         * Is the output buffer filled?
         */
        private boolean _outBufferUsed = false;

        /**
         * temporary buffer to accumulate whole blocks of data
         */
        private final byte[] _overflow;

        /**
         * How many {@code byte}s of {@link Cbc#_overflow} are used?
         */
        private int _overflowUsed;

        private final OutputStream _output;

        /**
         * Creates the temporary buffers.
         *
         * @param iv     initial value of {@link Cbc#_tmp}
         * @param key    key for {@link Cbc#_cipher}
         * @param output stream where the encrypted or decrypted data is written
         */
        public Cbc(byte[] iv, byte[] key, OutputStream output) {
            this._cipher = new Aes256(key);
            this._current = new byte[BLOCK_SIZE];
            System.arraycopy(iv, 0, this._current, 0, BLOCK_SIZE);
            this._tmp = new byte[BLOCK_SIZE];
            this._buffer = new byte[BLOCK_SIZE];
            this._outBuffer = new byte[BLOCK_SIZE];
            this._outBufferUsed = false;
            this._overflow = new byte[BLOCK_SIZE];
            this._overflowUsed = 0;
            this._output = output;
        }

        /**
         * Encrypts a block. {@link Cbc#_current} will be modified.
         *
         * @param inBuffer  array containing the input block
         * @param outBuffer storage of the encrypted block
         */
        private void encryptBlock(byte[] inBuffer, byte[] outBuffer) {
            for (int i = 0; i < BLOCK_SIZE; ++i) {
                this._current[i] ^= inBuffer[i];
            }
            this._cipher.encrypt(this._current, 0, this._current, 0);
            System.arraycopy(this._current, 0, outBuffer, 0, BLOCK_SIZE);
        }

        /**
         * Decrypts a block. {@link Cbc#_current} will be modified.
         *
         * @param inBuffer  storage of the encrypted block
         * @param outBuffer storage of the decrypted block
         */
        private void decryptBlock(byte[] inBuffer) {
            System.arraycopy(inBuffer, 0, this._buffer, 0, BLOCK_SIZE);
            this._cipher.decrypt(this._buffer, 0, this._tmp, 0);
            for (int i = 0; i < BLOCK_SIZE; ++i) {
                this._tmp[i] ^= this._current[i];
                this._current[i] = this._buffer[i];
                this._outBuffer[i] = this._tmp[i];
            }
        }

        /**
         * Encrypts the array. The whole array will be encrypted.
         *
         * @param data {@code byte}s that should be encrypted
         * @throws IOException if the writing fails
         */
        public void encrypt(byte[] data) throws IOException {
            if (data != null) {
                encrypt(data, data.length);
            }
        }

        /**
         * Decrypts the array. The whole array will be decrypted.
         *
         * @param data {@code byte}s that should be decrypted
         * @throws IOException if the writing fails
         */
        public void decrypt(byte[] data) throws IOException {
            if (data != null) {
                decrypt(data, data.length);
            }
        }

        /**
         * Encrypts a part of the array. Only the first {@code length} {@code byte}s of the array will
         * be encrypted.
         *
         * @param data   {@code byte}s that should be encrypted
         * @param length number of {@code byte}s that should be encrypted
         * @throws IOException if the writing fails
         */
        public void encrypt(byte[] data, int length) throws IOException {
            if (data == null || length <= 0) {
                return;
            }

            for (int i = 0; i < length; ++i) {
                this._overflow[this._overflowUsed++] = data[i];
                if (this._overflowUsed == BLOCK_SIZE) {
                    encryptBlock(this._overflow, this._outBuffer);
                    this._output.write(this._outBuffer);
                    this._overflowUsed = 0;
                }
            }
        }

        /**
         * Decrypts a part of the array. Only the first {@code length} {@code byte}s of the array will
         * be decrypted.
         *
         * @param data   {@code byte}s that should be decrypted
         * @param length number of {@code byte}s that should be decrypted
         * @throws IOException if the writing fails
         */
        public void decrypt(byte[] data, int length) throws IOException {
            if (data == null || length <= 0) {
                return;
            }

            for (int i = 0; i < length; ++i) {
                this._overflow[this._overflowUsed++] = data[i];
                if (this._overflowUsed == BLOCK_SIZE) {
                    if (this._outBufferUsed) {
                        this._output.write(this._outBuffer);
                    }
                    decryptBlock(this._overflow);
                    this._outBufferUsed = true;
                    this._overflowUsed = 0;
                }
            }
        }

        /**
         * Finishes the encryption process.
         *
         * @throws IOException if the writing fails
         */
        public void finishEncryption() throws IOException {
            byte pad = (byte) (BLOCK_SIZE - this._overflowUsed);
            while (this._overflowUsed < BLOCK_SIZE) {
                this._overflow[this._overflowUsed++] = pad;
            }

            encryptBlock(this._overflow, this._outBuffer);
            this._output.write(this._outBuffer);
            this._output.close();
        }

        /**
         * Finishes the decryption process.
         *
         * @throws DecryptException if the last block is no legal conclusion of the stream
         * @throws IOException      if the writing fails
         */
        public void finishDecryption() throws DecryptException, IOException {
            if (this._overflowUsed != 0) {
//                throw new DecryptException();
            }
            if (!this._outBufferUsed) {
                return;
            }

            System.out.println(new String(_current));
            System.out.println(new String(_buffer));
            System.out.println(new String(_tmp));
            System.out.println(new String(_outBuffer));
            System.out.println(new String(_overflow));

            int pad = this._outBuffer[BLOCK_SIZE - 1] & 0xff;
//            if (pad <= 0 || pad > BLOCK_SIZE) {
//                throw new DecryptException();
//            }

//            int left = BLOCK_SIZE - pad;
//            if (left > 0) {
            this._output.write(this._outBuffer, 0, 16);
//            }
            this._output.close();
        }
    }

    public static final class DecryptException extends Exception {

        private static final long serialVersionUID = -935882404526228391L;

        /**
         * Creates the exception.
         */
        public DecryptException() {
            super("Decryption failed.");
        }
    }
}
