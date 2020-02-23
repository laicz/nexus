package com.zhou.haizhi.nexus.concurrency;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * Create by zhoumingbing on 2019-11-19
 */
public class FutureTaskTest {

    @Test
    public void futureTask() throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> submit = executorService.submit(() -> {
            Thread.sleep(10000L);
            return "result";
        });
        Thread.sleep(100L);
        boolean result = false;
        while (!result) {
            try {
                System.out.println(System.currentTimeMillis() + " ：" + submit.get(1, TimeUnit.SECONDS));
                result = true;
            } catch (TimeoutException e) {
                System.out.println(System.currentTimeMillis() + " ：" + "我正在尝试获取结果失败....");
            }
        }
    }

    @Test
    public void completableFuture() {
        CompletableFuture<String> messageFuture = CompletableFuture.completedFuture("message");
        Assert.assertTrue(messageFuture.isDone());
        Assert.assertEquals("message", messageFuture.getNow(null));
    }

    @Test
    public void runAsync() throws InterruptedException {
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            Assert.assertTrue(Thread.currentThread().isDaemon());
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Assert.assertFalse(completableFuture.isDone());
        Thread.sleep(2000L);
        Assert.assertTrue(completableFuture.isDone());

    }
}
