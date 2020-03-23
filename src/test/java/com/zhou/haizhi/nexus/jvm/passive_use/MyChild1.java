package com.zhou.haizhi.nexus.jvm.passive_use;

/**
 * Create by zhoumingbing on 2020-03-23
 */
public class MyChild1 extends MyParent1 {

    public static String str1 = "Hello World! child";

    static {
        System.out.println("MyChild1 static block");
    }

}
