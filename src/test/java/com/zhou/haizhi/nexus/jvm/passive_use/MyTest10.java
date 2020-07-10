package com.zhou.haizhi.nexus.jvm.passive_use;

/**
 * Create by zhoumingbing on 2020-03-25
 */
public class MyTest10 {
    static {
        System.out.println("MyTest10 static block");
    }

    public static void main(String[] args) {
        Parent2 parent2;
        System.out.println("-------------------");
        parent2 = new Parent2();
    }
}

class Parent2 {
    int a = 2;
    static {
        System.out.println("parent2 static block");
    }
}

class Child2 extends Parent2 {
    int b = 2;
    static {
        System.out.println("child2 static block");
    }
}
