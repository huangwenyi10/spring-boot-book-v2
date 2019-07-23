package com.example.demo.model;

import javax.persistence.Id;

/**
 * 描述：用户头像关联表
 * @author  Ay
 * @date    2017/12/4.
 */
public class AyUserAttachmentRel {

    @Id
    private String id;
    private String userId;
    private String fileName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
