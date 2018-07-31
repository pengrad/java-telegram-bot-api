package com.pengrad.telegrambot;

public class Data
{
    /* Number of rows */
    private int NUM_ROWS = 4;
    /* Number of columns */
    private int NUM_COLS;
    /* Number of bytes */
    private int NUM_BYTES;
    /* Matrix of data block */
    public byte[][] byteMatrix = null;
    /* Byte array of data */
    public byte[] byteArray = null;

    /**
     * Default Data object constructor.
     */
    public Data()
    {
        this(16);
    }

    /**
     * Data object constructor.
     * Creates Data object with bytes number of bytes and 4xn dimensions,
     * where n = number of bytes / number of rows.
     */
    private Data(int bytes) throws IllegalArgumentException
    {
        if (bytes == 16 || bytes == 24 || bytes == 32 ||
                bytes == 176 || bytes == 208 || bytes == 240)
        {
            this.NUM_BYTES = bytes;
            this.NUM_COLS = NUM_BYTES / NUM_ROWS;
            this.byteArray = new byte[NUM_BYTES];
            this.byteMatrix = new byte[NUM_ROWS][NUM_COLS];
        }
        else
            throw new IllegalArgumentException("Must be 16, 24, 32, 176, 208, or 240");
    }

    /**
     * Data object constructor.
     * Creates a Data object with the values of bArray.
     */
    public Data(byte[] bArray)
    {
        this(bArray.length);
        byteArrayToData(bArray);
    }

    /**
     * Data object constructor.
     * Creates Data object with bytes number of bytes and with byte values of
     * the ASCII represented HEX characters in hexStr.
     */
    public Data(int bytes, String hexStr)
    {
        this(bytes);
        hexToData(hexStr);
    }

    /**
     * Data object constructor.
     * Creates Data object of bytes size with the data in the key Data object.
     */
    public Data(int bytes, Data key)
    {
        this(bytes);
        assert (key != null);
        for (int row = 0; row < key.getNumRows(); row++)
            for (int col = 0; col < key.getNumCols(); col++)
                this.byteMatrix[row][col] = key.byteMatrix[row][col];
    }

    /**
     * Method that updates this Data object's byteArray with the corresponding
     * values in this Data object's byteMatrix.
     */
    public void updateArray() throws IllegalStateException
    {
        if (this.byteMatrix == null)
            throw new IllegalStateException("byteMatrix is null");
        for (int row = 0; row < NUM_ROWS; row++)
            for (int col = 0; col < NUM_COLS; col++)
                this.byteArray[row + (col * NUM_ROWS)] = this.byteMatrix[row][col];
    }

    /**
     * Method that updates this Data object's byteMatrix with the corresponding
     * values in this Data object's byteArray.
     */
    public void updateMatrix() throws IllegalStateException
    {
        if (this.byteArray == null)
            throw new IllegalStateException("byteArray is null");
        for (int row = 0; row < NUM_ROWS; row++)
            for (int col = 0; col < NUM_COLS; col++)
                this.byteMatrix[row][col] = this.byteArray[row + (col * NUM_ROWS)];
    }

    /**
     * Method that copys a byte array into this Data objects byteArray.
     */
    private void byteArrayToData(byte[] bArray)
    {
        assert (bArray != null);
        for (int i = 0; i < NUM_BYTES; i++)
            this.byteArray[i] = bArray[i];
        updateMatrix();
    }

    /**
     * Method that converts a string of ASCII HEX characters to a byte array.
     * If the input contains ASCII characters that aren't HEX characters,
     * then it returns NULL.
     * If hexStr short characters, then it is right padded with '0'.
     * If hexStr contains more characters than needed, then the extra
     * characters are ignored.
     */
    private void hexToData(String hexStr)
    {
        assert (hexStr != null);
        /* If hexStr contains non-HEX characters */
        if (!hexStr.matches("^[0123456789ABCDEFabcdef]+$"))
            this.byteArray = null;
            /* If hexStr is short, right pad with '0' */
        else if (hexStr.length() < NUM_BYTES * 2)
        {
            if (NUM_BYTES == 32)
                hexStr = String.format("%1$-64s", hexStr);
            else if (NUM_BYTES == 24)
                hexStr = String.format("%1$-48s", hexStr);
            else
                hexStr = String.format("%1$-32s", hexStr);
            hexStr = hexStr.replace(' ', '0');
        }

        /* If hexStr didn't contain invalid characters*/
        if (this.byteArray != null)
        {
            /* Convert hexStr to byteArray */
            for (int i = 0; i < NUM_BYTES * 2; i += 2)
                this.byteArray[i / 2] = hexToByte(hexStr.substring(i, i + 2));
            updateMatrix();
        }
    }

    /**
     * Method that converts two ASCII HEX characters to a byte with that value.
     */
    private byte hexToByte(String hexStr) throws IllegalArgumentException
    {
        assert (hexStr != null);
        if (hexStr.length() != 2)
            throw new IllegalArgumentException("Invalid hexStr length");
        return Integer.decode("0x" + hexStr).byteValue();
    }

    /**
     * Method used to XOR the bytes in this Data object with those of another.
     * Both Data objects must have the same NUM_BYTES.
     */
    public Data XOR(Data other) throws IllegalArgumentException
    {
        assert (this.byteArray != null && other != null);
        if (this.NUM_BYTES != other.getNumBytes())
            throw new IllegalArgumentException("Differing number of bytes");
        for (int i = 0; i < NUM_BYTES; i++)
            this.byteArray[i] ^= other.byteArray[i];
        this.updateMatrix();
        return this;
    }

    /**
     * Method to convert a Data object to an array of 16 byte Data objects.
     * Used to convert the expanded key to an array of keys that can be
     * indexed by the round.
     */
    public Data[] toDataArray()
    {
        assert (this.byteMatrix != null);
        /* Column offset in expanded key */
        int offset = 0;
        Data newData = null;
        /* Create array with appropriate length */
        Data[] dataArray = new Data[NUM_BYTES / 16];
        for (int i = 0; i < dataArray.length; i++)
        {
            /* Create round key */
            newData = new Data(16);
            for (int row = 0; row < newData.getNumRows(); row++)
                for (int col = 0; col < newData.getNumCols(); col++)
                    newData.byteMatrix[row][col] = this.byteMatrix[row][col + offset];
            /* Update column offset */
            offset += 4;
            newData.updateArray();
            /* Store round key */
            dataArray[i] = newData;
        }
        return dataArray;
    }

    /**
     * toString method that prints the Data object in array form.
     */
    public String toString()
    {
        return toString(this.byteArray, "");
    }

    /**
     * toString method that prints the Data object in array form.
     */
    public String toString(byte[] bArray) throws NullPointerException
    {
        return toString(bArray, " ");
    }

    /**
     * toString method that prints the Data object in array form.
     */
    public String toString(byte[] bArray, String spacer)
    {
        assert (bArray != null && spacer != null);
        StringBuilder sb = new StringBuilder();
        int mod = 0;
        for (byte b : bArray)
        {
            sb.append(String.format("%02X", b));
            mod += 2;
            if (mod % 2 == 0 && mod != NUM_BYTES * 2)
                sb.append(spacer);
        }
        return sb.toString();
    }

    /**
     * toString method that prints the Data object in matrix form.
     */
    public String toString(byte[][] bMatrix)
    {
        return toString(bMatrix, " ", "");
    }

    /**
     * toString method that prints the Data object in matrix form.
     */
    public String toString(byte[][] bMatrix, String spacer)
    {
        return toString(bMatrix, spacer, "");
    }

    /**
     * toString method that prints the Data object in matrix form.
     */
    public String toString(byte[][] bMatrix, String spacer, String prefix)
    {
        assert (bMatrix != null && spacer != null && prefix != null);
        StringBuilder sb = new StringBuilder();
        for (byte[] bArray : bMatrix)
        {
            sb.append(prefix);
            for (byte b : bArray)
                sb.append(String.format("%02X", b)).append(spacer);
            sb.setCharAt(sb.lastIndexOf(spacer), '\n');
        }
        sb.deleteCharAt(sb.lastIndexOf("\n"));
        return sb.toString();
    }

    /**
     * Returns the NUM_ROWS of this Data object.
     */
    public int getNumRows()
    {
        return this.NUM_ROWS;
    }

    /**
     * Returns the NUM_COLS of this Data object.
     */
    public int getNumCols()
    {
        return this.NUM_COLS;
    }

    /**
     * Returns the NUM_BYTES of this Data object.
     */
    public int getNumBytes()
    {
        return this.NUM_BYTES;
    }
}