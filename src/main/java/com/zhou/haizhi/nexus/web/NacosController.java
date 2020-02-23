package com.zhou.haizhi.nexus.web;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by zhoumingbing on 2019-11-03
 */
@RestController
@RequestMapping(value = "/nacos")
public class NacosController {

    @NacosValue(value = "${useLocalCache:false}", autoRefreshed = true)
    private boolean useLocalCache;

    @GetMapping(value = "/findConfig")
    public boolean findConfig() {
        return useLocalCache;
    }

}
