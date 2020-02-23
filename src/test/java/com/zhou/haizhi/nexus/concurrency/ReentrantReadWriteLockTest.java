package com.zhou.haizhi.nexus.concurrency;

import org.junit.Test;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Create by zhoumingbing on 2019-11-14
 */
public class ReentrantReadWriteLockTest {

    @Test
    public void readAndWriteLock() throws InterruptedException {
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
        ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();
        Runnable readRunnable = () -> {
            readLock.lock();
            System.out.println("我是读锁 现在加锁  .... ");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我是读锁 现在释放锁  .... ");
            readLock.unlock();
        };
        Runnable writeRunnable = () -> {
            writeLock.lock();
            System.out.println("我是写锁 现在加锁  .... ");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("我是写锁 现在释放锁  .... ");
            writeLock.unlock();
        };
        new Thread(readRunnable).start();
        new Thread(readRunnable).start();
        new Thread(writeRunnable).start();
        new Thread(readRunnable).start();
        new Thread(writeRunnable).start();
        new Thread(readRunnable).start();
        Thread.sleep(300000L);
    }

}

