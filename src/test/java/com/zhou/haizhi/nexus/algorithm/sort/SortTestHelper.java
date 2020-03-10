package com.zhou.haizhi.nexus.algorithm.sort;

import java.util.Arrays;
import java.util.Random;

/**
 * Create by zhoumingbing on 2020-03-09
 */
public class SortTestHelper {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(generateRandomArray(20, 0, 5)));
    }

    public static int[] generateRandomArray(int n, int rangL, int rangR) {
        int[] array = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(rangR) % (rangR - rangL + 1) + rangL;
        }
        return array;
    }

}
