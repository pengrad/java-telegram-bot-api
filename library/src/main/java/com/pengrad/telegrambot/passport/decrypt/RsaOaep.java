package com.pengrad.telegrambot.passport.decrypt;

import javax.crypto.Cipher;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.RSAPrivateCrtKeySpec;

/**
 * Stas Parshin
 * 02 August 2018
 */
class RsaOaep {

    static byte[] decrypt(String privateKey, byte[] secret) throws Exception {
        String pkcs8Pem = privateKey;
        pkcs8Pem = pkcs8Pem.replace("-----BEGIN RSA PRIVATE KEY-----", "");
        pkcs8Pem = pkcs8Pem.replace("-----END RSA PRIVATE KEY-----", "");
        pkcs8Pem = pkcs8Pem.replaceAll("\\s+", "");
        byte[] pkcs8EncodedBytes = Base64.decode(pkcs8Pem, 0);

        KeyFactory kf = KeyFactory.getInstance("RSA");
        PrivateKey privKey = kf.generatePrivate(getRSAKeySpec(pkcs8EncodedBytes));

        Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-1AndMGF1Padding");
        cipher.init(Cipher.DECRYPT_MODE, privKey);
        return cipher.doFinal(secret);
    }

    private static RSAPrivateCrtKeySpec getRSAKeySpec(byte[] keyBytes) throws IOException {

        DerParser parser = new DerParser(keyBytes);

        Asn1Object sequence = parser.read();
        if (sequence.getType() != DerParser.SEQUENCE)
            throw new IOException("Invalid DER: not a sequence"); //$NON-NLS-1$

        // Parse inside the sequence
        parser = sequence.getParser();

        parser.read(); // Skip version
        BigInteger modulus = parser.read().getInteger();
        BigInteger publicExp = parser.read().getInteger();
        BigInteger privateExp = parser.read().getInteger();
        BigInteger prime1 = parser.read().getInteger();
        BigInteger prime2 = parser.read().getInteger();
        BigInteger exp1 = parser.read().getInteger();
        BigInteger exp2 = parser.read().getInteger();
        BigInteger crtCoef = parser.read().getInteger();

        RSAPrivateCrtKeySpec keySpec = new RSAPrivateCrtKeySpec(
                modulus, publicExp, privateExp, prime1, prime2,
                exp1, exp2, crtCoef);

        return keySpec;
    }

    private static class DerParser {

        // Classes
        public final static int UNIVERSAL = 0x00;
        public final static int APPLICATION = 0x40;
        public final static int CONTEXT = 0x80;
        public final static int PRIVATE = 0xC0;

        // Constructed Flag
        public final static int CONSTRUCTED = 0x20;

        // Tag and data types
        public final static int ANY = 0x00;
        public final static int BOOLEAN = 0x01;
        public final static int INTEGER = 0x02;
        public final static int BIT_STRING = 0x03;
        public final static int OCTET_STRING = 0x04;
        public final static int NULL = 0x05;
        public final static int OBJECT_IDENTIFIER = 0x06;
        public final static int REAL = 0x09;
        public final static int ENUMERATED = 0x0a;
        public final static int RELATIVE_OID = 0x0d;

        public final static int SEQUENCE = 0x10;
        public final static int SET = 0x11;

        public final static int NUMERIC_STRING = 0x12;
        public final static int PRINTABLE_STRING = 0x13;
        public final static int T61_STRING = 0x14;
        public final static int VIDEOTEX_STRING = 0x15;
        public final static int IA5_STRING = 0x16;
        public final static int GRAPHIC_STRING = 0x19;
        public final static int ISO646_STRING = 0x1A;
        public final static int GENERAL_STRING = 0x1B;

        public final static int UTF8_STRING = 0x0C;
        public final static int UNIVERSAL_STRING = 0x1C;
        public final static int BMP_STRING = 0x1E;

        public final static int UTC_TIME = 0x17;
        public final static int GENERALIZED_TIME = 0x18;

        protected InputStream in;

        /**
         * Create a new DER decoder from an input stream.
         *
         * @param in The DER encoded stream
         */
        public DerParser(InputStream in) throws IOException {
            this.in = in;
        }

        /**
         * Create a new DER decoder from a byte array.
         *
         * @param bytes The encoded bytes
         * @throws IOException
         */
        public DerParser(byte[] bytes) throws IOException {
            this(new ByteArrayInputStream(bytes));
        }

        /**
         * Read next object. If it's constructed, the value holds
         * encoded content and it should be parsed by a new
         * parser from <code>Asn1Object.getParser</code>.
         *
         * @return A object
         * @throws IOException
         */
        public Asn1Object read() throws IOException {
            int tag = in.read();

            if (tag == -1)
                throw new IOException("Invalid DER: stream too short, missing tag"); //$NON-NLS-1$

            int length = getLength();

            byte[] value = new byte[length];
            int n = in.read(value);
            if (n < length)
                throw new IOException("Invalid DER: stream too short, missing value"); //$NON-NLS-1$

            Asn1Object o = new Asn1Object(tag, length, value);

            return o;
        }

        /**
         * Decode the length of the field. Can only support length
         * encoding up to 4 octets.
         * <p>
         * <p/>In BER/DER encoding, length can be encoded in 2 forms,
         * <ul>
         * <li>Short form. One octet. Bit 8 has value "0" and bits 7-1
         * give the length.
         * <li>Long form. Two to 127 octets (only 4 is supported here).
         * Bit 8 of first octet has value "1" and bits 7-1 give the
         * number of additional length octets. Second and following
         * octets give the length, base 256, most significant digit first.
         * </ul>
         *
         * @return The length as integer
         * @throws IOException
         */
        private int getLength() throws IOException {

            int i = in.read();
            if (i == -1)
                throw new IOException("Invalid DER: length missing"); //$NON-NLS-1$

            // A single byte short length
            if ((i & ~0x7F) == 0)
                return i;

            int num = i & 0x7F;

            // We can't handle length longer than 4 bytes
            if (i >= 0xFF || num > 4)
                throw new IOException("Invalid DER: length field too big (" //$NON-NLS-1$
                        + i + ")"); //$NON-NLS-1$

            byte[] bytes = new byte[num];
            int n = in.read(bytes);
            if (n < num)
                throw new IOException("Invalid DER: length too short"); //$NON-NLS-1$

            return new BigInteger(1, bytes).intValue();
        }

    }

    /**
     * An ASN.1 TLV. The object is not parsed. It can
     * only handle integers and strings.
     *
     * @author zhang
     */
    private static class Asn1Object {

        protected final int type;
        protected final int length;
        protected final byte[] value;
        protected final int tag;

        /**
         * Construct a ASN.1 TLV. The TLV could be either a
         * constructed or primitive entity.
         * <p>
         * <p/>The first byte in DER encoding is made of following fields,
         * <pre>
         * -------------------------------------------------
         * |Bit 8|Bit 7|Bit 6|Bit 5|Bit 4|Bit 3|Bit 2|Bit 1|
         * -------------------------------------------------
         * |  Class    | CF  |     +      Type             |
         * -------------------------------------------------
         * </pre>
         * <ul>
         * <li>Class: Universal, Application, Context or Private
         * <li>CF: Constructed flag. If 1, the field is constructed.
         * <li>Type: This is actually called tag in ASN.1. It
         * indicates data type (Integer, String) or a construct
         * (sequence, choice, set).
         * </ul>
         *
         * @param tag    Tag or Identifier
         * @param length Length of the field
         * @param value  Encoded octet string for the field.
         */
        public Asn1Object(int tag, int length, byte[] value) {
            this.tag = tag;
            this.type = tag & 0x1F;
            this.length = length;
            this.value = value;
        }

        public int getType() {
            return type;
        }

        public int getLength() {
            return length;
        }

        public byte[] getValue() {
            return value;
        }

        public boolean isConstructed() {
            return (tag & DerParser.CONSTRUCTED) == DerParser.CONSTRUCTED;
        }

        /**
         * For constructed field, return a parser for its content.
         *
         * @return A parser for the construct.
         * @throws IOException when not constucted
         */
        public DerParser getParser() throws IOException {
            if (!isConstructed())
                throw new IOException("Invalid DER: can't parse primitive entity"); //$NON-NLS-1$

            return new DerParser(value);
        }

        /**
         * Get the value as integer
         *
         * @return BigInteger
         * @throws IOException invalid der
         */
        public BigInteger getInteger() throws IOException {
            if (type != DerParser.INTEGER)
                throw new IOException("Invalid DER: object is not integer"); //$NON-NLS-1$

            return new BigInteger(value);
        }
    }

}
