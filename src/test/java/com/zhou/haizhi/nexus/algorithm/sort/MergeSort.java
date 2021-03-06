package com.zhou.haizhi.nexus.algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序
 * 将数组一直对半切分，直到数据长度为1
 * <p>
 * 8 4 2 7 5 1 9 0
 * 8 4 2 7|5 1 9 0
 * 8 4|2 7|5 1|9 0
 * 8|4|2|7|5|1|9|0
 * </p>
 * Create by zhoumingbing on 2020-03-10
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] values = SortTestHelper.generateRandomArray(2000, 2, 1000);
//        System.out.println(Arrays.toString(values));
        MergeSort mergeSort = new MergeSort();
        long st = System.currentTimeMillis();
        mergeSort.sort(values);
        System.out.println(System.currentTimeMillis() - st);
        System.out.println(Arrays.toString(values));
    }

    private void sort(int[] values) {
        sort(values, 0, values.length - 1);
    }

    private void sort(int[] values, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
        sort(values, l, mid);
        sort(values, mid + 1, r);
        if (values[mid] < values[mid + 1]) {
            return;
        }
        merge(values, l, mid, r);
    }

    private void sort1(int[] values) {
        sort1(values, 0, values.length - 1);
    }

    private void sort1(int[] values, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        sort(values, left, mid);
        sort(values, mid + 1, right);
        merge1(values, left, mid, right);
    }

    private void merge1(int[] values, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];

        int index = 0;
        //左半部分是从左区间开始
        int leftIndex = left;
        //右半部分是从右区间开始
        int rightIndex = mid + 1;
        while (leftIndex <= mid && rightIndex >= mid + 1) {
            if (values[leftIndex] < values[rightIndex]) {
                tmp[index++] = values[leftIndex++];
            } else {
                tmp[index++] = values[rightIndex++];
            }
        }
        while (leftIndex <= mid) {
            tmp[index++] = values[leftIndex++];
        }
        while (rightIndex >= mid + 1) {
            tmp[index++] = values[rightIndex++];
        }
        for (int i = 0; i < tmp.length; i++) {
            values[left + i] = tmp[i];
        }
    }

    /**
     * 对已经排序好的两个数组进行排序
     * values[l,mid]
     * values[mid+1,r]
     *
     * @param values
     * @param l
     * @param r
     */
    private void merge(int[] values, int l, int mid, int r) {
        int[] tmp = new int[r - l + 1];

        //先要定义好开始和结束的位置
        int leftPos = l;
        int rightPos = mid + 1;
        int tmpPos = 0;
        //当左半部分和右半部分都没有执行完毕
        while (leftPos <= mid && rightPos <= r) {
            if (values[leftPos] < values[rightPos]) {
                tmp[tmpPos++] = values[leftPos++];
            } else {
                tmp[tmpPos++] = values[rightPos++];
            }
        }
        //当只剩半边
        while (leftPos <= mid) {
            tmp[tmpPos++] = values[leftPos++];
        }
        //当只剩右半边
        while (rightPos <= r) {
            tmp[tmpPos++] = values[rightPos++];
        }

        //从临时空间合并到数组中
        for (int i = 0; i < tmp.length; i++) {
            values[l + i] = tmp[i];
        }
    }

    /**
     * 使用for循环来实现归并排序
     */
    private void forLoop(int[] values) {
        for (int i = 0; i < values.length - 1; i += i) {
            for (int j = 0; j + i < values.length - 1; j += i + i) {
                merge(values, j, j + i - 1, Math.min(j + i + i - 1, values.length - 1));
            }
        }
    }
}
