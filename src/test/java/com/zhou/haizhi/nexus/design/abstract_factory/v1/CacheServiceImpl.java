package com.zhou.haizhi.nexus.design.abstract_factory.v1;


import com.zhou.haizhi.nexus.design.abstract_factory.CacheService;
import com.zhou.haizhi.nexus.design.abstract_factory.EGM;
import com.zhou.haizhi.nexus.design.abstract_factory.IIR;
import com.zhou.haizhi.nexus.design.abstract_factory.RedisUtils;

import java.util.concurrent.TimeUnit;

/**
 * 使用if else 实现
 * 虽然实现简单，但是如果后期维护会很困难
 *
 * @author zhoumingbing
 * @data 2021/5/4
 */
public class CacheServiceImpl implements CacheService {

    private RedisUtils redisUtils = new RedisUtils();

    private EGM egm = new EGM();

    private IIR iir = new IIR();

    @Override
    public String get(String key, int redisType) {
        if (redisType == 1) {
            return egm.gain(key);
        } else if (redisType == 2) {
            return iir.get(key);
        } else {
            return redisUtils.get(key);
        }
    }

    @Override
    public void set(String key, String value, int redisType) {
        if (redisType == 1) {
            egm.set(key, value);
        } else if (redisType == 2) {
            iir.set(key, value);
        } else {
            redisUtils.set(key, value);
        }
    }

    @Override
    public void set(String key, String value, long timeout, TimeUnit timeUnit, int redisType) {
        if (redisType == 1) {
            egm.setEx(key, value, timeout, timeUnit);
        } else if (redisType == 2) {
            iir.setExpire(key, value, timeout, timeUnit);
        } else {
            redisUtils.set(key, value, timeout, timeUnit);
        }
    }

    @Override
    public void del(String key, int redisType) {
        if (redisType == 1) {
            egm.delete(key);
        } else if (redisType == 2) {
            iir.del(key);
        } else {
            redisUtils.del(key);
        }
    }
}
