package com.zhou.haizhi.nexus.utils;

import java.lang.management.ManagementFactory;
import java.math.BigDecimal;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Create by zhoumingbing on 2019-10-28
 */
public class MyPoolSizeCalculator extends PoolSizeCalculator {
    @Override
    protected Runnable createTask() {
        return new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++)
                    System.out.println(i);
            }
        };
    }

    @Override
    protected BlockingQueue<Runnable> createWorkQueue() {
        return new LinkedBlockingQueue<>();
    }

    @Override
    protected long getCurrentThreadCPUTime() {
        return ManagementFactory.getThreadMXBean().getCurrentThreadCpuTime();
    }

    public static void main(String[] args) throws InterruptedException,
            InstantiationException,
            IllegalAccessException,
            ClassNotFoundException {
        MyPoolSizeCalculator calculator = new MyPoolSizeCalculator();
        calculator.calculateBoundaries(new BigDecimal(1.0),
                new BigDecimal(100000));
    }
}
