package com.zhou.haizhi.nexus.jvm.passive_use;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;

/**
 * sun.misc.Launcher$AppClassLoader@135fbaa4
 * file:/Users/haizhi/Idea/own/nexus/target/test-classes/com/zhou/haizhi/nexus/jvm/passive_use/MyTest13.class
 *
 * Create by zhoumingbing on 2020-03-25
 */
public class MyTest14 {
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(classLoader);
        String resourceName = "com/zhou/haizhi/nexus/jvm/passive_use/MyTest13.class";
        Enumeration<URL> resources = classLoader.getResources(resourceName);
        while (resources.hasMoreElements()){
            System.out.println(resources.nextElement());
        }
    }
}
