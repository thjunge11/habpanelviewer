package vier_bier.de.habpanelviewer.motion;

/**
 * Brightness data for an image.
 */
class LumaData {
    private byte[] data = null;
    private byte[][] average = null;
    private int width;
    private int height;

    LumaData(byte[] data, int width, int height, int mXBoxes, int mYBoxes) {
        if (data == null) throw new NullPointerException();

        this.data = data.clone();
        this.width = width;
        this.height = height;

        average = new byte[mXBoxes][mYBoxes];
        for (int x = 0; x < mXBoxes; x++) {
            for (int y = 0; y < mYBoxes; y++) {
                average[x][y] = -1;
            }
        }
    }

    /**
     * Get the LumaData.
     *
     * @return integer array of the LumaData.
     */
    public byte[] getData() {
        return data;
    }

    /**
     * Get the width of the LumaData.
     *
     * @return integer representing the width of the state.
     */
    public int getWidth() {
        return width;
    }

    /**
     * Get the height of the LumaData.
     *
     * @return integer representing the height of the state.
     */
    public int getHeight() {
        return height;
    }

    int getAverage(int xBox, int yBox) {
        return average[xBox][yBox];
    }

    void setAverage(int xBox, int yBox, byte result) {
        average[xBox][yBox] = result;
    }

    boolean isDarker(int minLuma) {
        int lumaSum = 0;
        for (int i : data) {
            lumaSum += (i - Byte.MIN_VALUE - 16);
        }
        return lumaSum < minLuma;
    }
}
