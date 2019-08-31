package com.example.demo.model;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
/**
 * 描述：用户秒杀商品记录
 * @author Ay
 * @create 2019/08/17
 **/
@Entity
@Table(name = "ay_user_kill_product")
public class AyUserKillProduct implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    /**
     * 商品id
     */
    private Integer productId;
    /**
     * 用户id
     */
    private Integer userId;
    /**
     * 状态，-1：无效；0：成功；1：已付款'
      */
    private Integer state;
    /**
     * 创建时间
     */
    private Date createTime;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
