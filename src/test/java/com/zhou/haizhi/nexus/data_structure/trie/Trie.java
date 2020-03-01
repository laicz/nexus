package com.zhou.haizhi.nexus.data_structure.trie;

import org.junit.platform.commons.util.StringUtils;

import java.util.TreeMap;

/**
 * Create by zhoumingbing on 2020-02-29
 */
public class Trie {

    private Node root;
    private int size;

    public Trie() {
        root = new Node();
    }

    public int getSize() {
        return this.size;
    }

    /**
     * 往trie中添加单词
     *
     * @param word
     */
    public void add(String word) {
        if (StringUtils.isBlank(word)) {
            throw new IllegalArgumentException("word must be not blank");
        }
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        //如果word不为true，则说明单词是之前不存在的，这次新添加的
        if (!cur.word) {
            cur.word = true;
            size++;
        }
    }

    /**
     * 添加单词 - 递归写法
     *
     * @param word
     */
    public void add1(String word) {
        if (StringUtils.isBlank(word)) {
            throw new IllegalArgumentException("word must be not blank");
        }
        Node cur = root;
        int index = 0;
        doAdd(cur, word, index);
    }

    /**
     * 是否含有该单词
     *
     * @param word
     * @return
     */
    public boolean contains(String word) {
        if (StringUtils.isBlank(word)) {
            throw new IllegalArgumentException("word must be not blank");
        }
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            cur = cur.next.get(c);
            if (cur == null) {
                return false;
            }
        }
        return cur.word;
    }

    /**
     * 判断是否存在前缀
     *
     * @param prefix
     * @return
     */
    public boolean startWith(String prefix) {
        if (StringUtils.isBlank(prefix)) {
            throw new IllegalArgumentException("prefix must be not blank");
        }
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            cur = cur.next.get(c);
            if (cur == null) {
                return false;
            }
        }
        return true;
    }

    /**
     * 采用递归匹配，支持 . 简单正则表达式
     *
     * @param word
     * @return
     */
    public boolean search(String word) {
        return match(root, word, 0);
    }

    private boolean match(Node node, String word, int index) {
        if (index == word.length()) {
            return node.word;
        }
        char c = word.charAt(index);
        if (c != '.') {
            Node cur = node.next.get(c);
            if (cur == null) {
                return false;
            }
            return match(cur, word, index + 1);
        } else {
            for (char nextChar : node.next.keySet()) {
                if (match(node.next.get(nextChar), word, index + 1)) {
                    return true;
                }
            }
            return false;
        }
    }

    private void doAdd(Node cur, String word, int index) {
        Node next = cur.next.get(word.charAt(index));
        if (next == null) {
            next = new Node();
            cur.next.put(word.charAt(index), next);
        }
        if (index == word.length() - 1) {
            next.word = true;
            return;
        }
        doAdd(cur, word, index++);
    }

    private class Node {
        private boolean word;
        private TreeMap<Character, Node> next;

        public Node() {
        }

        public Node(boolean word) {
            this.word = word;
            this.next = new TreeMap<>();
        }

        public Node(boolean word, TreeMap<Character, Node> next) {
            this.word = word;
            this.next = next;
        }
    }

}
