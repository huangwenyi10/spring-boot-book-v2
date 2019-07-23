package com.example.demo.repository;

import com.example.demo.model.AyUserAttachmentRel;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * 描述：用户附件Repository
 * @author Ay
 * @date   2017/12/4.
 */
public interface AyUserAttachmentRelRepository 
extends MongoRepository<AyUserAttachmentRel,String> {

}
