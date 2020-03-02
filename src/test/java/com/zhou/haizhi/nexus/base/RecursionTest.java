package com.zhou.haizhi.nexus.base;

import org.junit.Test;

/**
 * 测试递归
 * Create by zhoumingbing on 2020-03-01
 */
public class RecursionTest {


    @Test
    public void recursion() {
        System.out.println(f(10));
    }

    /**
     * 实现递归函数 f(x) = 2f(x-1) + x * x;
     *
     * @param x
     * @return
     */
    private int f(int x) {
        if (x == 0) {
            return 0;
        }
        return 2 * f(x - 1) + x * x;
    }

}
