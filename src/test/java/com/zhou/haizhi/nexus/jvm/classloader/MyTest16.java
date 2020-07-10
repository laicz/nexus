package com.zhou.haizhi.nexus.jvm.classloader;

import java.io.*;
import java.util.concurrent.TimeUnit;

/**
 * 自定义ClassLoader
 * 多个ClassLoader如果不是父子关系，则可以将多个class在不同的ClassLoader同时加载
 * Create by zhoumingbing on 2020-03-26
 */
public class MyTest16 extends ClassLoader {

    private String classLoaderName;

    private final String fileExatension = ".class";

    private String classPath;

    /**
     * 默认的父ClassLoader是应用加载器
     *
     * @param classLoaderName
     */
    public MyTest16(String classLoaderName) {
        super();
        this.classLoaderName = classLoaderName;
    }

    /**
     * 自定义父类加载器
     *
     * @param parent          显示指定父加载
     * @param classLoaderName
     */
    public MyTest16(ClassLoader parent, String classLoaderName) {
        super(parent);
        this.classLoaderName = classLoaderName;
    }

    /**
     * 找到class对象
     *
     * @param name class对象名称
     * @return
     * @throws ClassNotFoundException
     */
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] bytes = loadClassData(name);
        return defineClass(name, bytes, 0, bytes.length);
    }

    /**
     * 真正要加载的类的名字
     *
     * @param name
     * @return
     */
    private byte[] loadClassData(String name) {
        InputStream is = null;
        byte[] data = null;
        ByteArrayOutputStream baos = null;
        try {
            String filePath = this.classPath + "MyTest1" + fileExatension;
            is = new FileInputStream(new File(filePath));
            baos = new ByteArrayOutputStream();
            int ch = 0;
            while ((ch = is.read()) != -1) {
                baos.write(ch);
            }
            data = baos.toByteArray();
        } catch (Exception e) {

        } finally {

            try {
                if (is != null) {
                    is.close();
                }
                if (baos != null) {
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return data;
    }

    /**
     * 两个ClassLoader能够组成不同的命名空间
     *
     * @param args
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws ClassNotFoundException
     */
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException, InterruptedException {
        MyTest16 test16 = new MyTest16("classLoader1");
        test16.classPath = "/Users/haizhi/Desktop/";
        Class<?> clazz = test16.loadClass("com.zhou.haizhi.nexus.jvm.passive_use.MyTest1");
        System.out.println(clazz);
        System.out.println(clazz.hashCode());
        Object o = clazz.newInstance();
        System.out.println(o + " : classLoader -> " + o.getClass().getClassLoader());

        test16 = null;
        clazz = null;
        o = null;
        System.gc();
        System.out.println("---------------------------------------------------");

        test16 = new MyTest16("classLoader1");
        test16.classPath = "/Users/haizhi/Desktop/";
        clazz = test16.loadClass("com.zhou.haizhi.nexus.jvm.passive_use.MyTest1");
        System.out.println(clazz);
        System.out.println(clazz.hashCode());
        o = clazz.newInstance();
        System.out.println(o + " : classLoader -> " + o.getClass().getClassLoader());

    }
}
