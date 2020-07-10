package com.zhou.haizhi.nexus.base.xml;

import org.apache.commons.digester3.Digester;

/**
 * Create by zhoumingbing on 2020-05-31
 */
public class DigesterDemo {
    public static void main(String[] args) {
        Digester digester = new Digester();
        digester.setValidating(false);
        digester.addObjectCreate("name","java.lang.String");
        digester.addSetProperties("name");
        digester.addObjectCreate("","java.lang.String");
        digester.addSetProperties("value");
    }
}
