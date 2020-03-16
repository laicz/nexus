package com.zhou.haizhi.nexus.base;

/**
 * 枚举新用法，可以通过在枚举中定义函数
 * Create by zhoumingbing on 2020-03-16
 */
public enum EnumTest {

    P() {
        @Override
        public void doSome() {
            System.out.println("my name is p...");
        }
    },
    O() {
        @Override
        public void doSome() {
            System.out.println("my name is o...");
        }
    };

    public abstract void doSome();

    public static void main(String[] args) {
        O.doSome();
        P.doSome();
    }
}
