package com.zhou.haizhi.nexus.design.factory.v2;

/**
 * 按照不同的奖品类型，生产具体的奖品服务类
 * 优点：避免创建者和具体的产品逻辑耦合、满足单一职责，
 * 每一个具体的业务逻辑在自己所属的类中完成，满足开闭原则、无需吸怪使用代用方法就可以实在程序中引入新的产品原型
 * 缺点:比如有非常多的奖品类型，那么实现的子类就会急速扩张
 *
 * @author zhoumingbing
 * @data 2021/5/4
 */
public class StoreFactory {
    public ICommodity getCommodityService(Integer commodityType) {
        if (null == commodityType) return null;
        if (1 == commodityType) return new CouponCommodityService();
        if (2 == commodityType) return new GoodsCommodityService();
        if (3 == commodityType) return new CardCommodityService();
        throw new RuntimeException("不存在的商品服务类型");
    }
}
