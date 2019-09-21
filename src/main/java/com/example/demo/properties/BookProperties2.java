package com.example.demo.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 描述：自定义配置（优雅实现）
 * @author Ay
 * @create 2019/08/31
 **/
@ConfigurationProperties(prefix="com.ay.book")
public class BookProperties2 {

    private String name;

    private String author;

    private String desc;

    private String randomValue;

    private Integer randomInt;

    private Long randomLong;

    private String randomUuid;

    private Integer randomLen;

    private Integer randomRange;


    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getRandomValue() {
        return randomValue;
    }

    public void setRandomValue(String randomValue) {
        this.randomValue = randomValue;
    }

    public String getRandomUuid() {
        return randomUuid;
    }

    public void setRandomUuid(String randomUuid) {
        this.randomUuid = randomUuid;
    }

    public Integer getRandomInt() {
        return randomInt;
    }

    public void setRandomInt(Integer randomInt) {
        this.randomInt = randomInt;
    }

    public Long getRandomLong() {
        return randomLong;
    }

    public void setRandomLong(Long randomLong) {
        this.randomLong = randomLong;
    }

    public Integer getRandomLen() {
        return randomLen;
    }

    public void setRandomLen(Integer randomLen) {
        this.randomLen = randomLen;
    }

    public Integer getRandomRange() {
        return randomRange;
    }

    public void setRandomRange(Integer randomRange) {
        this.randomRange = randomRange;
    }
}
