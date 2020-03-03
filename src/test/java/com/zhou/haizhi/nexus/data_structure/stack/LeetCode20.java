package com.zhou.haizhi.nexus.data_structure.stack;

import org.apache.commons.lang3.StringUtils;

/**
 * LeetCode上20题
 * 验证符号是否匹配
 * Create by zhoumingbing on 2020-03-03
 */
public class LeetCode20 {

    public static void main(String[] args) {
        LeetCode20 leetCode = new LeetCode20();
        String str = "{}";
        System.out.println(leetCode.isValid(str));
    }

    public boolean isValid(String s) {
        char[] stack = new char[s.length()];
        int head = 0;
        for(char c : s.toCharArray()) {
            switch(c) {
                case '{':
                case '[':
                case '(':
                    stack[head++] = c;
                    break;
                case '}':
                    if(head == 0 || stack[--head] != '{') return false;
                    break;
                case ')':
                    if(head == 0 || stack[--head] != '(') return false;
                    break;
                case ']':
                    if(head == 0 || stack[--head] != '[') return false;
                    break;
            }
        }
        return head == 0;
    }
}
