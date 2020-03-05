package com.zhou.haizhi.nexus.data_structure.stack;

import java.util.Stack;

/**
 * 实现基础计算
 * <p>
 * Example 1:
 * <p>
 * Input: "1 + 1"
 * Output: 2
 * Example 2:
 * <p>
 * Input: " 2-1 + 2 "
 * Output: 3
 * Example 3:
 * <p>
 * Input: "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 * <p>
 * Create by zhoumingbing on 2020-03-03
 */
public class LeetCode224 {

    public static void main(String[] args) {
        String str = "99-(10+20-5)";
        Solution solution = new Solution();
        System.out.println(solution.calculate(str));
    }


    public static class Solution {
        /**
         * 将每个括号内的数据都看做是一个整体
         *
         * @param s
         * @return
         */
        public int calculate(String s) {
            Stack<Integer> stack = new Stack<Integer>();
            int number = 0;
            int sign = 1;
            int result = 0;
            char[] chars = s.toCharArray();
            for (char c : chars) {
                if (Character.isDigit(c)) {
                    number = number * 10 + (c - 48);
                } else if (c == '+') {
                    result += sign * number;
                    sign = 1;
                    number = 0;
                } else if (c == '-') {
                    result += sign * number;
                    sign = -1;
                    number = 0;
                } else if (c == '(') {
                    result += sign * number;
                    stack.push(result);
                    stack.push(sign);
                    result = 0;
                    number = 0;
                    sign = 1;
                } else if (c == ')') {
                    int i = stack.pop() * stack.pop();
                    result = i + result;
                }
            }
            if (!stack.isEmpty()) result += stack.pop() * stack.pop();
            return result;
        }
    }
}
