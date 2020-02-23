package com.zhou.haizhi.nexus;

import org.junit.Test;

import java.net.URL;

/**
 * Create by zhoumingbing on 2020-01-07
 */
public class PropertiesTest {

    @Test
    public void load() {
        String name = "/test.properties";
        URL resource = NexusApplication.class.getResource(name);
        System.out.println(resource.getFile());
    }

    @Test
    public void differentUrl() {
        System.out.println(PropertiesTest.class.getResource("test.properties"));
        System.out.println(PropertiesTest.class.getResource("/test.properties"));
        System.out.println(PropertiesTest.class.getClassLoader().getResource("test.properties"));
        System.out.println(PropertiesTest.class.getClassLoader().getResource("/test.properties"));
    }
}
