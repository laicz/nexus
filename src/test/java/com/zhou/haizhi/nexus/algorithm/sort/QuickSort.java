package com.zhou.haizhi.nexus.algorithm.sort;

import org.junit.Test;

/**
 * 排序算法 - 快排
 * Create by zhoumingbing on 2020-03-07
 */
public class QuickSort {

    @Test
    public void sort() {
        int[] values = SortTestHelper.generateRandomArray(5000000, 1, 500);
        quickSort(values, 0, values.length - 1);
//        System.out.println(Arrays.toString(values));
    }

    private void quickSort(int[] values, int left, int right) {
        if (left >= right) return;

        int partition = partition1(values, left, right);
        //这里需要注意的是由于当前数据已经是在自己所处的位置上，则无需再进行排序，否则永远排不完，则会出现栈溢出
        quickSort(values, left, partition - 1);
        quickSort(values, partition + 1, right);
    }

    /**
     * 对数组按照第一个元素进行区分，左边的小于第一个元素，右边的大于第一个元素，并返回最后第一个元素存放的位置信息
     *
     * @param values
     * @param left
     * @param right
     * @return
     */
    private int partition(int[] values, int left, int right) {
        int value = values[left];
        int index = left;
        int boundary = left;
        while (index++ < right) {
            if (values[index] < value) {
                swap(values, index, boundary + 1);
                boundary++;
            }
        }
        //此时，存放在boundary下标的元素则小于第一个元素
        swap(values, left, boundary);
        return boundary;
    }

    private int partition1(int[] values, int left, int right) {
        swap(values, left, left + (right - left) / 2);
        int tmp = values[left];
        int leftIndex = left + 1;
        int rightIndex = right;
        while (true) {
            while (leftIndex <= rightIndex && values[leftIndex] < tmp) {
                leftIndex++;
            }
            while (rightIndex >= leftIndex && values[rightIndex] > tmp) {
                rightIndex--;
            }
            if (leftIndex > rightIndex) {
                break;
            }
            swap(values, leftIndex, rightIndex);
            leftIndex++;
            rightIndex--;
        }
        swap(values, left, rightIndex);
        return rightIndex;
    }

    private void swap(int[] values, int left, int right) {
        int tmp = values[left];
        values[left] = values[right];
        values[right] = tmp;
    }

}
