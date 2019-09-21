package com.example.demo.controller;
import com.example.demo.model.AyProduct;
import com.example.demo.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;

/**
 * 描述：
 * @author Ay
 * @create 2019/08/17
 **/
@Controller
@RequestMapping("/products")
public class ProductController {

    @Resource
    private ProductService productService;

    /**
     * 查询所有的商品
     * @param model
     * @return
     */
    @RequestMapping("/all")
    public String findAll(Model model){
        List<AyProduct> products = productService.findAll();
        model.addAttribute("products", products);
        return "product_list";
    }

    /**
     * 查询所有的商品（缓存）
     * @param model
     * @return
     */
    @RequestMapping("/all/cache")
    public String findAllCache(Model model){
        Collection<AyProduct> products = productService.findAllCache();
        model.addAttribute("products", products);
        return "product_list";
    }

    /**
     * 秒杀商品
     * @param model
     * @param productId 商品id
     * @param userId  用户id
     * @return
     */
    @RequestMapping("/{id}/kill")
    public String killProduct(Model model,
                              @PathVariable("id") Integer productId,
                              @RequestParam("userId") Integer userId){
        AyProduct ayProduct = productService.killProduct(productId, userId);
        if(null != ayProduct){
            return "success";
        }
        return "fail";
    }
}

