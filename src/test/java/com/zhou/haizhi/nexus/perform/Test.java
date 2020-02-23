package com.zhou.haizhi.nexus.perform;

import org.apache.commons.lang3.StringUtils;

/**
 * Create by zhoumingbing on 2020-01-02
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(getCacheKey("key", "value1", "value2"));
    }

    private static String getCacheKey(String key, Object... value) {
        String cacheKey = key;
        for (Object val : value) {
            cacheKey = StringUtils.join(cacheKey, ":", val);
        }
        return cacheKey;
    }
}
