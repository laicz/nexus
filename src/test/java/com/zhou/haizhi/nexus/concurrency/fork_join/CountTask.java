package com.zhou.haizhi.nexus.concurrency.fork_join;

import java.util.concurrent.RecursiveTask;

/**
 * Create by zhoumingbing on 2019-12-08
 */
public class CountTask extends RecursiveTask<Integer> {

    private static final int THRESHOLD = 2;
    private int start;
    private int end;

    public CountTask(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        boolean compute = (end - start) <= THRESHOLD;
        if (compute) {
            for (int i = start; i <= end; i++) {
                sum += i;
            }
            System.out.println("current thread:" + Thread.currentThread().getName() + "execute task , calculate start:[" + start + "] to [" + end + "],result:[" + sum + "]");
            return sum;
        } else {
            System.out.println("current thread:" + Thread.currentThread().getName() + "split task , start:[" + start + "] to [" + end + "]");
            int middle = (start + end) >> 1;
            CountTask task1 = new CountTask(start, middle);
            CountTask task2 = new CountTask(middle + 1, end);
            //执行子任务
            task1.fork();
            task2.fork();
            invokeAll(task1, task2);
            return task1.join() + task2.join();
        }
    }
}
