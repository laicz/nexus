package com.zhou.haizhi.nexus.spring.aop;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Set;

/**
 * Create by zhoumingbing on 2020-01-01
 */
public class SetProxyFactory {
    public static Set getSetProxy(final Set set) {
        return (Set) Proxy.newProxyInstance(set.getClass().getClassLoader(), set.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return method.invoke(set, args);
            }
        });
    }
}
