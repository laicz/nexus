package com.zhou.haizhi.nexus.redis;

import com.alibaba.fastjson.JSON;
import com.zhou.haizhi.nexus.NexusApplication;
import com.zhou.haizhi.nexus.cache.StringCacheService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CountDownLatch;

/**
 * Create by zhoumingbing on 2019-10-27
 */
@SpringBootTest(classes = NexusApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class RedisConfigTest {

    private final String KEY = "test_key::test_key";

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private StringCacheService stringCacheService;

    @Test
    public void set() {
        Map<String, String> map = new HashMap<>();
        map.put("key1", "value1");
        map.put("key2", "value1");
        map.put("key3", "value1");
        map.put("key4", "value1");
        map.put("key5", "value1");
        map.put("key6", "value1");
        map.put("key7", "value1");
        map.put("key8", "value1");
        map.put("key9", "value1");
        map.put("key10", "value1");
        map.put("key11", "value1");
        map.put("key12", "value1");
        map.put("key13", "value1");
        map.put("key14", "value1");
        map.put("key15", "value1");
        map.put("key16", "value1");
        map.put("key17", "value1");
        map.put("key18", "value1");
        map.put("key19", "value1");
        redisTemplate.opsForValue().set(KEY, JSON.toJSONString(map));
    }

    @Test
    public void get() {
        String s = redisTemplate.opsForValue().get(KEY);
        System.out.println(s);
    }

    @Test
    public void testAopCache() {
        String s = stringCacheService.get("test_key");
        System.out.println(s);
    }

    @Test
    public void caiculateManu() throws InterruptedException {
        int per = 200;
        CountDownLatch countDownLatch = new CountDownLatch(per);
        long st = System.currentTimeMillis();
        for (int i = 0; i < per; i++) {
            new Thread(() -> {
                for (int j = 0; j < 2000; j++) {
                    redisTemplate.opsForValue().get(KEY);
                }
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println("cost time :" + (System.currentTimeMillis() - st));
    }

    @Test
    public void caiculateCacheable() throws InterruptedException {
        int per = 200;
        CountDownLatch countDownLatch = new CountDownLatch(per);
        long st = System.currentTimeMillis();
        for (int i = 0; i < per; i++) {
            new Thread(() -> {
                for (int j = 0; j < 2000; j++) {
                    stringCacheService.get("test_key");
                }
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println("cost time :" + (System.currentTimeMillis() - st));
    }
}
