package com.zhou.haizhi.nexus.base;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Create by zhoumingbing on 2020-03-13
 */
public class BigDecimalTest {

    @Test
    public void test1(){
        BigDecimal decimal1 = new BigDecimal("244674794");
        BigDecimal decimal2 = new BigDecimal("21342");
        System.out.println(decimal1.divide(decimal2,2, RoundingMode.HALF_UP));
    }

}
