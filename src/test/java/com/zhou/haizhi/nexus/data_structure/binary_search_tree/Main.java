package com.zhou.haizhi.nexus.data_structure.binary_search_tree;

import java.util.List;

/**
 * Create by zhoumingbing on 2020-02-23
 */
public class Main {

    public static void main(String[] args) {
        BinarySearchTree<String> bst = new BinarySearchTree<>();
        bst.add("10");
        bst.add("8");
        bst.add("12");
        bst.add("13");
        bst.add("17");
        bst.add("2");
        bst.add("5");

        List<BinarySearchTree<String>.Node> nodes = bst.traverse();
        for (BinarySearchTree<String>.Node node : nodes) {
            System.out.print(node + " -> ");
        }
    }

}
