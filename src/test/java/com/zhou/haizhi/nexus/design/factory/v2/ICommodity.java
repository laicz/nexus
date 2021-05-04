package com.zhou.haizhi.nexus.design.factory.v2;

import java.util.Map;

/**
 * 奖品发放接口 - 不同的接口发放接口都得实现这个接口
 *
 * @author zhoumingbing
 * @data 2021/5/4
 */
public interface ICommodity {

    /**
     * 奖品发放接口
     * @param uId
     * @param commodityId
     * @param bizId
     * @param extMap
     */
    void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap);

}
