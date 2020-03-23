package com.zhou.haizhi.nexus.jvm.passive_use;

import org.junit.Test;

/**
 * Create by zhoumingbing on 2020-03-23
 */
public class MyTest5 {

    /**
     *
     */
    @Test
    public void test() {
        System.out.println(MyChild5.b);
    }

    /**
     * public class Singleton {
     * public static int counter1;
     * public static int counter2 = 0;
     * <p>
     * private static Singleton singleton = new Singleton();
     * <p>
     * private Singleton() {
     * counter1++;
     * counter2++;
     * }
     * <p>
     * public static Singleton getInstance() {
     * return singleton;
     * }
     * }
     */
    @Test
    public void test1() {
        Singleton singleton = Singleton.getInstance();
        System.out.println(Singleton.counter1);
        System.out.println(Singleton.counter2);
    }
}
