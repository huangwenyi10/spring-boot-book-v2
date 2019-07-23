package com.example.demo.mail;

import com.example.demo.model.AyUser;

import java.util.List;

/**
 * 描述：发送用户邮件服务
 * @author Ay
 * @date   2017/11/19
 */
public interface SendJunkMailService {

    boolean sendJunkMail(List<AyUser> ayUser);
}
