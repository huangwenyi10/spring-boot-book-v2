package com.example.demo.service;

import com.example.demo.model.AyUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.Future;

/**
 * @author Ay
 * @create 2019/07/03
 **/
public interface AyUserService {

    AyUser findById(String id);
    List<AyUser> findAll();
    AyUser save(AyUser ayUser);
    void delete(String id);
    //分页
    Page<AyUser> findAll(Pageable pageable);

    List<AyUser> findByName(String name);
    List<AyUser> findByNameLike(String name);
    List<AyUser> findByIdIn(Collection<String> ids);

    AyUser findByNameAndPassword(String name, String password);

    //异步查询
    Future<List<AyUser>> findAsynAll();

    AyUser findByNameAndPasswordRetry(String name, String password);

    AyUser findByUserName(String name);

    //查询用户数量
    Long findUserTotalNum();
}
