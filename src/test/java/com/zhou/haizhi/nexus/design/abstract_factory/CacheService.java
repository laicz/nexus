package com.zhou.haizhi.nexus.design.abstract_factory;

import java.util.concurrent.TimeUnit;

/**
 * 缓存接口
 *
 * @author zhoumingbing
 * @data 2021/5/4
 */
public interface CacheService {

    String get(final String key, int redisType);

    void set(String key, String value, int redisType);

    void set(String key, String value, long timeout, TimeUnit timeUnit, int redisType);

    void del(String key, int redisType);

}
