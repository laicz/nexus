package com.zhou.haizhi.nexus.concurrency;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.StampedLock;

/**
 * Create by zhoumingbing on 2019-11-20
 */
public class StampedLockTest {

    @Test
    public void stampedLock() {
        StampedLock stampedLock = new StampedLock();
        Lock readLock = stampedLock.asReadLock();
        Lock writeLock = stampedLock.asWriteLock();
        readLock.lock();
        readLock.unlock();
        writeLock.lock();
        writeLock.unlock();

    }

    @Test
    public void multiStampedLock() throws InterruptedException {
        StampedLock stampedLock = new StampedLock();
        Lock readLock = stampedLock.asReadLock();
        Lock writeLock = stampedLock.asWriteLock();

        new Thread(() -> {
            for (; ; ) {
                readLock.lock();
                System.out.println("获取读锁成功 ... ");
                try {
                    Thread.sleep(new Random().nextInt(3000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                readLock.unlock();
                System.out.println("释放读锁");
            }
        }).start();

        new Thread(() -> {
            for (; ; ) {
                writeLock.lock();
                System.out.println("获取写锁成功 ... ");
                try {
                    Thread.sleep(new Random().nextInt(3000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                writeLock.unlock();
                System.out.println("释放写锁");
            }
        }).start();

        Thread.sleep(Integer.MAX_VALUE);
    }
}
