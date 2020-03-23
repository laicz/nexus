package com.zhou.haizhi.nexus.jvm.passive_use;

/**
 * Create by zhoumingbing on 2020-03-23
 */
public class Singleton {
    public static int counter1;

    private static Singleton singleton = new Singleton();
    public static int counter2 = 0;

    private Singleton() {
        counter1++;
        counter2++;
    }

    public static Singleton getInstance() {
        return singleton;
    }
}
