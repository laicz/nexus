package com.zhou.haizhi.nexus.algorithm.sort;

import java.util.Arrays;

/**
 * 选择排序，和数组中最小的值进行排序
 * 从没有排序的数组中找到最大或者最小的值
 * Create by zhoumingbing on 2020-03-09
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] values = SortTestHelper.generateRandomArray(200, 1, 200000);
        long st = System.currentTimeMillis();
        sort(values);
        System.out.println("cost time " + (System.currentTimeMillis() - st));
        System.out.println(Arrays.toString(values));
    }

    public static void sort(int[] values) {
        int index = 0;
        for (int i = 0; i < values.length; i++) {
            int min = values[i];
            for (int j = i + 1; j < values.length; j++) {
                if (values[j] < min) {
                    index = j;
                    min = values[j];
                }
            }
            //将最小值和当前遍历的index起点进行交换
            values[index] = values[i];
            values[i] = min;
        }
    }


    /**
     * 注意，每次遍历的时候，外层遍历的数组开始是作为最小值的
     *
     * @param values
     */
    public void sort1(int[] values) {
        int index = 0;
        for (int i = 0; i < values.length; i++) {
            int min = values[0];
            for (int j = i + 1; j < values.length; j++) {
                if (min > values[j]) {
                    index = j;
                    min = values[j];
                }
            }
            values[index] = values[i];
            values[i] = min;
        }
    }


}
