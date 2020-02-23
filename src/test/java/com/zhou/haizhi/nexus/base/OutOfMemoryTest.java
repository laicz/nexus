package com.zhou.haizhi.nexus.base;

import java.util.ArrayList;
import java.util.List;

/**
 * Create by zhoumingbing on 2019-11-13
 */
public class OutOfMemoryTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        long i = 0;
        while (true){
            list.add("fsadfsdafafssafsdfsfsfsgdgyiosfhlshfhdsahdkahflkadsfijadslfjd" + i++);
        }
    }
}
