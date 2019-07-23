package com.example.demo.service;

import com.example.demo.model.AyMood;

/**
 * 描述：微信说说服务层
 * @author Ay
 * @date   2017/12/2.
 */
public interface AyMoodService {
    
    AyMood save(AyMood ayMood);

    String asynSave(AyMood ayMood);
}
