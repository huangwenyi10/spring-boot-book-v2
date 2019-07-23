package com.example.demo.service;

import com.example.demo.model.AyUserRoleRel;

import java.util.List;

/**
 * 描述：用户角色关联Service
 * @author 阿毅
 * @date   2017/10/14
 */
public interface AyUserRoleRelService {

    List<AyUserRoleRel> findByUserId(String userId);
}
