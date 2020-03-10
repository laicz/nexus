package com.zhou.haizhi.nexus.algorithm.sort;

import java.util.Arrays;

/**
 * 希尔排序就相当于插入排序的升级版本
 * 将数据分为两组，在两组中进行排序
 * 将数据分为四组，在四组中进行排序
 * Create by zhoumingbing on 2020-03-09
 */
public class ShellSort<E extends Comparable> {

    public static void main(String[] args) {
        int[] values = new int[]{22, 3534, 2, 4324, 53, 2};
//        sort(values);
        System.out.println(Arrays.toString(values));
        sort2(values);
        System.out.println(Arrays.toString(values));
    }


    private static <E extends Comparable> void sort(int[] values) {
        int j;
        for (int gap = values.length / 2; gap > 0; gap /= 2) {
            for (int i = 0; i < values.length; i++) {
                int value = values[i];
                for (j = i; j >= gap && value < values[j - gap]; j -= gap) {
                    values[j] = values[j - gap];
                }
                values[j] = value;
            }
        }
    }

    private static void sort2(int[] values) {
        int gap = values.length;
        while ((gap = gap / 2) > 0) {
            for (int i = 0; i < values.length; i++) {
                int value = values[i];
                int j = 0;
                //从当前j=i开始遍历，得到值
                for (j = i; j >= gap && value < values[j - gap]; j -= gap) {
                    values[j] = values[j - gap];
                }
                values[j] = value;
            }
        }
    }


}
