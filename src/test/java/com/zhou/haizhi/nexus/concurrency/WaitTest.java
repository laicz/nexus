package com.zhou.haizhi.nexus.concurrency;

import org.junit.Test;

/**
 * Create by zhoumingbing on 2019-10-30
 */
public class WaitTest {

    @Test
    public void wait1() throws InterruptedException {
        final Object lock = new Object();
        Thread thread = new Thread(() -> {
            try {
                synchronized (lock) {
                    Thread.sleep(3000L);
                    System.out.println("wait....");
                    lock.wait();
                    System.out.println("被唤醒...." + System.currentTimeMillis());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();
        Thread.sleep(5000L);
        synchronized (lock){
            lock.notifyAll();
            System.out.println("唤醒...." + System.currentTimeMillis());
//            Thread.sleep(5000L);
        }
    }

    @Test
    public void wait2() throws InterruptedException {
        new Thread(() -> {
            try {
                apply();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        new Thread(() -> {
            try {
                free();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        Thread.sleep(2000L);
    }

    synchronized void apply() throws InterruptedException {
        System.out.println("wait....");
        wait();
        System.out.println("notify....");
    }

    synchronized void free() throws InterruptedException {
        Thread.sleep(1000L);
        System.out.println("qu notify....");
        notify();
    }
}
