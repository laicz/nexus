package com.zhou.haizhi.nexus.base;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * Create by zhoumingbing on 2020-02-17
 */
public class FloatTest {

    @Test
    public void baseType() {
        float f1 = 1.0f - 0.9f;
        float f2 = 0.9f - 0.8f;
        System.out.println(f1 == f2);
    }

    @Test
    public void packageType() {
        float f1 = 1.0f - 0.9f;
        float f2 = 0.9f - 0.8f;
        Float x = Float.valueOf(f1);
        Float y = Float.valueOf(f2);
        System.out.println(x.equals(y));
    }

    @Test
    public void bigDecimal() {
        BigDecimal a = new BigDecimal("1.0");
        BigDecimal b = new BigDecimal("0.9");
        BigDecimal c = new BigDecimal("0.8");
        System.out.println((a.subtract(b)).equals(b.subtract(c)));
    }
}
