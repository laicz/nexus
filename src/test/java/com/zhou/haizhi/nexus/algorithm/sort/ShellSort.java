package com.zhou.haizhi.nexus.algorithm.sort;

import java.util.Arrays;

/**
 * 是插入排序的升级
 * Create by zhoumingbing on 2020-03-09
 */
public class ShellSort<E extends Comparable> {

    public static void main(String[] args) {
        int[] values = new int[]{22, 3534, 2, 4324, 53, 2};
        sort(values);
        System.out.println(Arrays.toString(values));
        sort1(values);
        System.out.println(Arrays.toString(values));
    }


    public static <E extends Comparable> void sort(int[] values) {
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

    /**
     *
     * @param values
     */
    public static void sort1(int[] values) {
        int gap = values.length;
        while ((gap = gap / 2) > 0) {
            for (int i = 0; i < values.length; i++) {
                int tmp = values[i];
                int j = i;
                for (j = i; j >= gap && tmp > values[j - gap]; j += gap) {
                    values[j] = values[j - gap];
                }
                values[j] = tmp;
            }
        }
    }

}
