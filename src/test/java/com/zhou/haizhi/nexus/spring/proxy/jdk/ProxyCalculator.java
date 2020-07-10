package com.zhou.haizhi.nexus.spring.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Create by zhoumingbing on 2020-05-19
 */
public class ProxyCalculator {

    private Calculator calculator;

    public ProxyCalculator(Calculator calculator) {
        this.calculator = calculator;
    }

    public Calculator getProxy() {
        ClassLoader classLoader = this.calculator.getClass().getClassLoader();
        Class<?>[] interfaces = this.calculator.getClass().getInterfaces();
        InvocationHandler invocationHandler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                //具体的代理执行过程
                System.out.println("before execute ... ");
                Object object = method.invoke(calculator, args);
                System.out.println("after execute ... ");
                return object;
            }
        };
        Object value = Proxy.newProxyInstance(classLoader, interfaces, invocationHandler);
        return (Calculator) value;
    }
}
