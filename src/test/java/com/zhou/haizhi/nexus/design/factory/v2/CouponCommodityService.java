package com.zhou.haizhi.nexus.design.factory.v2;

import com.alibaba.fastjson.JSON;
import com.zhou.haizhi.nexus.design.factory.coupon.CouponResult;
import com.zhou.haizhi.nexus.design.factory.coupon.CouponService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * 优惠券发放接口 - 实现奖品发放接口
 *
 * @author zhoumingbing
 * @data 2021/5/4
 */
public class CouponCommodityService implements ICommodity {

    private final Logger logger = LoggerFactory.getLogger(CouponCommodityService.class);

    private final CouponService couponService = new CouponService();

    @Override
    public void sendCommodity(String uId, String commodityId, String bizId, Map<String, String> extMap) {
        CouponResult couponResult = couponService.sendCoupon(uId, commodityId, bizId);
        logger.info("请求参数[优惠券] => uId：{} commodityId：{} bizId：{} extMap：{}", uId, commodityId, bizId, JSON.toJSON(extMap));
        logger.info("测试结果[优惠券]：{}", JSON.toJSON(couponResult));
        if (!"0000".equals(couponResult.getCode())) throw new RuntimeException(couponResult.getInfo());
    }
}
