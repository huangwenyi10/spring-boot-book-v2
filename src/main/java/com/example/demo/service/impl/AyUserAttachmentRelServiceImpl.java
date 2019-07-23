package com.example.demo.service.impl;

import com.example.demo.model.AyUserAttachmentRel;
import com.example.demo.repository.AyUserAttachmentRelRepository;
import com.example.demo.service.AyUserAttachmentRelService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 描述：用户附件实现层
 * @author  Ay 
 * @date    2017/12/4.
 */
@Service
public class AyUserAttachmentRelServiceImpl implements AyUserAttachmentRelService {

    @Resource
    private AyUserAttachmentRelRepository ayUserAttachmentRelRepository;

    public AyUserAttachmentRel save(AyUserAttachmentRel ayUserAttachmentRel){
        return ayUserAttachmentRelRepository.save(ayUserAttachmentRel);
    }
}
