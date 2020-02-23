package com.zhou.haizhi.nexus.concurrency;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * Create by zhoumingbing on 2019-11-22
 */
public class SubmitTaskTest {

    /**
     * 提交Runnable任务，Runnable接口的run()方法没有返回值，所以submit跟Thread.join()功能类似，等待其他线程执行完成
     * @throws Exception
     */
    @Test
    public void threadSubmit() throws Exception {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<?> submit = executorService.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {

                }
                System.out.println("结果" + "hello");
            }
        });
        System.out.println(submit.get());
    }

    /**
     * 线程实现Callable接口，该接口设置泛型V，即返回值类型
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void callableSubmit() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> submit = executorService.submit(() -> {
            System.out.println("当前线程:" + Thread.currentThread().getName());
            return "String";
        });
        System.out.println("获取结果：" + submit.get());
    }

    /**
     *
     * @throws ExecutionException
     * @throws InterruptedException
     */
    @Test
    public void threadAndResultSubmit() throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Map<String, String> resultMap = new HashMap<>();
        Future<Map<String, String>> submit = executorService.submit(() -> {
            resultMap.put("key", "value");
        }, resultMap);
        System.out.println(JSON.toJSONString(submit.get()));
    }
}
