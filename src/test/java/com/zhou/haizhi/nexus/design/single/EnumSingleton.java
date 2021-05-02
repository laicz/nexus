package com.zhou.haizhi.nexus.design.single;

/**
 * 单例模式 - 枚举
 * @author zhoumingbing
 * @data 2021/5/1
 */
public enum EnumSingleton {
    SINGLETON;

    private EnumSingleton(){

    }

    public void doSomething(){
        System.out.println("do some thing ... ");
    }
}
