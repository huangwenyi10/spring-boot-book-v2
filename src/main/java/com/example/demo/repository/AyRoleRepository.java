package com.example.demo.repository;

import com.example.demo.model.AyRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 描述：用户角色Repository
 * @author Ay
 * @date   2017/12/10.
 */
public interface AyRoleRepository extends JpaRepository<AyRole,String> {

}
