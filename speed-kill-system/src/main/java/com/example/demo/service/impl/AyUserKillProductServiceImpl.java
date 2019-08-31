package com.example.demo.service.impl;

import com.example.demo.model.AyUserKillProduct;
import com.example.demo.repository.AyUserKillProductRepository;
import com.example.demo.service.AyUserKillProductService;
import org.hibernate.annotations.Source;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 描述：
 * @author Ay
 * @create 2019/08/20
 **/
@Service
public class AyUserKillProductServiceImpl implements AyUserKillProductService {
    //注入ayUserKillProductRepository类
    @Resource
    private AyUserKillProductRepository ayUserKillProductRepository;

    /**
     * 保存用户秒杀商品记录
     * @param killProduct
     * @return
     */
    @Override
    public AyUserKillProduct save(AyUserKillProduct killProduct) {
        return ayUserKillProductRepository.save(killProduct);
    }
}
