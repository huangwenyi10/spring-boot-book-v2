package com.example.demo.error;

/**
 * 描述：业务异常
 * @author Ay
 * @date   2017/12/3
 */
public class BusinessException extends RuntimeException{

    public BusinessException(){}
    
    public BusinessException(String message) {
        super(message);
    }
}
