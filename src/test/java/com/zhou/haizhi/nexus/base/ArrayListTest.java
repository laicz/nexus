package com.zhou.haizhi.nexus.base;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Create by zhoumingbing on 2020-01-13
 */
public class ArrayListTest {

    @Test
    public void iterator() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
        arrayList.add("4");
        arrayList.add("5");
        Iterator<String> iterator = arrayList.iterator();
        while (iterator.hasNext()) {
            String value = iterator.next();
            if (StringUtils.equals(value,"2")){
                iterator.remove();
            }
        }
    }
}
