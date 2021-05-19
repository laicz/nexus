package com.zhou.haizhi.nexus.design.model;

/**
 * pizza父类，所有的pizza类都需要实现这个接口
 *
 * @author zhoumingbing
 * @data 2021/5/2
 */
public abstract class Pizza {

    String name;
    String dough;


    void prepare(){
        System.out.println();
    }

    void bake(){

    }

    void cut(){

    }

    void box(){

    }
}
