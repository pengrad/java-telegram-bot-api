/*
 * Copyright (C) 2010 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.pengrad.telegrambot.passport.decrypt;

import junit.framework.TestCase;

import java.io.FileInputStream;
import java.util.Properties;

import static org.junit.Assert.assertArrayEquals;

public class Base64Test extends TestCase {
    private static final String TAG = "Base64Test";

    /**
     * Decodes a string, returning a string.
     */
    private String decodeString(String in) throws Exception {
        byte[] out = Base64.decode(in, 0);
        return new String(out);
    }

    /**
     * Assert that decoding 'in' throws IllegalArgumentException.
     */
    private void assertBad(String in) throws Exception {
        try {
            byte[] out = Base64.decode(in, 0);
            fail("should have failed to decode");
        } catch (IllegalArgumentException e) {
        }
    }

    /**
     * Assert that actual equals the first len bytes of expected.
     */
    private void assertEquals(byte[] expected, int len, byte[] actual) {
        assertEquals(len, actual.length);
        for (int i = 0; i < len; ++i) {
            assertEquals(expected[i], actual[i]);
        }
    }

    /**
     * Assert that actual equals the first len bytes of expected.
     */
    private void assertEquals(byte[] expected, int len, byte[] actual, int alen) {
        assertEquals(len, alen);
        for (int i = 0; i < len; ++i) {
            assertEquals(expected[i], actual[i]);
        }
    }

    /**
     * Assert that actual equals the first len bytes of expected.
     */
    private void assertEquals(byte[] expected, byte[] actual) {
        assertEquals(expected.length, actual.length);
        for (int i = 0; i < expected.length; ++i) {
            assertEquals(expected[i], actual[i]);
        }
    }

    public void testDecodeExtraChars() throws Exception {
        // padding 0
        assertEquals("hello, world", decodeString("aGVsbG8sIHdvcmxk"));
        assertBad("aGVsbG8sIHdvcmxk=");
        assertBad("aGVsbG8sIHdvcmxk==");
        assertBad("aGVsbG8sIHdvcmxk =");
        assertBad("aGVsbG8sIHdvcmxk = = ");
        assertEquals("hello, world", decodeString(" aGVs bG8s IHdv cmxk  "));
        assertEquals("hello, world", decodeString(" aGV sbG8 sIHd vcmx k "));
        assertEquals("hello, world", decodeString(" aG VsbG 8sIH dvcm xk "));
        assertEquals("hello, world", decodeString(" a GVsb G8sI Hdvc mxk "));
        assertEquals("hello, world", decodeString(" a G V s b G 8 s I H d v c m x k "));
        assertEquals("hello, world", decodeString("_a*G_V*s_b*G_8*s_I*H_d*v_c*m_x*k_"));
        assertEquals("hello, world", decodeString("aGVsbG8sIHdvcmxk"));
        // padding 1
        assertEquals("hello, world?!", decodeString("aGVsbG8sIHdvcmxkPyE="));
        assertEquals("hello, world?!", decodeString("aGVsbG8sIHdvcmxkPyE"));
        assertBad("aGVsbG8sIHdvcmxkPyE==");
        assertBad("aGVsbG8sIHdvcmxkPyE ==");
        assertBad("aGVsbG8sIHdvcmxkPyE = = ");
        assertEquals("hello, world?!", decodeString("aGVsbG8sIHdvcmxkPy E="));
        assertEquals("hello, world?!", decodeString("aGVsbG8sIHdvcmxkPy E"));
        assertEquals("hello, world?!", decodeString("aGVsbG8sIHdvcmxkPy E ="));
        assertEquals("hello, world?!", decodeString("aGVsbG8sIHdvcmxkPy E "));
        assertEquals("hello, world?!", decodeString("aGVsbG8sIHdvcmxkPy E = "));
        assertEquals("hello, world?!", decodeString("aGVsbG8sIHdvcmxkPy E   "));
        // padding 2
        assertEquals("hello, world.", decodeString("aGVsbG8sIHdvcmxkLg=="));
        assertEquals("hello, world.", decodeString("aGVsbG8sIHdvcmxkLg"));
        assertBad("aGVsbG8sIHdvcmxkLg=");
        assertBad("aGVsbG8sIHdvcmxkLg =");
        assertBad("aGVsbG8sIHdvcmxkLg = ");
        assertEquals("hello, world.", decodeString("aGVsbG8sIHdvcmxkL g=="));
        assertEquals("hello, world.", decodeString("aGVsbG8sIHdvcmxkL g"));
        assertEquals("hello, world.", decodeString("aGVsbG8sIHdvcmxkL g =="));
        assertEquals("hello, world.", decodeString("aGVsbG8sIHdvcmxkL g "));
        assertEquals("hello, world.", decodeString("aGVsbG8sIHdvcmxkL g = = "));
        assertEquals("hello, world.", decodeString("aGVsbG8sIHdvcmxkL g   "));
    }

    private static final byte[] BYTES = {(byte) 0xff, (byte) 0xee, (byte) 0xdd,
            (byte) 0xcc, (byte) 0xbb, (byte) 0xaa,
            (byte) 0x99, (byte) 0x88, (byte) 0x77};

    public void testBinaryDecode() throws Exception {
        assertEquals(BYTES, 0, Base64.decode("", 0));
        assertEquals(BYTES, 1, Base64.decode("/w==", 0));
        assertEquals(BYTES, 2, Base64.decode("/+4=", 0));
        assertEquals(BYTES, 3, Base64.decode("/+7d", 0));
        assertEquals(BYTES, 4, Base64.decode("/+7dzA==", 0));
        assertEquals(BYTES, 5, Base64.decode("/+7dzLs=", 0));
        assertEquals(BYTES, 6, Base64.decode("/+7dzLuq", 0));
        assertEquals(BYTES, 7, Base64.decode("/+7dzLuqmQ==", 0));
        assertEquals(BYTES, 8, Base64.decode("/+7dzLuqmYg=", 0));
    }

    private static final String lipsum =
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                    "Quisque congue eleifend odio, eu ornare nulla facilisis eget. " +
                    "Integer eget elit diam, sit amet laoreet nibh. Quisque enim " +
                    "urna, pharetra vitae consequat eget, adipiscing eu ante. " +
                    "Aliquam venenatis arcu nec nibh imperdiet tempor. In id dui " +
                    "eget lorem aliquam rutrum vel vitae eros. In placerat ornare " +
                    "pretium. Curabitur non fringilla mi. Fusce ultricies, turpis " +
                    "eu ultrices suscipit, ligula nisi consectetur eros, dapibus " +
                    "aliquet dui sapien a turpis. Donec ultricies varius ligula, " +
                    "ut hendrerit arcu malesuada at. Praesent sed elit pretium " +
                    "eros luctus gravida. In ac dolor lorem. Cras condimentum " +
                    "convallis elementum. Phasellus vel felis in nulla ultrices " +
                    "venenatis. Nam non tortor non orci convallis convallis. " +
                    "Nam tristique lacinia hendrerit. Pellentesque habitant morbi " +
                    "tristique senectus et netus et malesuada fames ac turpis " +
                    "egestas. Vivamus cursus, nibh eu imperdiet porta, magna " +
                    "ipsum mollis mauris, sit amet fringilla mi nisl eu mi. " +
                    "Phasellus posuere, leo at ultricies vehicula, massa risus " +
                    "volutpat sapien, eu tincidunt diam ipsum eget nulla. Cras " +
                    "molestie dapibus commodo. Ut vel tellus at massa gravida " +
                    "semper non sed orci.";


    public void testDecodeTelegramPrivateKey() {
        String privateKey;
        try {
            Properties properties = new Properties();
            properties.load(new FileInputStream("local.properties"));
            privateKey = properties.getProperty("PRIVATE_KEY");
        } catch (Exception e) {
            privateKey = System.getenv("PRIVATE_KEY");
        }
        String pkcs8Pem = privateKey;
        pkcs8Pem = pkcs8Pem.replace("-----BEGIN RSA PRIVATE KEY-----", "");
        pkcs8Pem = pkcs8Pem.replace("-----END RSA PRIVATE KEY-----", "");
        pkcs8Pem = pkcs8Pem.replaceAll("\\s+", "");
        byte[] pkcs8EncodedBytes = java.util.Base64.getMimeDecoder().decode(pkcs8Pem);
        byte[] res = Base64.decode(pkcs8Pem, Base64.NO_PADDING);
        assertArrayEquals(pkcs8EncodedBytes, res);
    }

    public void testSomeInputToIncreaseCoverage() {
        assertEquals("ok", new String(Base64.decode("b2s=", 0)));
        assertEquals("okasdfasdfasdfaq", new String(Base64.decode("b2thc2RmYXNkZmFzZGZhcc", 0)));
        // assertEquals("okasdfasdfasdfaq�", new String(Base64.decode("b2thc2RmYXNkZmFzZGZhccc", 0)));
        assertEquals(-57, Base64.decode("b2thc2RmYXNkZmFzZGZhccc", 0)[16]);
        try {
            Base64.decode("b2thc2RmYXNkZmFzZGZhc", 0);
        } catch (IllegalArgumentException e) {
            assertEquals("bad base-64", e.getMessage());
        }
        assertEquals(13, new Base64.Decoder(0, BYTES).maxOutputSize(4));
        assertTrue(new Base64.Decoder(0, new byte[BYTES.length * 3 / 4]).process(BYTES, 0, BYTES.length, false));
    }
}
