package com.zhou.haizhi.nexus.algorithm.sort;

import java.util.Arrays;

/**
 * 插入排序，设置第一个数据为已经为排好的数据
 * 将第一个没有排序的数组按照顺序插入到已经排序好的对应位置
 *
 * 当数组的接近于顺序排序，则插入排序优于选择排序
 * 当数组是顺序排序时，插入排序则变成O(n)复杂度
 *
 * 插入排序是从后往前比较
 * Create by zhoumingbing on 2020-03-09
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] values = SortTestHelper.generateRandomArray(20, 1, 40);
        long st = System.currentTimeMillis();
        System.out.println(Arrays.toString(values));
        sort(values);
        System.out.println("cost time " + (System.currentTimeMillis() - st));
        System.out.println(Arrays.toString(values));
    }

    /**
     * 插入排序需要从第二个下标开始遍历，通过while来进行将比较大的值移动到后面
     *
     * @param values
     */
    public static void sort(int[] values) {
        for (int i = 1; i < values.length; i++) {
            int prev = i - 1;
            int tmp = values[i];
            while (prev >= 0 && values[prev] > tmp) {
                values[prev + 1] = values[prev];
                prev--;
            }
            values[prev + 1] = tmp;
        }
    }

}
