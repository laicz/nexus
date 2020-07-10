package com.zhou.haizhi.nexus.jvm.classloader;

/**
 * 在运行期，一个java类是由该类的完全限定名（binary name，二进制）和用于加载该类的定义类加载器（defining loader）所共同决定，
 * 如果同样名字的类是由两个不同的加载器所加载，那么这些类就是不同的，即便.class文字的字节码完全一样，并且是同样的位置加载亦完成
 * Create by zhoumingbing on 2020-04-21
 */
public class MyTest23 {

    public static void main(String[] args) {
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));

        System.out.println("----------------------------------");
        System.out.println(System.getProperty("java.system.class.loader"));
    }

}
