package com.zhou.haizhi.nexus.jvm.passive_use;

/**
 * 通过子类访问父类的静态变量或者静态方法，这里只是对父类的主动使用，而不是对子类的主动使用
 * Create by zhoumingbing on 2020-03-25
 */
public class MyTest11 {
    public static void main(String[] args) {
        System.out.println(Child3.b);
        Child3.doSomeThing();
    }
}

class Parent3 {
    static int b = 3;

    static {
        System.out.println("Parent3 static block");
    }
    static void doSomeThing(){
        System.out.println("do some thing ");
    }
}

class Child3 extends Parent3 {
    static {
        System.out.println("Child3 static block");
    }
}
