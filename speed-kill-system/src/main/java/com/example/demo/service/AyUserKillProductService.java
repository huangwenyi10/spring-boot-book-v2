package com.example.demo.service;

import com.example.demo.model.AyUserKillProduct;

/**
 * 描述：用户秒杀商品记录接口
 * @author Ay
 * @create 2019/08/20
 **/
public interface AyUserKillProductService {

    /**
     * 保存用户秒杀商品记录
     * @param killProduct
     * @return
     */
    AyUserKillProduct save(AyUserKillProduct killProduct);
}
