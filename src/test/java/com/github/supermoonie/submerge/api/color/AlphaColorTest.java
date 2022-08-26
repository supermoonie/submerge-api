package com.github.supermoonie.submerge.api.color;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Administrator
 * @since 2022/8/26
 */
public class AlphaColorTest {

    @Test
    public void color() {
        AlphaColor alphaColor = new AlphaColor("000000FF");
        System.out.println(alphaColor.getRed());
        System.out.println(alphaColor.getGreen());
        System.out.println(alphaColor.getBlue());
        System.out.println(alphaColor.getAlpha());
    }

}
