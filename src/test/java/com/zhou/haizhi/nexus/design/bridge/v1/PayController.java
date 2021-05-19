package com.zhou.haizhi.nexus.design.bridge.v1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * @author zhoumingbing
 * @data 2021/5/5
 */
public class PayController {

    private Logger logger = LoggerFactory.getLogger(PayController.class);

    /**
     * 从 if else 的实现方式来看，是两种不同类型的组合，因此，可以将支付方式和支付模式进行分离
     * @param uId
     * @param tradeId
     * @param amount
     * @param channelType
     * @param modelType
     * @return
     */
    public boolean doPay(String uId, String tradeId, BigDecimal amount, int channelType, int modelType) {
        //微信支付
        if (1 == channelType) {
            if (1 == modelType) {
                logger.info("密码支付");
            } else if (2 == modelType) {
                logger.info("人脸支付");
            } else if (3 == modelType) {
                logger.info("指纹支付");
            }
        } else if (2 == channelType) {
            if (1 == modelType) {
                logger.info("密码支付");
            } else if (2 == modelType) {
                logger.info("人脸支付");
            } else if (3 == modelType) {
                logger.info("指纹支付");
            }
        } else {
            throw new UnsupportedOperationException("不支持该支付类型");
        }
        return true;
    }

}
