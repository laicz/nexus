package com.zhou.haizhi.nexus.jvm.passive_use;

/**
 * 根类加载器有可能是null
 * <p>
 * <疑问>多次执行的类加载器地址都是相同的？</疑问>
 * sun.misc.Launcher$AppClassLoader@135fbaa4
 * sun.misc.Launcher$ExtClassLoader@2503dbd3
 * null
 * Create by zhoumingbing on 2020-03-25
 */
public class MyTest13 {
    public static void main(String[] args) {
        //获取到系统加载器（应用加载器），系统加载器作为用户定义的委托父类加载器
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        System.out.println(classLoader);
        while (classLoader != null) {
            classLoader = classLoader.getParent();
            System.out.println(classLoader);
        }
    }
}


