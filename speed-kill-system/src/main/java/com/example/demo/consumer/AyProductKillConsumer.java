package com.example.demo.consumer;

import com.example.demo.model.AyUserKillProduct;
import com.example.demo.service.AyUserKillProductService;
import com.example.demo.service.impl.ProductServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 消费者
 * @author Ay
 * @date   2017/11/30
 */
@Component
public class AyProductKillConsumer {

    //日志
    Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Resource
    private AyUserKillProductService ayUserKillProductService;

    /**
     * 消费消息
     * @param killProduct
     */
    @JmsListener(destination = "ay.queue.asyn.save")
    public void receiveQueue(AyUserKillProduct killProduct){
        //保存秒杀商品数据
        ayUserKillProductService.save(killProduct);
        //记录日志
        logger.info("ayUserKillProductService save, and killProduct: " + killProduct);
    }
}