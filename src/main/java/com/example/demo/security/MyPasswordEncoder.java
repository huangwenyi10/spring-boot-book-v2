package com.example.demo.security;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 描述：
 * @author ay
 * @date 2019/07/07
 */
public class MyPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}
