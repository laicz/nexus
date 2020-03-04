package com.zhou.haizhi.nexus.data_structure.recursion;

import org.junit.Test;

/**
 * 台阶问题，一个台阶能同时走一步，也能走两步，问有多少种走法
 * Create by zhoumingbing on 2020-03-04
 */
public class StepQuestion {

    @Test
    public void stepTest() {
        System.out.println(step(4));
    }

    /**
     * 终止条件为每步能走的数量
     * e.g：如果能走三步，则存在以下几种方式：
     * 1 1 1
     * 2 1
     * 1 2
     * 3
     * 则需要添加终止条件 if(n == 3) return 4
     * 递归中也增加:return step(n -1) + step(n-2) + step(n-3)
     *
     * @param n
     * @return
     */
    private int step(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
//        if (n == 3) return 4;
        return step(n - 1) + step(n - 2) /*+ step(n - 3)*/;
    }
}
