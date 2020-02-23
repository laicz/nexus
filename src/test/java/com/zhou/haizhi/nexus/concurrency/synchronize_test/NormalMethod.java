package com.zhou.haizhi.nexus.concurrency.synchronize_test;

/**
 * Create by zhoumingbing on 2020-02-11
 */
public class NormalMethod {

    public synchronized void lock(){
        System.out.println("lock ...... ");
    }
}
