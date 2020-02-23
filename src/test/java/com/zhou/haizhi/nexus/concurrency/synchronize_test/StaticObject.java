package com.zhou.haizhi.nexus.concurrency.synchronize_test;

/**
 * Create by zhoumingbing on 2020-02-11
 */
public class StaticObject {

    private static Object lock = new Object();

    public void lock() {
        synchronized (lock) {
            System.out.println("method ...... ");
        }
    }
}
