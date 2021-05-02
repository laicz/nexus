package com.zhou.haizhi.nexus.design.single;

/**
 * 单例模式 - 懒汉式
 * @author zhoumingbing
 * @data 2021/5/1
 */
public class LazyManSingleton {
    private static LazyManSingleton singleton ;
    private LazyManSingleton(){}

    /**
     * 获取单例实例的时候，需要判断一下实例是否存在，不在的时候先初始化
     * @return
     */
    public static LazyManSingleton getSingleton(){
        if (singleton == null){
            singleton = new LazyManSingleton();
        }
        return singleton;
    }
}
