package com.zhou.haizhi.nexus.data_structure.link;

/**
 * Create by zhoumingbing on 2020-02-23
 */
public class Main {
    public static void main(String[] args) {
        LinkList<Integer> linkList = new LinkList<>();
        for (int i = 0; i < 5; i++) {
            linkList.addFirst(i);
            System.out.println(linkList);
        }

        linkList.add(3,666);
        System.out.println(linkList);
    }
}
