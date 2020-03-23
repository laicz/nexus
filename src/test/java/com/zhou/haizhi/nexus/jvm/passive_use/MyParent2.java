package com.zhou.haizhi.nexus.jvm.passive_use;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

/**
 * Create by zhoumingbing on 2020-03-23
 */
public class MyParent2 {

    public static final String str = "Hello World";

    public static final String str1 = RandomStringUtils.randomAlphabetic(8);

    static {
        System.out.println("MyParent2 static block");
    }
}
