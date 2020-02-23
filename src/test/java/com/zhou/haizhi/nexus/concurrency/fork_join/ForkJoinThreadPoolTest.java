package com.zhou.haizhi.nexus.concurrency.fork_join;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;

/**
 * Create by zhoumingbing on 2019-12-08
 */
public class ForkJoinThreadPoolTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask countTask = new CountTask(1, 10);
        ForkJoinTask<Integer> futureTask = forkJoinPool.submit(countTask);
        System.out.println("finally result:" + futureTask.get());
    }
}
