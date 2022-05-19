package com.github.supermoonie.submerge.api.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author Administrator
 * @since 2022/5/15
 */
public class ColorUtilsTest {

    @Test
    public void hexToHAABBGGRR() {
        System.out.println(ColorUtils.hexToHAABBGGRR("#000000", 0.1f));
    }

    @Test
    public void haabbggrrToAlphaColor() {
        System.out.println(ColorUtils.HAABBGGRRToAlphaColor("&H000000FF"));
    }
}