package com.zhou.haizhi.nexus.spring.proxy.javaassist;

/**
 * Create by zhoumingbing on 2020-05-21
 */
public class Person {

    private String name = "three mao";

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
