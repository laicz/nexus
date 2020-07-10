package com.zhou.haizhi.nexus.jvm.passive_use;

/**
 * Create by zhoumingbing on 2020-03-27
 */
public class StaticTest {
    public static void main(String[] args) {
        staticFunction();
//        2
//        3
//        a=110,b=0
//        1
//        4
    }

    static StaticTest st = new StaticTest();

    static {   //静态代码块
        System.out.println("1");
    }

    {       // 实例代码块
        System.out.println("2");
    }

    StaticTest() {    // 实例构造器
        System.out.println("3");
        System.out.println("a=" + a + ",b=" + b);
    }

    public static void staticFunction() {   // 静态方法
        System.out.println("4");
    }

    int a = 110;    // 实例变量
    static int b = 112;
}
