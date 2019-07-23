package com.example.demo.dao;

import com.example.demo.model.AyUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 描述：用户DAO
 * @author Ay
 * @date   2017/11/20.
 */
@Mapper
public interface AyUserDao {

    /**
     *  描述：通过用户名和密码查询用户
     * @param name
     * @param password
     */
    AyUser findByNameAndPassword(@Param("name") String name,
                                 @Param("password") String password);

}
