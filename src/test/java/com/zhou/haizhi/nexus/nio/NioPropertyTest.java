package com.zhou.haizhi.nexus.nio;

import org.junit.Test;

import java.nio.channels.spi.SelectorProvider;

/**
 * Create by zhoumingbing on 2020-04-13
 */
public class NioPropertyTest {

    @Test
    public void selectorProvider(){
        String cn = System.getProperty("java.nio.channels.spi.SelectorProvider");
        System.out.println(cn);
        SelectorProvider selectorProvider = SelectorProvider.provider();
    }
}
