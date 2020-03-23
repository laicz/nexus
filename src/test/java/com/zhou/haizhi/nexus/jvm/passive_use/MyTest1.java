package com.zhou.haizhi.nexus.jvm.passive_use;

import org.junit.Test;

/**
 * 对于静态变量来说，只有直接定义了字段的类才会被初始化
 * Create by zhoumingbing on 2020-03-23
 */
public class MyTest1 {

    /**
     * -XX:+TraceClassLoading
     * 可以用来打印类的加载信息
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(MyChild1.str);
    }

    /**
     * MyParent static block
     * Hello World!
     */
    @Test
    public void test1() {
        System.out.println(MyChild1.str);
    }

    /**
     * MyParent static block
     * MyChild1 static block
     * Hello World! child
     * 当一个类在初始化的时候，要求其父类都已经初始化完成
     */
    @Test
    public void test2() {
        System.out.println(MyChild1.str1);
    }


    /**
     * MyParent static block
     * Hello World!
     */
    @Test
    public void test3() {
        System.out.println(MyParent1.str);
    }

    /**
     * final:在编译阶段，在编译节点，常量就会放到调用这个常量的方法所在的类的常量池中，
     * 本质上，调动类并没有直接饮用到定义常量的类，因此并不会触发定义常量的类的初始化
     * Hello World
     */
    @Test
    public void test4() {
        System.out.println(MyParent2.str);
    }

    /**
     * 在一个常量的值，并非编译期间可以确定，那么其值则不会被放置到调用类的常量池中，这时程序运行时，则会调用类的定义类并初始化
     */
    @Test
    public void test5() {
        System.out.println(MyParent2.str1);
    }

    /**
     * MyParent1 static block
     * class [Lcom.zhou.haizhi.nexus.jvm.passive_use.MyParent2;
     * class [[Lcom.zhou.haizhi.nexus.jvm.passive_use.MyParent2;
     * class java.lang.Object
     * class java.lang.Object
     * ------------------------
     * myParent2并没有执行static 代码块
     */
    @Test
    public void test6() {
        MyParent1 myParent1 = new MyParent1();
        //一维数组
        MyParent2[] myParent2s = new MyParent2[1];
        System.out.println(myParent2s.getClass());
        //二维数组
        MyParent2[][] myParent2s1 = new MyParent2[1][1];
        System.out.println(myParent2s1.getClass());

        //打印父类
        System.out.println(myParent2s.getClass().getSuperclass());
        System.out.println(myParent2s1.getClass().getSuperclass());
    }

}
