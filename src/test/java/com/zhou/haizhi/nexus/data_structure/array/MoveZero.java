package com.zhou.haizhi.nexus.data_structure.array;

import org.junit.Test;

import java.util.Arrays;

/**
 * Create by zhoumingbing on 2020-03-04
 */
public class MoveZero {

    @Test
    public void move() {
        int[] ints = new int[]{0, 1, 2, 3, 4, 5, 0, 2, 50};
        moveZero(ints);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 增加指针记录非0的下标
     * @param ints
     */
    private void moveZero(int[] ints) {
        int index = 0;
        for (int i = 0; i < ints.length; i++) {
            if (ints[i] != 0) {
                ints[index] = ints[i];
                if (i != index) ints[i] = 0;
                index++;
            }
        }
        System.out.println(Arrays.toString(ints));
    }
}
