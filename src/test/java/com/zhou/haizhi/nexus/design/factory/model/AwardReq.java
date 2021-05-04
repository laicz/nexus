package com.zhou.haizhi.nexus.design.factory.model;

import lombok.Data;

import java.util.Map;

/**
 * 发放奖品请求对象
 * @author zhoumingbing
 * @data 2021/5/4
 */
@Data

public class AwardReq {

    /**
     * 用户唯一ID
     */
    private String uId;

    /**
     * 奖品类型
     */
    private Integer awardType;

    /**
     * 奖品编号：sku，couponNumber,cardId
     */
    private String awardNumber;

    /**
     * 业务ID，防重复
     */
    private String bizId;

    /**
     * 扩展信息
     */
    private Map<String,String> extMap;



}
