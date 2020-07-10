package com.zhou.haizhi.nexus.spring.proxy.jdk;

/**
 * Create by zhoumingbing on 2020-05-19
 */
public class JdkProxyTest {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        ProxyCalculator proxyCalculator = new ProxyCalculator(new ZmbCalculator());
        Calculator calculator = proxyCalculator.getProxy();
        calculator.add(1,2);
        calculator.div(2,1);
        System.out.println(calculator.getClass());
    }
}
