package com.zhou.haizhi.nexus.concurrency;

import org.junit.Test;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Create by zhoumingbing on 2019-11-25
 */
public class ThreadLocalTest {

    static final AtomicLong nextId = new AtomicLong(0);

    static final ThreadLocal<Long> tl = ThreadLocal.withInitial(nextId::getAndIncrement);

    @Test
    public void get() {
        System.out.println(tl.get());
        new Thread(() -> System.out.println(tl.get()));
    }

    @Test
    public void threadLocal() {
        final ThreadLocal<String> threadLocal = new ThreadLocal<>();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("thread1");
            }
        }, "t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                threadLocal.set("thread2");
            }
        }, "t2");

        System.out.println(threadLocal.get());
    }

    @Test
    public void twoLocal() {
        final ThreadLocal<String> local1 = new ThreadLocal<>();
        final ThreadLocal<String> local2 = new ThreadLocal<>();
        local1.get();
        local2.get();
    }


}
