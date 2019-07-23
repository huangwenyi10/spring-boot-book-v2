package com.example.demo.producer;

import com.example.demo.model.AyMood;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.jms.Destination;

/**
 * 生产者
 * @author Ay
 * @date 2017/11/30
 */
@Service
public class AyMoodProducer{

    @Resource
    private JmsMessagingTemplate jmsMessagingTemplate;

    public void sendMessage(Destination destination, final String message) {
        jmsMessagingTemplate.convertAndSend(destination, message);

    }

    public void sendMessage(Destination destination, final AyMood ayMood) {
        jmsMessagingTemplate.convertAndSend(destination, ayMood);
    }


}
