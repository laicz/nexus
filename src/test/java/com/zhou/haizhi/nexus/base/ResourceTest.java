package com.zhou.haizhi.nexus.base;

import org.junit.Test;

/**
 * Create by zhoumingbing on 2020-02-12
 */
public class ResourceTest {

    @Test
    public void classLoaderGetResource(){
        System.out.println(ResourceTest.class.getResource("test.properties"));
        System.out.println(ResourceTest.class.getResource("/test.properties"));
        System.out.println(ResourceTest.class.getClassLoader().getResource("test.properties"));
        System.out.println(ResourceTest.class.getClassLoader().getResource("/test.properties"));
    }
}
