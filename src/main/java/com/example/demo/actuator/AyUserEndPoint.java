package com.example.demo.actuator;

import com.example.demo.service.AyUserService;
import org.apache.tomcat.util.net.AbstractEndpoint;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.web.annotation.WebEndpoint;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 描述：自定义端点
 * @author  Ay
 * @date    2017/12/9.
 */
@Component
@Endpoint(id="userEndPoints")
public class AyUserEndPoint{

    @Resource
    private AyUserService ayUserService;

    @ReadOperation
    public Map<String, Object> invoke() {
        Map<String, Object> map = new HashMap<String, Object>();
        //当前时间
        map.put("current_time",new Date());
        //用户总数量
        map.put("user_num",ayUserService.findUserTotalNum());
        return map;
    }
}
