package com.zhou.haizhi.nexus.data_structure.maopao;

import org.junit.Test;

import java.util.Arrays;

/**
 * 排序算法
 * Create by zhoumingbing on 2020-03-04
 */
public class SortTest {

    @Test
    public void maoPaoTest() {
        int[] ints = {1, 2, 36, 5, 4, 8};
        maoPao(ints);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 冒泡排序
     * 时间复杂度：O(n^2)
     * 空间复杂度：n  原地排序算法
     * 稳定排序算法，值相等时，无需进行交换
     *
     * @param ints
     */
    private void maoPao(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            for (int j = ints.length - 1; j > 0; j--) {
                if (ints[j] > ints[j - 1]) {
                    int temp = ints[j];
                    ints[j] = ints[j - 1];
                    ints[j - 1] = temp;
                }
            }
        }
    }

    @Test
    public void insertionSort() {
        int[] ints = {1, 2, 36, 5, 4, 8};
        insertionSort(ints);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 插入排序算法
     *
     * @param ints
     */
    private void insertionSort(int[] ints) {
        for (int i = 1; i < ints.length; i++) {
            int value = ints[i];
            int j = i - 1;
            for (; j > 0; j--) {
                if (ints[j] > value) {
                    ints[j + 1] = ints[j];
                } else {
                    break;
                }
            }
            ints[j + 1] = value;
        }
    }

    @Test
    public void selectionSort() {

    }

    /**
     * 选择排序
     *
     * @param ints
     */
    private void selectionSort(int[] ints) {

    }
}
