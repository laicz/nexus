package com.zhou.haizhi.nexus.concurrency.pool;

import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * Create by zhoumingbing on 2020-02-19
 */
public class ThreadPoolTest {

    @Test
    public void threadPoolAutoFlush() throws InterruptedException, ExecutionException, TimeoutException {
        for (int i = 0; i < 200; i++) {
            doSomeThing();
        }

        while (true) {
            Thread.sleep(5000);
            System.out.println("------------------" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()) + "------------------");
            ThreadInfo[] threadInfos = ManagementFactory.getThreadMXBean().dumpAllThreads(false, false);
            for (ThreadInfo threadInfo : threadInfos) {
                System.out.println("[" + threadInfo.getThreadId() + "]" + threadInfo.getThreadName());
            }
            System.gc();
        }
    }

    private void doSomeThing() throws InterruptedException, ExecutionException, TimeoutException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future<?> future = executorService.submit(() -> {
            try {
                TimeUnit.MINUTES.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
//        future.get(30, TimeUnit.SECONDS);
    }

    @Test
    public void curl() throws InterruptedException {
        RestTemplate restTemplate = new RestTemplate();
        List<Runnable> runnableList = new ArrayList<>();
        for (int i = 0; i < 200; i++) {
            runnableList.add(() -> {
                while (true) {
                    String forObject = restTemplate.getForObject("http://60.205.176.135:80", String.class);
                }
            });
        }
        for (Runnable runnable : runnableList) {
            new Thread(runnable).start();
        }
        Thread.sleep(1000000);
    }
}
