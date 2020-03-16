package com.zhou.haizhi.nexus.spi;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * Create by zhoumingbing on 2019-12-27
 */
public class SPIServiceTest {

    /**
     * 通过使用ServiceLoader.load()的方式能够将数据加载入
     * @param args
     */
    public static void main(String[] args) {
        ServiceLoader<SPIService> serviceLoaders = ServiceLoader.load(SPIService.class);

        Iterator<SPIService> iterator = serviceLoaders.iterator();
        while (iterator.hasNext()) {
            SPIService spiService = iterator.next();
            System.out.println(spiService.getClass().getName() + " : " + spiService.echo());
        }
    }
}
