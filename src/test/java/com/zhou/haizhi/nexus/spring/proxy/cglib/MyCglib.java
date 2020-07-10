package com.zhou.haizhi.nexus.spring.proxy.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Create by zhoumingbing on 2020-05-19
 */
public class MyCglib implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before ...");
        Object o1 = methodProxy.invokeSuper(o, objects);
        System.out.println("after ...");

        return o1;
    }
}
