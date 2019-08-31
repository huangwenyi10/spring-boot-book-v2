package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 *  描述：用户类
 * @author Ay
 * @create 2019/07/02
 **/
@Entity
@Table(name = "ay_user")
public class AyUser implements Serializable {

    //主键
    @Id
    private Integer id;
    //用户名
    private String name;
    //电话号码
    private String phoneNumber;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
