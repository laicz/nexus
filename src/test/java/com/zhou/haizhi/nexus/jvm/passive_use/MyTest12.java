package com.zhou.haizhi.nexus.jvm.passive_use;

/**
 * ClassLoader.loadClass()并不会导致类的初始化，也就是说并不是对这个类的主动使用，Class.forName()会导致类的初始化
 * <p>
 * class com.zhou.haizhi.nexus.jvm.passive_use.CL
 * --------------
 * CL static block
 * class com.zhou.haizhi.nexus.jvm.passive_use.CL
 * Create by zhoumingbing on 2020-03-25
 */
public class MyTest12 {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        Class<?> clazz = loader.loadClass("com.zhou.haizhi.nexus.jvm.passive_use.CL");
        System.out.println(clazz);
        System.out.println("--------------");
        clazz = Class.forName("com.zhou.haizhi.nexus.jvm.passive_use.CL");
        System.out.println(clazz);
    }
}

class CL {
    static {
        System.out.println("CL static block");
    }
}
