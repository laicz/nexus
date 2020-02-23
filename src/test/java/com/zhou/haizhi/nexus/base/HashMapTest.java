package com.zhou.haizhi.nexus.base;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.sun.xml.internal.fastinfoset.util.ValueArray.MAXIMUM_CAPACITY;

/**
 * Create by zhoumingbing on 2019-10-30
 */
public class HashMapTest {

    @Test
    public void tableSizeForTest() {
        HashMap<String, String> map = new HashMap<>(10000);
    }

    @Test
    public void left() {
        int value = 1;
        System.out.println(Integer.toBinaryString(value));
        System.out.println(value << 31);
        System.out.println(value >> 1);
        value = -733183670;
        System.out.println(Integer.toBinaryString(value));
        System.out.println(Integer.toBinaryString(value >> 8));
        System.out.println(Integer.toBinaryString(value >>> 8));

        System.out.println("------------------------------------");

        value = Math.abs(value);
        System.out.println(Integer.toBinaryString(value));
        System.out.println(Integer.toBinaryString(value >> 8));
        System.out.println(Integer.toBinaryString(value >>> 8));

        System.out.println("------------------------------------");
        System.out.println(Integer.toBinaryString(0x0f));

    }

    @Test
    public void mapHash() {
        Object key = "fasfjososdahfwueohfegewrqqegerffva";
        System.out.println(key.hashCode());
        System.out.println(Integer.toBinaryString(key.hashCode()));
        System.out.println(Integer.toBinaryString(key.hashCode() >>> 16));
        int h = (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
        System.out.println(h);
        System.out.println(Integer.toBinaryString(h));
        System.out.println(Integer.toBinaryString(h).length());
    }

    @Test
    public void tableSize() {
        int cap = 10;
        int n = cap - 1;
        System.out.println(Integer.toBinaryString(n));
        System.out.println("1:" + Integer.toBinaryString(n >> 1));
        n |= n >>> 1;
        System.out.println(Integer.toBinaryString(n));
        System.out.println("2:" + Integer.toBinaryString(n >> 2));
        n |= n >>> 2;
        System.out.println(Integer.toBinaryString(n));
        System.out.println("4:" + Integer.toBinaryString(n >> 4));
        n |= n >>> 4;
        System.out.println(Integer.toBinaryString(n));
        System.out.println("8:" + Integer.toBinaryString(n >> 8));
        n |= n >>> 8;
        System.out.println(Integer.toBinaryString(n));
        System.out.println("16:" + Integer.toBinaryString(n >> 16));
        n |= n >>> 16;
        System.out.println(Integer.toBinaryString(n));
        System.out.println((n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1);
    }

    @Test
    public void nullTest() {
        HashMap<String, String> map = new HashMap<>();
        System.out.println(map.get(null));
        System.out.println(map.containsKey(null));
        map.put(null, "1");
        System.out.println(map.get(null));
        System.out.println(map.containsKey(null));
        System.out.println("----------------------");
        Map<String, String> concurrentHashMap = new ConcurrentHashMap<>();
//        System.out.println(concurrentHashMap.get(null));
//        concurrentHashMap.put(null, "1");
//        System.out.println(concurrentHashMap.containsKey(null));
//        System.out.println(concurrentHashMap.get(null));
//        System.out.println(concurrentHashMap.containsKey(null));
        concurrentHashMap.put("1", null);
    }

    @Test
    public void testBlockAndReadTree() {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < 10; i++) {
            map.put(i * 16, i);
        }

        System.out.println(Integer.MAX_VALUE);
    }

    @Test
    public void compress() {
        String str = "[\n" +
                "    {\n" +
                "        \"fromNode\":\"ReadData_ykbyc34c9\",\n" +
                "        \"uid\":\"edge_9w1mqfb4g\",\n" +
                "        \"fromSlot\":\"ReadData_ykbyc34c9_out_0\",\n" +
                "        \"toSlot\":\"GuaranteeRisk_5bx39hc1q_in_0\",\n" +
                "        \"toNode\":\"GuaranteeRisk_5bx39hc1q\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"fromNode\":\"GuaranteeRisk_5bx39hc1q\",\n" +
                "        \"uid\":\"edge_5c02fard7\",\n" +
                "        \"fromSlot\":\"GuaranteeRisk_5bx39hc1q_out_0\",\n" +
                "        \"toSlot\":\"WriteData_q41enh8pc_in_0\",\n" +
                "        \"toNode\":\"WriteData_q41enh8pc\"\n" +
                "    }\n" +
                "]";
        System.out.println(JSON.toJSONString(JSON.parse(str)));
    }
}
