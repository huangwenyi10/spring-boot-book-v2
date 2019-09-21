package com.ay.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Ay
 * @create 2019/09/08
 **/

@Configuration
@ConditionalOnClass(HelloService.class)
@EnableConfigurationProperties(HelloServiceProperties.class)
public class AyStarterEnableAutoConfiguration {


    private final HelloServiceProperties helloServiceProperties;

    @Autowired
    public AyStarterEnableAutoConfiguration(HelloServiceProperties helloServiceProperties) {

        short s1 = 1; s1 += 1;

        this.helloServiceProperties = helloServiceProperties;
    }

    @Bean
    @ConditionalOnProperty(prefix = "hello.service", name = "enable", havingValue = "true")
    HelloService helloService() {
        return new HelloService(helloServiceProperties.getPrefix(), helloServiceProperties.getSuffix());
    }
}
