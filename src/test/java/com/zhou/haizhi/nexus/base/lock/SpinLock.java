package com.zhou.haizhi.nexus.base.lock;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * 实现简单的自旋锁
 * Create by zhoumingbing on 2020-06-01
 */
public class SpinLock {

    private volatile int state = 0;

    /**
     * stateOffset是静态不可变的
     */
    private static final long stateOffset;

    private static final Unsafe unsafe;

    static {
        try {
            /**
             * Caused by: java.lang.SecurityException: Unsafe
             * 	at sun.misc.Unsafe.getUnsafe(Unsafe.java:90)
             * 	at com.zhou.haizhi.nexus.base.lock.SpinLock.<clinit>(SpinLock.java:20)
             */
            Class<Unsafe> unsafeClass = Unsafe.class;
            Field field = unsafeClass.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe) field.get(null);

            stateOffset = unsafe.objectFieldOffset(SpinLock.class.getDeclaredField("state"));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new Error(e);
        }
    }

    public void lock() {
        for (; ; ) {
            if (unsafe.compareAndSwapInt(this, stateOffset, 0, 1)) {
                return;
            }
            //优化  当自旋获取锁失败了之后，可以让步，防止一直自旋获取锁，占用CPU
            Thread.currentThread().yield();
        }
    }

    public void unlock() {
        state = 0;
    }

    public static void main(String[] args) throws InterruptedException {
        final SpinLock spinLock = new SpinLock();
        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(() -> {
                spinLock.lock();
                System.out.println(Thread.currentThread().getName() + " get lock ... ");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " release lock ...");
                spinLock.unlock();
            }));
        }
        threads.parallelStream().forEach(Thread::start);
        Thread.sleep(10000);
    }

}
