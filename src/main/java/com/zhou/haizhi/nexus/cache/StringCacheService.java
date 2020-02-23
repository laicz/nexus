package com.zhou.haizhi.nexus.cache;

import com.alibaba.fastjson.JSON;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Create by zhoumingbing on 2019-10-27
 */
@Component
public class StringCacheService {
    public final String test_key = "test_key";

    @Cacheable(value = "test_key")
    public String get(String key) {
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
        System.out.println("没有使用缓存");
        return JSON.toJSONString(map);
    }
}
