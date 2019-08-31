package com.example.demo.service.impl;

import com.example.demo.model.AyProduct;
import com.example.demo.model.AyUserKillProduct;
import com.example.demo.model.KillStatus;
import com.example.demo.producer.AyProductKillProducer;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.AyUserKillProductService;
import com.example.demo.service.ProductService;
import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import javax.jms.Destination;
import java.util.*;
import java.util.concurrent.TimeUnit;


/**
 * 描述：商品服务
 * @author Ay
 * @create 2019/08/17
 **/
@Service
public class ProductServiceImpl implements ProductService {

    @Resource
    private ProductRepository productRepository;

    @Resource
    private AyUserKillProductService ayUserKillProductService;
    //日志
    Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);



    /**
     * 查询所有商品
     * @return
     */
    @Override
    public List<AyProduct> findAll() {
        try{
            List<AyProduct> ayProducts = productRepository.findAll();
            return ayProducts;
        }catch (Exception e){
            logger.error("ProductServiceImpl.findAll error", e);
            return Collections.EMPTY_LIST;
        }
    }

    //注入redisTemplate对象
    @Resource
    private RedisTemplate redisTemplate;
    //定义缓存key
    private static final String KILL_PRODUCT_LIST = "kill_product_list";

    /**
     * 查询商品数据（带缓存）
     * @return
     */
    @Override
    public Collection<AyProduct> findAllCache() {
        try{
            //从缓存中查询商品数据
            Map<Integer, AyProduct> productMap =
                    redisTemplate.opsForHash().entries(KILL_PRODUCT_LIST);
            Collection<AyProduct> ayProducts = null;
            //如果缓存中查询不到商品数据
            if(CollectionUtils.isEmpty(productMap)){
                //从数据库中查询商品数据
                ayProducts = productRepository.findAll();
                //将商品list转换为商品map
                productMap = convertToMap(ayProducts);
                //将商品数据保存到缓存中
                redisTemplate.opsForHash().putAll(KILL_PRODUCT_LIST, productMap);
                //设置缓存数据的过期时间，这里设置10s，具体时间需要结合业务需求而定
                //如果商品数据变化少，过期时间可以设置长一点；反之，过期时间可以设置短一点
                redisTemplate.expire(KILL_PRODUCT_LIST,10000 , TimeUnit.MILLISECONDS);
                return ayProducts;
            }
            ayProducts = productMap.values();
            return ayProducts;
        }catch (Exception e){
            logger.error("ProductServiceImpl.findAllCache error", e);
            return Collections.EMPTY_LIST;
        }
    }

    /**
     * list转换为map
     * @param ayProducts
     * @return
     */
    private Map<Integer, AyProduct> convertToMap(Collection<AyProduct> ayProducts){
        if(CollectionUtils.isEmpty(ayProducts)){
            return Collections.EMPTY_MAP;
        }
        Map<Integer, AyProduct> productMap = new HashMap<>(ayProducts.size());
        for(AyProduct product: ayProducts){
            productMap.put(product.getId(), product);
        }
        return productMap;
    }

//    /**
//     * 秒杀商品
//     * @param productId 商品id
//     * @param userId 用户id
//     * @return
//     */
//    @Override
//    public AyProduct killProduct(Integer productId, Integer userId) {
//        //查询商品
//        AyProduct ayProduct = productRepository.findById(productId).get();
//        //判断商品是否还有库存
//        if(ayProduct.getNumber() < 0){
//            return null;
//        }
//        //设置商品的库存：原库存数量 - 1
//        ayProduct.setNumber(ayProduct.getNumber() - 1);
//        //更新商品库存
//        ayProduct = productRepository.save(ayProduct);
//        //保存商品的秒杀记录
//        AyUserKillProduct killProduct = new AyUserKillProduct();
//        killProduct.setCreateTime(new Date());
//        killProduct.setProductId(productId);
//        killProduct.setUserId(userId);
//        //设置秒杀状态
//        killProduct.setState(KillStatus.SUCCESS.getCode());
//        //保存秒杀记录详细信息
//        ayUserKillProductService.save(killProduct);
//
//        //商品秒杀成功后，更新缓存中商品库存数量
//        redisTemplate.opsForHash().put(KILL_PRODUCT_LIST, killProduct.getProductId(),ayProduct);
//        return ayProduct;
//    }
//}

    @Resource
    private AyProductKillProducer ayProductKillProducer;

    //队列
    private static Destination destination = new ActiveMQQueue("ay.queue.asyn.save");

    /**
     * 秒杀商品(引入MQ)
     * @param productId 商品id
     * @param userId 用户id
     * @return
     */
    @Override
    public AyProduct killProduct(Integer productId, Integer userId) {
        //查询商品
        AyProduct ayProduct = productRepository.findById(productId).get();
        //判断商品是否还有库存
        if(ayProduct.getNumber() < 0){
            return null;
        }
        //设置商品的库存：原库存数量 - 1
        ayProduct.setNumber(ayProduct.getNumber() - 1);
        //更新商品库存
        ayProduct = productRepository.save(ayProduct);
        //保存商品的秒杀记录
        AyUserKillProduct killProduct = new AyUserKillProduct();
        killProduct.setCreateTime(new Date());
        killProduct.setProductId(productId);
        killProduct.setUserId(userId);
        //设置秒杀状态
        killProduct.setState(KillStatus.SUCCESS.getCode());
        //保存秒杀记录详细信息
        //ayUserKillProductService.save(killProduct);
        //异步保存商品的秒杀记录
        ayProductKillProducer.sendMessage(destination, killProduct);

        //商品秒杀成功后，更新缓存中商品库存数量
        redisTemplate.opsForHash().put(KILL_PRODUCT_LIST, killProduct.getProductId(),ayProduct);
        return ayProduct;
    }
}


