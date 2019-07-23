package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author Ay
 * @create 2019/07/02
 **/
@Entity
@Table(name = "ay_user")
public class AyUser implements Serializable {

    //主键
    @Id
    private String id;
    //用户名
    private String name;
    //密码
    private String password;
    //邮箱
    private String mail;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
