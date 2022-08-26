package com.github.supermoonie.submerge.api.color;

import java.awt.*;

/**
 * @author Administrator
 * @since 2022/5/19
 */
public class AlphaColor extends Color {

    public static final AlphaColor WHITE = new AlphaColor(Color.WHITE, 0);

    private final int alpha;

    public AlphaColor(int color) {
        super(color & 0xffffff);
        alpha = (color >> 24) & 0xff;
    }

    public AlphaColor(Color c, int alpha) {
        super(c.getRGB());
        this.alpha = alpha;
    }

    public AlphaColor(String color) {
        super(Integer.parseInt(color.substring(0, 6), 16));
        alpha = (color.length() > 6) ? (255 - Integer.parseInt(color.substring(6), 16)) : 0;
    }

    public AlphaColor(AlphaColor c) {
        this(c, c.alpha);
    }

    public Color getMixed(Color other, int newAlpha) {
        float a = newAlpha / 255f;
        float na = 1 - a;
        return new Color(calcColor(getRed(), other.getRed(), a, na),
                calcColor(getGreen(), other.getGreen(), a, na),
                calcColor(getBlue(), other.getBlue(), a, na));
    }

    public Color getMixed(Color other) {
        return getMixed(other, getAlpha());
    }

    private int calcColor(int col1, int col2, float a, float na) {
        int ret = (int) (col1 * a + col2 * na);
        if (ret < 0)
            ret = 0;
        if (ret > 255)
            ret = 255;
        return ret;
    }

    public Color getAColor() {
        return new Color(getRed(), getGreen(), getBlue(), alpha);
    }

    public int getAlpha() {
        return alpha;
    }

    public int getARGB() {
        return (getRGB() & 0xffffff) | (alpha << 24);
    }

    public String toString() {
        String res = Integer.toHexString(getRGB() & 0xffffff);
        String alp = Integer.toHexString(alpha);
        return "00".substring(0, 2 - alp.length()) + alp + "000000".substring(0, 6 - res.length()) + res;
    }

    public boolean equals(Object other) {
        if (other == null)
            return false;
        if (other instanceof AlphaColor) {
            if (((AlphaColor) other).alpha != alpha)
                return false;
            return super.equals(other);
        }
        return false;
    }
}
