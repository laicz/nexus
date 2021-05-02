package com.zhou.haizhi.nexus.design.single;

/**
 * 单例模式 - 静态内部类
 * 相对于其它的优势 - 即保证了单例的线程安全，也具有延迟加载的优势
 * @author zhoumingbing
 * @data 2021/5/1
 */
public class StaticInnerClassSingleton {

    private StaticInnerClassSingleton(){}

    private static class InnerClass{
        private static StaticInnerClassSingleton singleton = new StaticInnerClassSingleton();
    }

    public StaticInnerClassSingleton getSingleton(){
        return InnerClass.singleton;
    }

}
