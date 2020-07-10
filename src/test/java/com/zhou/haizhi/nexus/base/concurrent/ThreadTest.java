package com.zhou.haizhi.nexus.base.concurrent;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Create by zhoumingbing on 2020-05-15
 */
public class ThreadTest {

    @Test
    public void newThreadTest() throws InterruptedException {
        Thread.dumpStack();
        Thread.sleep(Long.MAX_VALUE);
    }

    @Test
    public void threadLocalTest() throws InterruptedException {
        ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
        Thread thread = new Thread(() -> {
            try {
                threadLocal.set(1);
                System.out.println("ThreadName -> " + Thread.currentThread().getName() + " : " + threadLocal.get());
                Thread.sleep(2000);
                System.out.println("ThreadName -> " + Thread.currentThread().getName() + " : " + threadLocal.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        Thread.sleep(100);
        System.out.println("ThreadName -> " + Thread.currentThread().getName() + " : " + threadLocal.get());
        threadLocal.set(2);
        Thread.sleep(3000);
        System.out.println("ThreadName -> " + Thread.currentThread().getName() + " : " + threadLocal.get());

    }

    @Test
    public void threadLocalRemove() {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("thread main");
        threadLocal.remove();
        String s = threadLocal.get();
        System.out.println(s);
    }

    @Test
    public void multiShare() throws InterruptedException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        List<Thread> runnables = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            runnables.add(new Thread(() -> {
                for(;;){
                    System.out.println(simpleDateFormat.format(new Date()));
                }
            }));
        }
        for (Thread thread : runnables) {
            thread.start();
        }
        Thread.sleep(100000);
    }
}
