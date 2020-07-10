package com.zhou.haizhi.nexus.spring.proxy.cglib;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;

/**
 * Create by zhoumingbing on 2020-05-19
 */
public class MyCglibTest {
    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY,"/Users/haizhi/Desktop/cglib");
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(Car.class);
        enhancer.setCallback(new MyCglib());
        Car car = (Car) enhancer.create();
        car.run();
        System.out.println("-------------");
        car.didi();
    }
}
