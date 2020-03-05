package com.zhou.haizhi.nexus.data_structure.array;

import org.junit.Test;

/**
 * container-with-most-water
 * 盛最多水容量
 * Create by zhoumingbing on 2020-03-05
 */
public class LeetCode11 {

    @Test
    public void loop() {
        int[] height = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(loop(height));
    }

    /**
     * 循环获取最高的面积
     *
     * @param height
     * @return
     */
    private int loop(int[] height) {
        int max = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int area = Math.min(height[i], height[j]) * (j - i);
                max = Math.max(area, max);
            }
        }
        return max;
    }

    @Test
    public void doubleIndex() {
        int[] height = new int[]{1, 80, 10, 30, 5, 1000, 80, 3, 7};
        System.out.println(doubleIndex(height));
    }

    /**
     * 采用双指针的方式，谁小谁动，往中间移动
     *
     * @param height
     * @return
     */
    private int doubleIndex(int[] height) {
        int max = 0;
        int head = 0;
        int tail = height.length - 1;
        for (int i = 0; i < height.length; i++) {
            if (head == tail) break;
            max = Math.max((tail - head) * (Math.min(height[head], height[tail])), max);
            if (height[head] > height[tail]) {
                tail--;
            }/* else if (height[head] == height[tail]) {
                if (height[head + 1] > height[tail - 1]) {
                    head++;
                } else {
                    tail--;
                }
            }*/ else {
                head++;
            }
        }
        return max;
    }

}
