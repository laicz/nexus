package com.zhou.haizhi.nexus.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Create by zhoumingbing on 2019-12-27
 */
@RestController
public class MockController {

    @PostMapping(value = "/atlas/gap/api/search/graph/service/kExpand")
    public String mock() {
        System.out.println("accept .... ");
        return "success";
    }

    @GetMapping(value = "/atlas/atlasGap/graph/service")
    public String mock1(){
        return "success1";
    }
}
