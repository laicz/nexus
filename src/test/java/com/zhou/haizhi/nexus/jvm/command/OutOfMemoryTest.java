package com.zhou.haizhi.nexus.jvm.command;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by zhoumingbing on 2020-05-01
 */
public class OutOfMemoryTest {

    public static void main(String[] args) {
        List<Integer[]> list = new ArrayList<>();
        Integer[] ints = null;
        for (; ; ) {
//            list.add(new Integer[1024 * 1024]);
            ints = new Integer[1024 * 1024];
            System.gc();
        }
    }
}
