package com.zhou.haizhi.nexus.spring.proxy.jdk;

import java.lang.reflect.Method;

/**
 * Create by zhoumingbing on 2020-05-31
 */

interface Test {
    void say();
}

interface InvokeHandle {
    Object invoke(Object obj, Method method, Object... args);
}

public class ProxyDemo {

    public static void main(String[] args) {
        Test test = new Test() {
            @Override
            public void say() {

            }
        };
    }

    public static Test createNewProxyInstance(InvokeHandle invoke, Class<?> clazz) {
        return new Test() {
            @Override
            public void say() {
                try {
                    Method method = clazz.getMethod("say");
                    Object result = invoke.invoke(this, method);
                    System.out.println(result);
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        };
    }
}
