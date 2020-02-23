package com.zhou.haizhi.nexus.spi;

/**
 * Create by zhoumingbing on 2019-12-27
 */
public class ASPIServiceImpl implements SPIService {
    @Override
    public String echo() {
        return "A spi service ... ";
    }
}
