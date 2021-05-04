package com.zhou.haizhi.nexus.design.factory.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 发放奖品的响应对象
 *
 * @author zhoumingbing
 * @data 2021/5/4
 */
@Data
@AllArgsConstructor
public class AwardRes {

    /**
     * 响应码
     */
    private String code;
    /**
     * 描述
     */
    private String info;
}
