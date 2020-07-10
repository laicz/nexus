package com.zhou.haizhi.nexus.jvm.byte_code;

/**
 * Create by zhoumingbing on 2020-04-22
 */
public class ByteCode001 {

    public static void main(String[] args) {
        System.out.println(System.getProperty("java.class.path").replaceAll(":", System.lineSeparator()));
        System.out.println("---------------------------------------");
        System.out.println(System.getProperty("java.ext.dirs").replaceAll(":", System.lineSeparator()));
        System.out.println("---------------------------------------");
        System.out.println(System.getProperty("sun.boot.class.path").replaceAll(":", System.lineSeparator()));
    }

}
