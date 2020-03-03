package com.zhou.haizhi.nexus.data_structure.stack;

import java.util.Stack;

/**
 * 使用stack实现一个queue
 * <p>
 * stack当为empty时调用pop方法会出现异常
 * Exception in thread "main" java.util.EmptyStackException
 * Create by zhoumingbing on 2020-03-03
 */
public class LeetCode232 {

    public static void main(String[] args) {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        queue.push(5);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }


    public static class MyQueue {

        private Stack<Integer> stack;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            stack = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            Stack<Integer> temp = new Stack<>();
            Integer val = null;
            while ((!stack.isEmpty()) && (val = stack.pop()) != null) {
                temp.push(val);
            }
            temp.push(x);
            while ((!temp.isEmpty()) && (val = temp.pop()) != null) {
                stack.push(val);
            }
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            return stack.pop();
        }

        /**
         * Get the front element.
         */
        public int peek() {
            return stack.peek();
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return stack.isEmpty();
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */

}
