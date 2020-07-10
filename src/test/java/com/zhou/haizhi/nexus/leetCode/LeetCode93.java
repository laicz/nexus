package com.zhou.haizhi.nexus.leetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 给出一个数字字符串，为这个数字字符串加上三个点（.），使其变成合法的ip地址
 * Create by zhoumingbing on 2020-03-19
 */
public class LeetCode93 {

    @Test
    public void test() {
        List<String> ips = restoreIpAddresses("010010");
        ips.forEach(System.out::println);
    }

    public List<String> restoreIpAddresses(String s) {
        List<String> ips = new ArrayList<>();
        ip(ips, "", s, 0);
        return ips;
    }

    void ip(List<String> ips, String result, String str, int index) {
        if (result.length() == 0 && (str.length() < 4 || str.length() > 12) || str.length() == 0) {
            return;
        }
        if (index == 3) {
            if (str.length() > 1 && str.startsWith("0")) {
                return;
            }
            int value = Integer.valueOf(str);
            if ((value <= 255 && value >= 0)) {
                String s = result + "." + str;
                ips.add(s.substring(1));
            }
            return;
        }
        for (int i = 1; i <= Math.min(3, str.length()); i++) {
            String s = str.substring(0, i);
            int value = Integer.valueOf(s);
            if (value < 0 || value > 255) {
                continue;
            }
            String substring = str.substring(i);
            if (s.length() > 1 && s.startsWith("0")) {
                continue;
            }
//            System.out.println(result + " : " + str + " : " + index);
            ip(ips, result + "." + s, substring, index + 1);
        }
    }
}
