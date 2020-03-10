package com.zhou.haizhi.nexus.data_structure.array;

import org.junit.Test;

/**
 * 接雨水
 * Create by zhoumingbing on 2020-03-05
 */
public class LeetCode42 {


    @Test
    public void doubleIndex() {
        int[] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(doubleIndex(height));
    }

    /**
     * 双指针解法
     * 谁小谁移动
     *
     * @param height
     * @return
     */
    private int doubleIndex(int[] height) {
        int left = 0, right = height.length - 1;
        int ans = 0;
        int left_max = 0, right_max = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= left_max) {
                    left_max = height[left];
                } else {
                    ans += (left_max - height[left]);
                }
                ++left;
            } else {
                if (height[right] >= right_max) {
                    right_max = height[right];
                } else {
                    ans += (right_max - height[right]);
                }
                --right;
            }
        }
        return ans;
    }
}
