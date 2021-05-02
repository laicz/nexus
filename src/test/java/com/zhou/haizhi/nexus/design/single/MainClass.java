package com.zhou.haizhi.nexus.design.single;

/**
 * @author zhoumingbing
 * @data 2021/5/1
 */
public class MainClass {
    public static void main(String[] args) {
        EnumSingleton singleton = EnumSingleton.SINGLETON;
        singleton.doSomething();
        System.out.println(EnumSingleton.SINGLETON == singleton );
    }
}
