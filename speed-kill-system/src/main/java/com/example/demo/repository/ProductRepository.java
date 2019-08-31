package com.example.demo.repository;

import com.example.demo.model.AyProduct;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 描述：商品Repository
 * @author Ay
 * @create 2019/08/17
 **/
public interface ProductRepository extends JpaRepository<AyProduct,Integer> {

}
