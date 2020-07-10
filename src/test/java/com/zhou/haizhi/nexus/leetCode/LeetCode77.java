package com.zhou.haizhi.nexus.leetCode;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * 组合问题
 * Create by zhoumingbing on 2020-03-19
 */
public class LeetCode77 {
    @Test
    public void test() {
        List<List<Integer>> combine = new Solution().combine(1000, 700);
        combine.forEach(System.out::println);
    }

    class Solution {
        List<List<Integer>> output = new LinkedList();
        int n;
        int k;

        /**
         * 可以使用
         *
         * @param first
         * @param curr
         */
        public void backtrack(int first, LinkedList<Integer> curr) {
            if (curr.size() == k) {
                this.output.add(curr);
                return;
            }

            for (int i = first; i < n - (k - curr.size()) + 1; i++) {
                curr.add(i);
                backtrack(first + 1, new LinkedList<>(curr));
                curr.removeLast();
            }
        }

        public List<List<Integer>> combine(int n, int k) {
            this.n = n;
            this.k = k;
            backtrack(1, new LinkedList<Integer>());
            return output;
        }
    }
}
