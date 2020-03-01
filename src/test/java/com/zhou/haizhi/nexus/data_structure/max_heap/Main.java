package com.zhou.haizhi.nexus.data_structure.max_heap;

import java.util.Random;

/**
 * Create by zhoumingbing on 2020-02-29
 */
public class Main {
    public static void main(String[] args) {
        int n = 1000000;
        MaxHeap<Integer> maxHeap = new MaxHeap<>(n);
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = maxHeap.extractMax();
        }
        for (int i = 1; i < n; i++) {
            if (arr[i -1] < arr[i]){
                throw  new IllegalArgumentException("error");
            }
        }

        System.out.println("test complete !!!");
    }
}
