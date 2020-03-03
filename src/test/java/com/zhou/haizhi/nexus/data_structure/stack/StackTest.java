package com.zhou.haizhi.nexus.data_structure.stack;

import org.junit.Test;

/**
 * Create by zhoumingbing on 2020-03-03
 */
public class StackTest {

    @Test
    public void arrayLength(){
        String[] strs = new String[10];
        System.out.println(strs.length);
        strs[0] = "a";
        strs[3] = "a";

    }

    @Test
    public void myArrayStackTest(){
        MyArrayStack<Integer> stack = new MyArrayStack<>();
        System.out.println(stack.getSize());
        stack.push(1);
        stack.push(2);
//        stack.push(3);
//        stack.push(4);
//        stack.push(5);
//        stack.push(5);
//        stack.push(5);
//        stack.push(5);
//        stack.push(5);
//        stack.push(5);
//        stack.push(5);
//        stack.push(5);
//        stack.push(5);
//        stack.push(5);
//        stack.push(5);
//        stack.push(5);
//        stack.push(5);
//        stack.push(5);
//        stack.push(5);
//        stack.push(5);
//        stack.push(5);
//        stack.push(6);
        System.out.println(stack.getSize());
        System.out.println(stack.peek());
        System.out.println(stack.getSize());
        System.out.println(stack.pop());
        System.out.println(stack.getSize());
        System.out.println(stack.pop());
        System.out.println(stack.getSize());
    }

    @Test
    public void myLinkStackTest(){
        MyLinkStack<Integer> stack = new MyLinkStack<>();
        System.out.println(stack.getSize());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(5);
        stack.push(5);
        stack.push(5);
        stack.push(5);
        stack.push(5);
        stack.push(5);
        stack.push(5);
        stack.push(5);
        stack.push(5);
        stack.push(5);
        stack.push(5);
        stack.push(5);
        stack.push(5);
        stack.push(5);
        stack.push(5);
        stack.push(5);
        stack.push(6);
        System.out.println(stack.getSize());
        System.out.println(stack.peek());
        System.out.println(stack.getSize());
        System.out.println(stack.pop());
        System.out.println(stack.getSize());
        System.out.println(stack.pop());
        System.out.println(stack.getSize());
    }


}
