package com.zhou.haizhi.nexus.jvm.passive_use;

/**
 * Create by zhoumingbing on 2020-03-23
 */
public class MyParent1 {
    public static String str = "Hello World!";

    static {
        System.out.println("MyParent static block");
    }
}
