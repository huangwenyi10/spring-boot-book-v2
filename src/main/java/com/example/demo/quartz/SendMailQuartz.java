package com.example.demo.quartz;

//import com.example.demo.mail.SendJunkMailService;
import com.example.demo.model.AyUser;
import com.example.demo.service.AyUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * 描述：定时器类
 * @author Ay
 * @date   2017/11/18
 */
@Component
@Configurable
@EnableScheduling
public class SendMailQuartz {

    //日志对象
    private static final Logger logger = LogManager.getLogger(SendMailQuartz.class);

//    @Resource
//    private SendJunkMailService sendJunkMailService;
    @Resource
    private AyUserService ayUserService;


    //每5秒执行一次
    @Scheduled(cron = "*/5 * *  * * * ")
    public void reportCurrentByCron(){
//        List<AyUser> userList = ayUserService.findAll();
//        if (userList == null || userList.size() <= 0) return;
        //发送邮件
        //sendJunkMailService.sendJunkMail(userList);
//        logger.info("定时器运行了!!!");

    }

}
