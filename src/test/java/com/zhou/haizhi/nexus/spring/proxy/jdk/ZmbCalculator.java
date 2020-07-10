package com.zhou.haizhi.nexus.spring.proxy.jdk;

/**
 * Create by zhoumingbing on 2020-05-19
 */
public class ZmbCalculator implements Calculator {
    @Override
    public int add(int i, int j) {
        System.out.println("zmb add ... ");
        return i + j;
    }

    @Override
    public int div(int i, int j) {
        System.out.println("zmb div ... ");
        return i / j;
    }
}
