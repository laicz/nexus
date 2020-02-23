package com.zhou.haizhi.nexus.concurrency;

import org.junit.Test;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * CompletableFuture的方法按照工作流的方式可以分成3种方式
 * 1、串行关系
 * 2、并行关系
 * 3、汇聚关系
 * <p>
 * 描述串行关系：主要有thenApply，thenAccept，thenRun和thenCompose四个系列的接口
 * 描述AND汇聚关系：thenCombine和runAfterBoth
 * 描述OR汇聚关系：applyToEither、acceptEither和runAfterEither系列的接口
 * 异常处理接口：exceptionally、whenComplete和handle
 * Create by zhoumingbing on 2019-11-24
 */
public class CompletableFutureTest {

    @Test
    public void getTest() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = new CompletableFuture<>();
        future.complete("this complete result ");
        System.out.println(future.get());
    }

    /**
     * runAsync()
     * 异步执行任务，并不需要等待任何结果返回，
     */
    @Test
    public void runAsync() throws ExecutionException, InterruptedException {
        CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(completableFuture.get());
    }

    /**
     * 异步提交
     */
    @Test
    public void supplyAsync() {

    }

    /**
     * 串行化接口
     */
    @Test
    public void serializeInterface() {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello World ! CompletableFuture ")
                .thenApply(s -> s + " QQ")
                .thenApply(String::toUpperCase);

        System.out.println(future.join());
    }


}
