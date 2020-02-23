package com.zhou.haizhi.nexus.concurrency;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Create by zhoumingbing on 2019-12-03
 */
public class ExecutorServiceTest {

    /**
     * 线程池是使用自定义的自定义的线程执行还是使用线程池内部的线程执行
     */
    @Test
    public void willCreateNewThread() throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Thread(() -> System.out.println("当前线程：" + Thread.currentThread().getName()), "this is my define thread"));
        Thread.sleep(100L);
    }
}
