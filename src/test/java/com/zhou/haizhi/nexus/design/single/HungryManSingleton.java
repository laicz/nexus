package com.zhou.haizhi.nexus.design.single;

/**
 * 单例模式 - 饿汉式
 *
 * @author zhoumingbing
 * @data 2021/5/1
 */
public class HungryManSingleton {
    private static HungryManSingleton singleton = new HungryManSingleton();

    private HungryManSingleton() {
    }

    public static HungryManSingleton getSingleton() {
        return singleton;
    }
}
